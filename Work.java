import java.util.*;
import java.io.*;

public class Work implements HasMenu, Serializable {
	
	public static void main(String[] args){
		Work w = new Work();
		w.start();
	}// end main
	
	public Work(){
		wordLength = 0;
		pageLength = 0;
	}// end no param constructor
	
	public Work(int type){
		wordLength = 0;
                pageLength = 0;
		this.type = type;
	}// end constructo

	public String menu(){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.print("Enter a number 0-6: ");
		
		Scanner input = new Scanner(System.in);
		String userChoice = input.nextLine();

		System.out.println();
		return userChoice;
	}// end menu
	
	public void start(){
		boolean keepGoing = true;
		while(keepGoing){
			String userChoice = this.menu();
			if(userChoice.equals("0")){

			} else if(userChoice.equals("1")){

			} else if(userChoice.equals("2")){

			} else if(userChoice.equals("3")){

			} else if(userChoice.equals("4")){

			} else if(userChoice.equals("5")){

			} else if(userChoice.equals("6")){

			} else {
				System.out.println("Not a valid input. Please enter 0-7.");
			}// end if else
			System.out.println();
		}// end while
	}// end start
	
	public void printWork(){

	}// end printWork
	
	public void convertLength(){
	
	}// end convertLength
	
	public void addNote(){
		System.out.println("Type out your note below:");
		Scanner input = new Scanner(System.in);
		String noteContent = input.nextLine();

		this.note.setContent(noteContent);
		// may need to change if i allow multiple notes to be added
		// note will become and array of Notes called note
		// a new note will be initialized with content and then
		// appended to notes
		System.out.println();
	}// end addNote
	
	public void setTitle(String title){
		this.title = title;
	}// end setter

	public String getTitle(){
		return this.title;
	}// end getter
	
	public void setAuthor(String author){
		this.author = author;
	}// end setter
	
	public String getAuthor(){
		return this.author;
	}// end getter
	
	public void setWordLength(int length){
		this.wordLength = length;
	}// end setter
	
	public int getWordLength(){
		return this.wordLength;
	}// end getter
	
	public void setPageLength(double length){
		this.pageLength = length;
	}// end setter
	
	public double getPageLength(){
		return pagelength;
	}// end getter
	
	public void setType(int type){
		this.type = type;
	}// end setter
	
	public int getType(){
		return this.type;
	}// end getter
	
	public String getStringType(){
		String sType;
		if(this.type == 0){
			sType = "Book";
		} else if(this.type == 1){
			sType = "Fanfic";
		} else if(this.type == 2){
			sType = "Manga";
		}// end if else
		return sType;
	}// end getStringType
	
	public void setRating(String rating){
		this.rating = rating;
		// maybe want to switch this to integer??
	}// end setter
	
	public String getRating(){
		return this.rating;
	}// end getter
	
	public void setGenre(String genre){
		this.genre = genre;
	}// end setter
	
	public String getGenre(){
		return this.genre;
	}// end getter

}// end work

