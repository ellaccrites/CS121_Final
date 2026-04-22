import java.util.*;
import java.io.*;

public interface Converter{
	default int getInt(){
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
				System.out.print("Please input a numeric answer: ");
			}// end try
			if(match){
				keepGoing = false;
			}// end if
		}// end while
		return intVal;
	}// end getInt
	
	default double getDouble(){
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
}// end Converter
