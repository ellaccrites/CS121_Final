import java.util.*;
import java.io.*;

class Bookshelf implements HasMenu, Serializable {
	WorkList works = new WorkList();

	public statuc void main(String[] args){
		Bookshelf b = new Bookshelf();
		b.start();
	}// end main
	
	public Bookshelf(){
		this.loadSampleWorks();
		this.saveCustomers();

		this.loadWorks();
		this.start();
		this.saveWorks();
	}// end no param constructor
	
	public String menu(){
		// NEED FINISH
	}// end menu
	
	public String start(){
		// NEED FINISH
	}// end start
	
	public void loadSampleWorks(){
		works.add(new Work("0"));
		works.add(new Work("1"));
		works.add(new Work("2"));
	}// end loadSampleCustomers
	
	public void loadWorks(){
		try {
			FileInputStream fi = new FileInputStream("Works.dat");
			ObjectInputStream obIn = new ObjectInputStream(fi);
			works = (WorksList)obIn.readObject();

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
		System.out.println("Title: ");
		String userChoice = input.nextLine();
		System.out.println("Author: ");
		String userChoice = input.nextLine();
		System.out.println("Word Length: ");
		String userChoice = input.nextLine();
		System.out.println("Page Length: ");
		String userChoice = input.nextLine();
		System.out.println("Type: ");
		String userChoice = input.nextLine();
		System.out.println("Genre: ");
		String userChoice = input.nextLine();
		System.out.println("Fandom: ");
		String userChoice = input.nextLine();
		System.out.println("Ship: ");
		String userChoice = input.nextLine();
		System.out.println("Date Finished: ");
		String userChoice = input.nextLine();
		System.out.println("Rating: ");
		String userChoice = input.nextLine();
		System.out.println("Notes: ");
		String userChoice = input.nextLine();
	// NEED CHANGE ALL OF INPUT ONES TO DIFFERENT NAMES TO BE ABLE TO CREATE
	// NNED TO PRINT WORK AFTER AND LEAVE MESSAGE ABOUT EDITING IN WORK EDIT MENU	
	}// end addWork
	
	public void updateWork(Work work){
		// NEED FINISH
	}// end updateWork
	
	public void printAll(){
		// NEED FINISH
	}// end printAll
	
	public void printSummary(){
		// NEED FINISH
	}// end printSummary
	
	public void findWork(){
		// NEED FINISH
	}// end findWork()
	
	public void searchByTitle(){
		// NEED FINISH
	}// end searchByTitle
	
	public void searchByAuthor(){
		// NEED FINISH
	}// end searchByAuthor
		
}// end class

class WorkList extends ArrayList<Work> {};
