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
 *Class Name: Towers of Hanoi
 *File Name: TowersOfHanoi.java
 *
 * Programmer: Henry Howes
 *
 * Revision     Date                        Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     05/10/2014  Initial Release
 *
 * File Description
 * ----------------
 * This file defines the the class TowersOfHanoi, which includes all methods,
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
	 * This program implements the public and private methods, "moveDisks", and the 
	 * private method, "moveDisk", to solve the Towers of Hanoi problem. When passed
	 * an int value, "moveDisks" moves that number of disks from a source stack to another
	 * destination stack through the use of an intermediate stack and respecting the rule
	 * that no disk can be stacked on a smaller disk. The "moveDisk" method prints each move
	 * as it happens, to the console.
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
	 * public moveDisks(int disks)
	 * private moveDisks(int disks, char source, char destination, char temporary)
	 * private moveDisk(char from, char to)
	 **************************************************************************
	 */

public class TowersOfHanoi{
	public static void main(String[] args){
		moveDisks(3);
	}
	
	//This method accepts a number of disks as a parameter and feeds it to the private
	//method with the character 'a' representing the starting source position, 'c'
	//representing the objective destination, and 'b' representing the intermediate
	//position.
	public static void moveDisks(int disks){
		moveDisks(disks, 'a','c','b');
	}
	
	//This private method accepts a number of disks and three characters (for the source,
	//destination, and temporary locations of those disks) and calls the moveDisk method
	//in a sequence that moves the disks from the source to the destination, while respecting
	//the rule that a "larger" disk may not be placed on a "smaller."
	private static void moveDisks(int disks, char source, char destination,char temporary){
		if(disks==1){
			moveDisk(source,destination);
		}
		else{
			moveDisks(disks-1, source, temporary, destination);
			moveDisk(source,destination);
			moveDisks(disks-1, temporary, destination, source);
		}
	}
	
	//This private method prints each move of the moveDisks method
	private static void moveDisk(char from, char to){
		System.out.println("Move disk from "+from+" to "+to);
	}
	
}
	