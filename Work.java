import java.util.*;
import java.io.*;

public class Work implements HasMenu, Serializable {
	String title;
	String author;
	int wordLength;
	double pageLength;
	int type;
	String genre;
	String fandom;
	String ship;
	Calendar dateFinished;
	Note note;
	String rating;

	public static void main(String[] args){
		Work w = new Work();
		w.start();
	}// end main
	
	public Work(){
		this.dateFinished = new Calender;
		this.note = new Note;
		wordLength = 0;
		pageLength = 0;
	}// end no param constructor
	
	public Work(int type){
		wordLength = 0;
                pageLength = 0;
		this.type = type;
		this.dateFinished = new Calender;
                this.note = new Note;
	}// end constructor

	public String menu(){
		System.out.println("0) Exit editing menu");
		System.out.println("1) Edit title");
		System.out.println("2) Edit author");
		System.out.println("3) Edit length");
		System.out.println("4) Edit genre");
		System.out.println("5) Edit date finished");
		System.out.println("6) Add or edit note");
		System.out.println("7) Add or edit rating");
		System.out.println("8) Edit fandom");
		System.out.println("9) Edit ship");
		System.out.print("Enter a number 0-9: ");
		Scanner input = new Scanner(System.in);
		String userChoice = input.nextLine();

		System.out.println();
		return userChoice;
	}// end menu
	
	public void start(){
		boolean keepGoing = true;
		while(keepGoing){
			String userChoice = this.menu();
			Scanner input = new Scanner(System.in);
			if(userChoice.equals("0")){
				System.out.println("Exiting Work menu...");
				keepGoing = false;
			} else if(userChoice.equals("1")){
				System.out.println("Current title: " + this.getTitle());
				System.out.print("Enter new title: ");
				String newTitle = input.nextLine();
				this.setTitle(newTitle);
			} else if(userChoice.equals("2")){
				System.out.println("Current author: " + this.getAuthor());
                                System.out.print("Enter new author: ");
				String newAuthor = input.nextLine();  
                                this.setAuthor(newAuthor);
			} else if(userChoice.equals("3")){
				if(type == 1){
					System.out.println("Current word length: " + this.getWordLength());
                                        System.out.print("Enter new word length: ");
                                        int intWords = getInt();
					this.setWordLength(intWords);
				} else {
					System.out.println("Current page length: " + this.getPageLength());
                                        System.out.print("Enter new page length: ");
                                        double dPages = getDouble();
					this.setPageLength(dPages);
				}// end if else
				this.convertLength();
			} else if(userChoice.equals("4")){
				System.out.println("Current genre: " + this.getGenre());
                                System.out.print("Enter new genre: ");
				String newGenre = input.nextLine();
                                this.setGenre(newGenre);
			} else if(userChoice.equals("5")){
				System.out.println("Current date finished: " + this.dateFinished.toString());
				System.out.print("Enter the following information as their numeric values: ");
				System.out.print("Enter new year: ");
				int year = getInt();
				System.out.print("Enter new month: ");
				int month = getInt();
				System.out.print("Enter new day: ");
				int day = getInt();
				// maybe change to something so that that date doesnt reset unless all 3 values are valid integers
				this.dateFinished.set(year, month, day);

			} else if(userChoice.equals("6")){
				System.out.println("Current note: " + note.getContent());
				System.out.print("Enter new note: ");
				String newNote = input.nextLine();
				this.note.setContent(newNote);
			} else if(userChoice.equals("7")){
				System.out.println("Current rating: " + this.getRating());
                                System.out.print("Enter new rating (-5 to 5): ");
                                String newRating = input.nextLine();
                                this.setRating(newRating);
				// do i want to add a safeguard to check if int between -5 and 5????
			} else if(userChoice.equals("8")){
				System.out.println("Current fandom: " + this.getFandom());
                                System.out.print("Enter new fandom: ");
                                String newFandom = input.nextLine();
                                this.setFandom(newFandom);
			} else if(userChoice.equals("9")){
				System.out.println("Current ship: " + this.getShip());
                                System.out.print("Enter new ship: ");
                                String newGenre = input.nextLine();
                                this.setGenre(newGenre);
			} else{
				System.out.println("Not a valid input. Please enter 0-9.");
			}// end if else
			System.out.println();
		}// end while
	}// end start
	
	public void printWork(){
		System.out.println("Title: " + this.getTitle());
		System.out.println("Author: " + this.getAuthor());
		System.out.println("Word Length: " + this.getWordLength());
		System.out.println("Page Length: " + this.getPageLength());
		System.out.println("Type: " + this.getStringType());
		System.out.println("Genre: " + this.getGenre());
		System.out.println("Fandom: " + this.getFandom());
		System.out.println("Ship: " + this.getShip());
		System.out.println("Date Finished: " + this.dateFinished.toString());
		System.out.println("Notes: " + this.note.getContent());
		System.out.println("Rating: " + this.getRating());
		System.out.println();
	}// end printWork
	
	public void convertLength(){
		double newWords = 0d;
		if(this.type == 0){
			newWords = 300 * getPageLength();
			int intWords = (int) newWords;
			setWordLength(intWords);
		} else if(this.type == 1){
			setPageLength(this.wordLength / 300);
		} else if(this.type == 2){
			newWords  = 300 * this.pageLength;
			int intWords = (int) newWords;
			setWordLength(intWords);
		}// end if else
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
		return pageLength;
	}// end getter
	
	public void setType(int type){
		this.type = type;
	}// end setter
	
	public int getType(){
		return this.type;
	}// end getter
	
	public String getStringType(){
		String sType = "";
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
	
	public void setFandom(String fandom){
		this.fandom = fandom;
	}// end setter
	
	public String getFandom(){
		return this.fandom;
	}// end getter
	
	public void setShip(String ship){
		this.ship = ship;
	}// end setter
	
	public String getShip(){
		return this.ship;
	}// end getter
	
	public int getInt(){
		Scanner input = new Scanner(System.in);
		String value = input.nextLine();
		
		int intVal = 0;
		try{
			intVal = Integer.parseInt(value);
		}catch(NumberFormatException e){
			System.out.println("Please input a number.");
		}// end try
		return intVal;
	}// end getInt
	
	public double getDouble(){
		Scanner input = new Scanner(System.in);
		String amount = input.nextLine();

		double doubleAmount = 0d;
		try{
			doubleAmount = Double.parseDouble(amount);
		}catch(NumberFormatException e){
			System.out.println("Please input a number.");
		}// end try
		return doubleAmount;
	}// end get double
	
}// end work

