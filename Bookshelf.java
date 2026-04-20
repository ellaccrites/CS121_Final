import java.util.*;
import java.io.*;

class Bookshelf implements HasMenu, Serializable {
	WorkList works = new WorkList();

	public static void main(String[] args){
		Bookshelf b = new Bookshelf();
		b.start();
	}// end main
	
	public Bookshelf(){
		this.loadSampleWorks();
		this.saveWorks();

		this.loadWorks();
		this.start();
		this.saveWorks();
	}// end no param constructor
	
	public String menu(){
		System.out.println("-- Bookshelf Menu --");
		System.out.println("0) Exit Bookshelf Menu");
		System.out.println("1) Print all works");
		System.out.println("2) Get a summary");
		System.out.println("3) Add a work");
		System.out.println("4) Edit a work");
		System.out.println("5) Search by title");
		System.out.println("6) Search by author name");
		System.out.print("Choose 0-6: ");

		Scanner input = new Scanner(System.in);
		String userChoice = input.nextLine();
		System.out.println();
		return userChoice;
	}// end menu
	
	public void start(){
		boolean keepGoing = true;
		while(keepGoing){
			String userChoice = menu();
			if(userChoice.equals("0")){
				System.out.println("Exiting Bookshelf Menu...");
				keepGoing = false;
			} else if(userChoice.equals("1")){
				System.out.println("-- List of all Works --");
				this.printAll();
			} else if(userChoice.equals("2")){
				System.out.println("-- Work Summary --");
				this.printSummary();
			} else if(userChoice.equals("3")){
				System.out.println("-- Adding Work --");
				this.addWork();
			} else if(userChoice.equals("4")){
				this.updateWork();
			} else if(userChoice.equals("5")){
				System.out.println("-- Search Menu --");
				this.searchByTitle();
			} else if(userChoice.equals("6")){
				System.out.println("-- Search Menu --");
				this.searchByAuthor();
			} else{
				System.out.println("Please enter a number 0-6.");
			}// end if else
			System.out.println();
		}// end while
	}// end start
	
	public void loadSampleWorks(){
		works.add(new Work(0, "Alice in Wonderland", "Lewis Carroll"));
		works.add(new Work(1, "Crimson Rivers", "bizarestars"));
		works.add(new Work(2, "The Apothecary Diaries", "Natsu Hyuga"));
	}// end loadSampleCustomers
	
	public void loadWorks(){
		try {
			FileInputStream fi = new FileInputStream("Works.dat");
			ObjectInputStream obIn = new ObjectInputStream(fi);
			works = (WorkList)obIn.readObject();

			obIn.close();
			fi.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}// end try
	// move the whole load thing to library if implement a user class
	}// end loadWorks
	
	public void saveWorks(){
		try {
			FileOutputStream fo = new FileOutputStream("Works.dat");
			ObjectOutputStream obOut = new ObjectOutputStream(fo);
			obOut.writeObject(works);
			obOut.close();
			fo.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}// end try
	// move load and save thing to library if implement a user class
	}// end saveWorks
	
	public void addWork(){
		Scanner input = new Scanner(System.in);
                System.out.println("Please enter the following information: ");
		System.out.print("Work type (0 for Book, 1 for Fanfic, 2 for Manga): ");
		boolean keepGoing = true;
		int type = 0;
		while(keepGoing){
			int testType = getInt();
			if(testType == 0){
				type = 0;
				keepGoing = false;
			} else if(testType == 1){
				type = 1;
				keepGoing = false;
			} else if(testType == 2){
				type = 2;
				keepGoing = false;
			} else {
				System.out.println("Please enter 0, 1, or 2");
			}// end if else
		}// end while

		System.out.print("Title: ");
		String title = input.nextLine();
		System.out.print("Author: ");
		String author = input.nextLine();
		
		Work w = new Work(type, title, author);

		if(w.getType() == 1){
			System.out.print("Word Length: ");
			int wordlength = getInt();
			w.setWordLength(wordlength);
			System.out.print("Fandom: ");
                	String fandom  = input.nextLine();
			w.setFandom(fandom);
                	System.out.print("Ship: ");
                	String ship  = input.nextLine();
			w.setShip(ship);
		} else{
			System.out.print("Page Length: ");
			double pageLength = getDouble();
			w.setPageLength(pageLength);
			w.setFandom("n/a");
			w.setShip("n/a");
		}// end if else
		w.convertLength();
		
		System.out.print("Genre: ");
		String genre = input.nextLine();
		w.setGenre(genre);
		
		System.out.print("Date Finished: ");
		System.out.print("Enter the following information as their numeric values: ");
		System.out.print("     Year: ");
		int year = getInt();
		System.out.print("     Month: ");	
		int month = getInt() - 1;
		System.out.print("     Day: ");
		int day = getInt();
		try{
			w.setDateFinished(year, month, day);
		} catch(Exception e){
			System.out.println("Not valid inputs. Date set to current time. You can edit date finished in the work menu.");
		}// end try catch
		
		System.out.print("Rating: ");
		String rating  = input.nextLine();
		System.out.print("Notes: ");
		String noteContent = input.nextLine();
		w.note.setContent(noteContent);

		w.printWork();
		works.add(w);
	}// end addWork
	
