package edu.dartmouth.cs.frameandtell;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

//import java.util.ArrayList;

@ParseClassName("Panel")
public class Panel extends ParseObject {

	private String mTitle;
	//private Story story;
	//	private ArrayList<String> mCaption= new ArrayList<String>();
	//	private String mCaption1;
	//	private String mCaption2;

	public Panel() {
		this.mTitle ="";
		//this.story = null;
	}

	public String getTitle() {
		return getString("title");
	}

	public void setTitle(String title) {
		//title = story.title;
		put("title", title);
	}

	public ParseUser getAuthor() {
		return getParseUser("author");
	}

	public void setAuthor(ParseUser user) {
		put("author", user);
	}

	public ParseFile getPhotoFile() {
		return getParseFile("photo");
	}

	public void setPhotoFile(ParseFile file) {
		put("photo", file);
	}

	public String getCaption() {
		return getString("caption");
	}

	public void setCaption(String caption) {
		put("caption", caption);
	}
	
	public void setTemplate(int templatetype)
	{
		put("template", templatetype);
	}
	
	public int getTemplate() {
		return getInt("template");
	}


	//	public String setTitle(String title) {
	//		this.mTitle = title;
	//	}
	//	
	//	public void setCaption(String caption) {
	//		this.mCaption.add(caption);
	//	}
	//	





}
