import java.util.*;
import java.io.*;
import java.text.*;

public class Work implements HasMenu, Converter, Serializable {
	String title;
	String author;
	int wordLength;
	double pageLength;
	int type;
	String genre;
	String fandom;
	String ship;
	Date dateFinished;
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	Note note;
	int rating;

	public static void main(String[] args){
		Work w = new Work();
		w.start();
	}// end main
	
	public Work(){
		this.dateFinished = new Date();
		this.note = new Note();
		this.wordLength = 0;
		this.pageLength = 0;
	}// end no param constructor
	
	public Work(int type, String title, String author){
		this.wordLength = 0;
                this.pageLength = 0;
		this.type = type;
		this.title = title;
		this.author = author;
		this.dateFinished = new Date();
                this.note = new Note();
	}// end constructor

	public String menu(){
		System.out.println("-- Work Menu --");
		System.out.println("0) Exit editing menu");
		System.out.println("1) Edit title");
		System.out.println("2) Edit author");
		System.out.println("3) Edit length");
		System.out.println("4) Edit genre");
		System.out.println("5) Edit date finished");
		System.out.println("6) Edit note");
		System.out.println("7) Edit rating");
		
		if(this.type == 1){
			System.out.println("8) Edit fandom");
			System.out.println("9) Edit ship");
			System.out.print("Enter a number 0-9: ");
		} else{
			System.out.print("Enter a number 0-7: ");
		}// end if
		Scanner input = new Scanner(System.in);
		String userChoice = input.nextLine();

		System.out.println();
		return userChoice;
	}// end menu
	
	public void start(){
		boolean keepGoing = true;
		while(keepGoing){
			this.printWork();
			String userChoice = this.menu();
			Scanner input = new Scanner(System.in);
			if(userChoice.equals("0")){
				System.out.println("Exiting Work menu...");
				keepGoing = false;
			} else if(userChoice.equals("1")){
				System.out.print("Enter new title: ");
				String newTitle = input.nextLine();
				this.setTitle(newTitle);
				System.out.println();
				System.out.println("---> Title changed to: " + newTitle);
			} else if(userChoice.equals("2")){
                                System.out.print("Enter new author: ");
				String newAuthor = input.nextLine();
                                this.setAuthor(newAuthor);
				System.out.println();
				System.out.println("---> Author changed to: " + newAuthor);
			} else if(userChoice.equals("3")){
				if(type == 1){
                                        System.out.print("Enter new word length: ");
                                        int intWords = this.getInt();
					this.setWordLength(intWords);
					System.out.println();
					System.out.println("---> Word length changed to: " + intWords);
				} else {
                                        System.out.print("Enter new page length: ");
                                        double dPages = this.getDouble();
					this.setPageLength(dPages);
					System.out.println();
					System.out.println("---> Page length changed to: " + dPages);
				}// end if else
				this.convertLength();
			} else if(userChoice.equals("4")){
                                System.out.print("Enter new genre: ");
				String newGenre = input.nextLine();
				System.out.println();
				System.out.println("---> Genre changed to: " + newGenre);
                                this.setGenre(newGenre);
			} else if(userChoice.equals("5")){
				String dateAsString = this.df.format(this.dateFinished);
				System.out.println("Enter the following information as their numeric values.");
				System.out.print("Enter new year: ");
				int year = this.getInt();
				System.out.print("Enter new month: ");
				int month = this.getInt() - 1;
				System.out.print("Enter new day: ");
				int day = this.getInt();
				// maybe change to something so that that date doesnt reset unless all 3 values are valid integers
				this.setDateFinished(day, month, year);
				dateAsString = this.df.format(this.dateFinished);
                		System.out.println("---> Date Finished changed to: " + dateAsString);
			} else if(userChoice.equals("6")){
				System.out.print("Enter new note: ");
				String newNote = input.nextLine();
				this.note.setContent(newNote);
				System.out.println();
				System.out.println("---> Note successfully changed.");
			} else if(userChoice.equals("7")){
                                System.out.print("Enter new rating (-5 to 5): ");
                                boolean keepGoing2 = true;
				int newRating = 0;
				while(keepGoing2){
					newRating = this.getInt();
					if(-5 <= newRating){
						if(newRating <= 5){
							keepGoing2 = false;
						} else{
							System.out.println("Please input a value between from -5 to 5: ");	
						}//end if
					} else{
						System.out.println("Please input a value between from -5 to 5: ");
					}//end if else
				}// end while

				System.out.println();
				System.out.println("---> Rating changed to: " + newRating);
                                this.setRating(newRating);
			} else if(this.type == 1){
				if(userChoice.equals("8")){
                                	System.out.print("Enter new fandom: ");
                                	String newFandom = input.nextLine();
                                	this.setFandom(newFandom);
					System.out.println();
					System.out.println("---> Fandom changed to: " + newFandom);
				} else if(userChoice.equals("9")){
                                	System.out.print("Enter new ship: ");
                                	String newGenre = input.nextLine();
                                	this.setGenre(newGenre);
					System.out.println();
					System.out.println("---> Ship changed to: " + newGenre);
				}// end if else
			} else{
				System.out.println("Not a valid input. Please enter one of the choices.");
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
		String dateAsString = this.df.format(this.dateFinished);
		System.out.println("Date Finished: " + dateAsString);
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
	
	public void setDateFinished(int day, int month, int year){
		Date newDate = new GregorianCalendar(year, month, day).getTime();
		this.dateFinished = newDate;
	}// end setDateFinished
	
	public void setRating(int rating){
		this.rating = rating;
	}// end setter
	
	public int getRating(){
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
	
}// end work

