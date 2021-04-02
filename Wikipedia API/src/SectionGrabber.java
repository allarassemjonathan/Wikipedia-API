import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SectionGrabber {
	
	public static Elements getSections(String cleanQuery) throws IOException {
		Document doc = Jsoup.connect("https://www.wikipedia.org/wiki/" + cleanQuery).get();
        Elements keywords = doc.select("span[class=toctext]");
		return keywords;
	}
	
	public static String grabSection(String id) throws IOException {
		String query = "";
		Elements sections = getSections(query);
		String section_id = clean(id);
		for(Element section : sections) {
			
		}
		Document doc = (Document) Jsoup.connect("https://en.wikipedia.org/wiki/Elon_Musk").get();
		
		//Getting keywords
		Elements keywords = doc.select("span[class=toctext]");
		
		String id1 = "Childhood_and_family";
		String id2 = "Education";
		
		//Gets size
		Elements keyword1 = doc.select("h2:has(span#" + id1 + ") ~ p, h3:has(span#" + id1 + ") ~ p");
		Elements keyword2 = doc.select("h2:has(span#" + id2 + ") ~ p	, h3:has(span#" + id2 + ") ~ p");
		int size = keyword1.size() - keyword2.size();
		System.out.println(size);
		
		//Works
		 for (int i = 0; i < size; i++) {
			 System.out.println(keyword1.get(i).text());
		 }
		
		 //
//		Elements paragraphs = doc.select("h2:has(span#" + id1 + ") ~ p, h3:has(span#" + id1 + ") ~ p").select("h:lt(" + size +")");
		Elements paragraphs = doc.select("h2:has(span#" + id1 + ") ~ p:lt("+size+"), h3:has(span#" + id1 + ") ~ p:lt("+size+")");
		for(Element p : paragraphs) {
			System.out.println(p.text());
		}
		
		return result;
        
	}
	
	public static String clean(String query) {
		String cleanQuery = "";
		String result = "";
		String [] words = query.split(" ");
		for(String word: words) {
			cleanQuery += word + "_";
		}
		return cleanQuery;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(getSections());
//		System.out.println(grabSection("Childhood_and_family"));
	}

}
