/******************************************************************************
 * Bellevue Class: CS-211
 * 
 * Textbook: Building Java Programs, A Back to Basics Approach, 2nd Edition
 *  Authors: Stuart Reges and Marty Stepp
 * 
 * Instructor Project Solution
 * 
 *    Assigned Project: 9
 *             Chapter: 16
 * 			   Exercise: 10
 *                Page: 1000
 *
 * Class Name: Exercise10Client
 * File Name:  Exercise10Client.java
 *
 * Programmer: Henry Howes
 *
 * Revision     Date                        Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     06/05/2014  Initial Release
 *
 * File Description
 * ----------------
 * This file defines the the class "Exercise10Client", which includes all
 * methods, variables, and constant values. Specifically, this class contains
 * the Console application entry method, main(), which is a static method,
 * since no object of the class type is ever instantiated.
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
	 * Description
	 * -----------
	 * This program tests the stretch method of the LinkedIntList class, which
	 * takes an integer as parameter and stretches the list by multiplying the
	 * occurrences of each existing value in the list by that factor.
	 * 
	 * Specifically, this program sets up a sample list by asking for nine values
	 * from the user, then asks for a stretch factor to stretch the list by. Finally,
	 * it prints the list after it's been stretched.
	 * 
	 * RETurn
	 *  Type
	 * ------
	 * void
	 * 
	 * ------------------------------- Arguments ------------------------------
	 *   Type       Name                         Description
	 * --------  ------------  ------------------------------------------------
	 * String[]  args          Array of "string" argument(s) passed to main()
	 *                         when the Console program is invoked by the User.
	 *                         
	 * Invoked Methods
	 * ---------------
	 * add(int value)
	 * stretch(int n)                            
	 *
	 **************************************************************************
	 */



import java.util.*;

public class Exercise10Client {
	public static void main(String[] args){
		
	Scanner input = new Scanner(System.in);
	LinkedIntList list = new LinkedIntList();

	System.out.println("Please enter nine integer values, separated by spaces: ");
	for(int i=0; i<9; i++){
	list.add(input.nextInt());
	}
	
	System.out.println("Please enter an integer value to stretch the list by that factor:");
	list.stretch(input.nextInt());
	System.out.println(list);
	}
}