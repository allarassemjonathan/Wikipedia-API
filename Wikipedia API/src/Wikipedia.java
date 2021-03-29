import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Wikipedia {
	private static final String URL = "https://en.wikipedia.org/wiki/";
	private String content;
	private boolean isAmbiguous = false;
	private String title;
	private String html;
	private ArrayList<String> images;
	private ArrayList<String> links;
	private ArrayList<String> sections;
	
	public Page search(String query) throws IOException,  org.jsoup.HttpStatusException {
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
		
		return page;
		}catch(org.jsoup.HttpStatusException e){
			Page page = new Page("The person/location/event you are searching does not exist");
			return page;
		}
	}
	
	private String clean(String query) {
		String cleanQuery = "";
		String result = "";
		String [] words = query.split(" ");
		for(String word: words) {
			cleanQuery += word + "_";
		}
		return cleanQuery;
	}
	
//	public String title() {
//		return 
//	}
	public String suggest() {
		return "";
	}
	
	public String summary() {
		return "";
	}
	
}
