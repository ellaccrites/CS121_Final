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
		String userChoice = "null";
		// NEED FINISH
		return userChoice;
	}// end menu
	
	public void start(){
		// NEED FINISH
	}// end start
	
	public void loadSampleWorks(){
		works.add(new Work(0));
		works.add(new Work(1));
		works.add(new Work(2));
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
		Work w = new Work();
		
		boolean keepGoing = true;
		while(keepGoing){
			System.out.println("Type: ");
			int type = getInt();
			if(type == 0){
				w.setType(0);
				keepGoing = false;
			} else if(type == 1){
				w.setType(1);
				keepGoing = false;
			} else if(type == 2){
				w.setType(2);
				keepGoing = false;
			} else{
				System.out.println("Please enter 0, 1, or 2");
			}// end if else	
		}// end while
// might need to add work onto list first to take it out of small scope? if have issues
		System.out.println("Title: ");
		String title = input.nextLine();
		w.setTitle(title);
		System.out.println("Author: ");
		String author = input.nextLine();
		w.setAuthor(author);

		if(w.type == 1){
			System.out.println("Word Length: ");
			int wordlength = getInt();
			w.setWordLength(wordlength);
			System.out.println("Fandom: ");
                	String fandom  = input.nextLine();
                	System.out.println("Ship: ");
                	String ship  = input.nextLine();
		} else{
			System.out.println("Page Length: ");
			double pageLength = getDouble();
			w.setPageLength(pageLength);
		}// end if else
		w.convertLength();
		
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
			w.dateFinished.set(year, month, day);
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
	
	public void printAll(){
		for(Work work: works){
			work.printWork();
		}// end for
	}// end printAll
	
	public void printSummary(){
		for(Work work: works){
		}// end for
	}// end printSummary
	
	public void updateWork(){
		Scanner input = new Scanner(System.in);
                System.out.println("Enter title of work to be edited: ");
                String toMatch = input.nextLine();
                for(Work work: works){
                        String workTitle = work.getTitle();
                        if(workTitle.equals(toMatch)){
                                System.out.println("Found work. Entering work menu...");
				work.start();
			} else{
				System.out.println("No watch found. You can search for a work in the Bookshelf menu.");
                        }// end if
                }// end for
                System.out.println("To change work information, chose edit work in Bookshelf menu.");
	}// end findWork()
	
	public void searchByTitle(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter title: ");
		String toMatch = input.nextLine();
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
