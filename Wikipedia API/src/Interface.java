import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Interface {

	public static void main(String[] args) throws IOException {
//		Wikipedia wiki = new Wikipedia();
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("Search: ");
//		String query = sc.nextLine();
//		System.out.println(wiki.search(query));
		
		Document doc = Jsoup.connect("https://github.com/allarassemjonathan?tab=repositories").get();
		
		System.out.println(doc);
	}

}
