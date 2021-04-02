import java.util.ArrayList;

public class Portion {
	private String title;
	private String content;
	private ArrayList<String> images;
	private ArrayList<String> links;
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public void setLinks(ArrayList<String> links) {
		this.links = new ArrayList<String>(links); 
	}
	
	public String getLinks() {
		String result = "";
		for(String link : links) {
			result += link + "\n";
		}
		return result;
	}
	
	public void setImages(ArrayList<String> images) {
		this.images = new ArrayList<String>(images);
	}
	
	public String getImages() {
		String result = "";
		for(String image : images) {
			result += image + "\n";
		}
		return result;
	}
	@Override
	public int hashCode() {
		int result = 17;
		result += 37*this.title.hashCode();
		result += 37*this.content.hashCode();
		result += 37*this.images.hashCode();
		result += 37*this.links.hashCode();
		return result;
	}
	
	
	@Override
	public boolean equals(Object other) {
		
		if(this == other) {
			return true;
		}
		
		if(!(other instanceof Portion)) {
			return false;
		}
		
		Portion portion = (Portion) other;
		
		return this.title.equals(portion.title) && this.content.equals(portion.content);
	}
	
	@Override 
	public String toString() {
		return "not implemented yet";
	}
	
}
