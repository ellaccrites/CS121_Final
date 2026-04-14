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
		
		boolean keepGoing = true;
		while(keepGoing){
			System.out.println("Type: ");
			type = getInt();
			if(type == 0){
				Work w = new Work(0);
				keepGoing = false;
			} else if(type == 1){
				Work w = new Work(1);
				keepGoing = false;
			} else if(type == 2){
				Work w = new Work(2);
				keepGoing = false;
			} else{
				System.out.prinln("Please enter 0, 1, or 2");
			}// end if else	
		}// end while
// might need to add work onto list first to take it out of small scope? if have issues
		System.out.println("Title: ");
		String title = input.nextLine();
		w.setTitle(title);
		System.out.println("Author: ");
		String author = input.nextLine();
		w.setAuthor(author);

		if(type == 1){
			System.out.println("Word Length: ");
			int wordlength = getInt();
			w.setWordLength(wordlength);
			System.out.println("Fandom: ");
                	String fandom  = input.nextLine();
                	System.out.println("Ship: ");
                	String ship  = input.nextLine();
		} else{
			System.out.println("Page Length: ");
			double pagelength = getDouble();
			w.setPageLength(pageLength);
		}// end if else
		w.convertLength
		
		System.out.println("Genre: ");
		String genre = input.nextLine();
		System.out.println("Fandom: ");
		String fandom  = input.nextLine();
		System.out.println("Ship: ");
		String ship  = input.nextLine();
		
		System.out.println("Date Finished: ");
		System.out.print("Enter the following information as their numeric values: ");
		System.out.print("     Year: ");
		int year = getInt();
		System.out.print("     Month: ");	
		int month = getInt();
		System.out.print("     Day: ");
		int day = getInt();
		try{
			this.dateFinished.set(year, month, day);
		} catch(Exception e){
			System.out.println("Not valid inputs. Date set to 0/00/0000. You can edit date finished in the work menu.");
		}// end try catch
		
		System.out.println("Rating: ");
		String rating  = input.nextLine();
		System.out.println("Notes: ");
		String noteContent = input.nextLine();
		w.note.setContent(noteContent);

		w.printWork();
		works.add(w);
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
	
	//FIGURE OUT HOW TO DEAL WITH THE TWO OF THE SAME FUNCTION 
	public int getInt(){
		boolean keepGoing = true;
		while(keepGoing){
			Scanner input = new Scanner(System.in);
			String value = input.nextLine();
			int intVal;

			try{
				intVal = Integer.parseInt(value);
				return intVal;
			}catch(NumberFormatException e){
				System.out.println("Please input a numeric answer: ");
			}// end try
			if(intVal != 0){
				keepGoing = false;
			}// end if
		}// end while
	}// end getInt
	
	public double getDouble(){
		boolean keepGoing = true;
		while(keepGoing){
			Scanner input = new Scanner(System.in);
			String amount = input.nextLine();

			double doubleAmount = 0d;
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
