import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SectionGrabber {
	public static String getSections() throws IOException {
		String result = "";
		Document doc = Jsoup.connect("https://www.wikipedia.org/wiki/Donald_Trump").get();
         Elements keywords = doc.select("span[class=toctext]");
         
         for(Element keyword : keywords) {
      	   result += keyword.text() + "\n";
         }
		return result;
	}
	
	public static String grabSection(String id) throws IOException {
		String result = "";
		Document doc = Jsoup.connect("https://www.wikipedia.org/wiki/Elon_Musk").get();
        Elements keywords = doc.select("h2:has(span#" + id + ") + p, h3:has(span#" + id + ") + p ");
        
        for(Element keyword: keywords) {
        	result += keyword.text();
        }
		return result;
        
	}
	public static void main(String[] args) throws IOException {
//		System.out.println(getSections());
		System.out.println(grabSection("Childhood_and_family"));
	}

}
