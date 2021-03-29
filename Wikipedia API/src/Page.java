import java.util.ArrayList;

public class Page {

	private String title;
	private String content;
	private ArrayList<String> images;
	private ArrayList<String> links;
	
	
	public Page() {
		
	}
	
	public Page(String title, String content,ArrayList<String> images, ArrayList<String> links) {
		this.title = title;
		this.content = content;
		this.images = new ArrayList<String>(images);
		this.links = new ArrayList<String>(links);
	}
	
	
	public Page(String content) {
		this.content = content;
	}
	
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
}