	public void printAll(){
		for(Work work: works){
			work.printWork();
		}// end for
	}// end printAll
	
	public void printSummary(){
		// first: number of works
		// number of works in each type
		// total words/pages
		// maybe more stuff, but let's start here
		int numWorks = works.size();
		int numWords = 0;
		double numPages = 0d;
		int numBooks = 0;
		int numFics = 0;
		int numManga = 0;

		for(Work work: works){
			numWords += work.getWordLength();
			numPages += work.getPageLength();
			if(work.getType() == 0){
				numBooks += 1;
			} else if(work.getType() == 1){
				numFics += 1;
			} else if(work.getType() == 2){
				numManga += 1;
			}// end if else
		}// end for
		
		System.out.println("Total number of works in Bookshelf: " + numWorks);
		System.out.println("       Books: " + numBooks);
		System.out.println("       Fanfics: " + numFics);
		System.out.println("       Mangas: " + numManga);
		System.out.println("Total word count: " + numWords);
		System.out.println("Total page count: " + numPages); // need to check to force to 2 decimal places
	}// end printSummary
	
	public void updateWork(){
		Scanner input = new Scanner(System.in);
                System.out.println("Enter title of work to be edited: ");
                String toMatch = input.nextLine();
		boolean match = false;
                for(Work work: works){
                        String workTitle = work.getTitle();
                        if(workTitle.equals(toMatch)){
                                System.out.println("Found work. Entering work menu...");
				match = true;
				work.start();
                        }// end if
                }// end for
                if(match == false){
			System.out.println("No match found. You can find a list of all works in the Bookshelf menu.");
		}// end if
		System.out.println("To change work information, chose edit work in Bookshelf menu.");
	}// end updateWork
	
	public void searchByTitle(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter title: ");
		String toMatch = input.nextLine();
		System.out.println("Showing matching works...");
		for(Work work: works){
			String workTitle = work.getTitle();
			if(workTitle.contains(toMatch)){
				work.printWork();
			}// end if
		}// end for
		System.out.println("To change work information, chose edit work in the Bookshelf menu.");
	}// end searchByTitle
	
	public void searchByAuthor(){
		Scanner input = new Scanner(System.in);
                System.out.println("Enter author name: ");
                String toMatch = input.nextLine();
		System.out.println("Showing matching works...");
                for(Work work: works){
                        String workAuthor = work.getAuthor();
                        if(workAuthor.contains(toMatch)){
                                work.printWork();
                        }// end if
                }// end for
                System.out.println("To change work information, chose edit work in Bookshelf menu.");
	}// end searchByAuthor
	
	//FIGURE OUT HOW TO DEAL WITH THE TWO OF THE SAME FUNCTION 
	public int getInt(){
		boolean keepGoing = true;
		int intVal = 0;
		while(keepGoing){
			Scanner input = new Scanner(System.in);
			String value = input.nextLine();
			boolean match = false;
			try{
				intVal = Integer.parseInt(value);
				match = true;
			}catch(NumberFormatException e){
				System.out.println("Please input a numeric answer: ");
			}// end try
			if(match){
				keepGoing = false;
			}// end if
		}// end while
		return intVal;
	}// end getInt
	
	public double getDouble(){
		boolean keepGoing = true;
		double doubleAmount = 0d;
		while(keepGoing){
			Scanner input = new Scanner(System.in);
			String amount = input.nextLine();

			try{
				doubleAmount = Double.parseDouble(amount);
			}catch(NumberFormatException e){
				System.out.println("Please input a numeric answer: ");
			}// end try
			if(doubleAmount != 0d){
				keepGoing = false;
			}// end if
		}// end while
		return doubleAmount;
	}// end get double
	
}// end class

class WorkList extends ArrayList<Work> {};
