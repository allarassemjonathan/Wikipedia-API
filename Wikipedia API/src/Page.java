import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Page extends Portion{


	private ArrayList<String> sectionList;
	private String html;
	private boolean isAmbiguous;
	
	public Page(String query) {
		sectionList = new ArrayList<>();
		//TODO grab the html of the page
		html = "";
		isAmbiguous = false;
		try {
			Page page = new Page();
			String result = "";
			String cleanQuery = clean(query);
			Document document = Jsoup.connect(URL + cleanQuery).get();
			page.setTitle(document.title());
			
			Elements paragraphs = document.select("p");
			for(int i = 0; i < paragraphs.size(); i++) {
				if(paragraphs.get(i) == null) {
					paragraphs.remove(i);
				}
				if(paragraphs.get(i).text().equals(cleanQuery.substring(0, cleanQuery.length()-1) + " may refer to:")) {
					this.isAmbiguous = true;
				}
			}
			for(Element paragraph:paragraphs) {
				result += paragraph.text() + "\n";
			}

			if(this.isAmbiguous) {
				Elements suggestions = document.select("li");
				for(Element suggestion : suggestions) {
					result += suggestion.text() + "\n";
				}
			}
			this.content = result;
			page.setContent(result);
			
			Elements Dirtylinks = document.select("a[href]");
			ArrayList<String> links = new ArrayList<>();
			for(Element link : Dirtylinks) {
				links.add(link.text());
			}
			page.setLinks(links);
			
			Elements DirtyImages = document.select("img[src]");
			ArrayList<String> images = new ArrayList<>();
			for(Element image : DirtyImages) {
				images.add(image.text());
			}
			page.setImages(images);
			
			return page.content();
			}catch(org.jsoup.HttpStatusException e){
				Page page = new Page("The person/location/event you are searching does not exist");
				return page.content();
			}
	}
	
	public String getSectionTitle(String id) throws IOException{
		Document doc = Jsoup.connect("https://www.wikipedia.org/wiki/Elon_Musk").get();		
		Elements info = doc.select("h2:has(span#" + id + "), h3:has(span#" + id + ")");
		String sectionTitle = info.text();
		return sectionTitle;
	}
	
	public String getSectionContent(String id) throws IOException{
		Document doc = Jsoup.connect("https://www.wikipedia.org/wiki/Elon_Musk").get();		
		Elements info = doc.select("h2:has(span#" + id + ") + p, h3:has(span#" + id + ") + p");
		String sectionContent = "";
		for (Element lmnt : info) {
			sectionContent += lmnt + "\n";
		}
		return sectionContent;
	}
	
	public String getSection(String id) throws IOException{
		String section;
		section = getSectionTitle(id) + "\n" + getSectionContent(id);
		return section;
	}
	
	public String summary() {
		String summary = "";
		
		
		return summary;
	}
	
	public static String getInfo(String key) throws IOException {
		String format = "th:contains(" + key + ") + td";
		Document doc = Jsoup.connect("https://www.wikipedia.org/wiki/Elon_Musk").get();		
		Elements info = doc.select(format);
		return info.text();

}

}
