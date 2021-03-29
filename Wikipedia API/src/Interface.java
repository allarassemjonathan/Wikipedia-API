import java.io.IOException;
import java.util.Scanner;

public class Interface {

	public static void main(String[] args) throws IOException {
		Wikipedia wiki = new Wikipedia();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Search: ");
		String query = sc.nextLine();
		System.out.println(wiki.search(query));
	}

}
