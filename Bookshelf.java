import java.util.*;
import java.io.*;

class Bookshelf implements HasMenu, Serializable {
	WorkList works = new WorkList();

	public statuc void main(String[] args){
		Bookshelf b = new Bookshelf();
		b.start();
	}// end main
	/*
	 * + BookShelf()
+ start(): void
+ menu(): string
+ loadWorks(): void
+ saveWorks(): void
+ addWork(): void
+ updateWork(Work): void
+ printAll(): void
+ printSummary(): void
+ findWork(string): void
+ searchByTitle(): void
+ searchByAuthor: void
*/
	public Bookshelf(){
		this.loadSampleCustomers();
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
	
	public void loadWorks(){
		// NEED FINISH
	}// end loadWorks
	
	public void saveWorks(){
		// NEED FINISH
	}// end saveWorks
	
	public void addWork(){
		// NEED FINISH
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
