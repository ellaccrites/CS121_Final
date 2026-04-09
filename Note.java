import java.util.*;
import java.io.*;

public class Note implements Serializable {
	String content;
	
	public static void main(String[] args){
		Note n = new Note();
	}// end main
	
	public Note(){
		content = "No notes";
	}// end constructor
	
	public void setContent(String content){
		this.content = content;
	}// end setter
	
	public String getContent(){
		return this.content;
	}// end getter
}// end class
