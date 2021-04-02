import java.util.ArrayList;

public class Portion {
	private String title;
	private String content;
	private ArrayList<String> images;
	private ArrayList<String> links;
	
	public String title() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String content() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String images() {
		String result = "";
		for(String image : images) {
			result += image + "\n";
		}
		return result;
	}
	
	public void setLinks(ArrayList<String> links) {
		this.links = new ArrayList<String>(links); 
	}
	
	public void setImages(ArrayList<String> images) {
		this.images = new ArrayList<String>(images);
	}
	
	public String links() {
		String result = "";
		for(String link : links) {
			result += link + "\n";
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
