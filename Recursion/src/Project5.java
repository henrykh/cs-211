/******************************************************************************
 * Bellevue Class: CS-211
 *           Term: Spring 2014
 *     Instructor: Robert Main
 *     
 * Textbook: Building Java Programs, A Back to Basics Approach
 *  Edition: 3rd
 *  Authors: Stuart Reges and Marty Stepp
 *  
 * Assigned Project: 5
 *
 *Class Name: Project 5
 *File Name: project5.java
 *
 * Programmer: Henry Howes
 *
 * Revision     Date                        Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     05/10/2014  Initial Release
 *
 * File Description
 * ----------------
 * This file defines the the class Project5, which includes all methods,
 * variables, and constant values. Specifically, this class contains the Console
 * application entry method, main(), which is a static method, since no object
 * of the class type is ever instantiated.
 * 
 * Class Methods
 * -------------
 *    Name                                    Description
 * ----------  ----------------------------------------------------------------
 * main        The OS transfers control to this method upon program execution
 *
 ******************************************************************************
 */

/**************************************************************************
	 * Method: main(String[])
	 * 
	 * Program Description
	 * -------------------
	 * This program implements the method,"writeSquares, which accepts an int
	 * value and all the squared values from one to that number, beginning with odd
	 * numbers in descending order followed by even numbers in ascending order. In the
	 * main section are a few sample commands to demonstrate the output of the method.
	 * 
	 * RETurn
	 *  Type
	 * ------
	 * void
	 *
	 * ------------------------------- Arguments ------------------------------
	 *   Type        Name                         Description
	 * --------  ------------  ------------------------------------------------
	 * String[]  args          Array of "string" argument(s) passed to main()
	 *                         when the Console program is invoked by the User.
	 * 
	 * Invoked Methods
	 * ---------------
	 * writeSquares(int number)
	 *
	 **************************************************************************
	 */


public class Project5 {
	public static void main(String[] args){
		writeSquares(8);
		System.out.println();
		writeSquares(1);
		System.out.println();
		writeSquares(0);
	}
	
	//This method accepts an int and prints all the squared values from one to that int,
	//with odd numbers first in descending numerical order, followed by evens in ascending
	//order.
	public static void writeSquares(int number){
		if(number<1){
			throw new IllegalArgumentException("Number must be greater than 0.");
		}
		if(number==1){
			System.out.print(1);
		}
		else if(number%2!=0){
			System.out.print((int) Math.pow(number, 2)+", ");
			writeSquares(number-1);
		}
		else if(number%2==0){
			writeSquares(number-1);
			System.out.print(", ");
			System.out.print((int) Math.pow(number, 2));
		}
	}
}
