import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PlayAroundJsoup {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
		
	}

}
