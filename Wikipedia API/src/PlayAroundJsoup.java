import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PlayAroundJsoup {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Document doc = (Document) Jsoup.connect("https://en.wikipedia.org/wiki/Michael_Jackson").get();
		Elements keywords = doc.select("th[style=width:22em]");
		for(Element keyword : keywords) {
			System.out.println(keyword.text());
		}
		
	}

}
