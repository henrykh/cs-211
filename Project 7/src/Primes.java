/******************************************************************************
 * Bellevue Class: CS-211
 *           Term: Spring 2014
 *     Instructor: Robert Main
 *     
 * Textbook: Building Java Programs, A Back to Basics Approach
 *  Edition: 3rd
 *  Authors: Stuart Reges and Marty Stepp
 *  
 * Assigned Project: 7
 *
 *Class Name: Primes
 *File Name: Primes.java
 *
 * Programmer: Henry Howes
 *
 * Revision     Date                        Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     05/20/2014  Initial Release
 *
 * File Description
 * ----------------
 * This file defines the the class Primes, which includes all methods,
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
	 * This program implements the method,"Sieve", which accepts an int
	 * value and generates a list of all the prime numbers from 2 to that number, by
	 * eliminating multiples and moving all remaining numbers to the list.
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
	 * Sieve(int n)
	 *
	 **************************************************************************
	 */
import java.util.*;

public class Primes {
	public static void main(String[] args){
	System.out.println(Sieve(100));
	}
	
	//Method to return a list of all prime numbers from 2 to n
	public static Queue<Integer> Sieve(int n){
		if(n<2){
			throw new IllegalArgumentException("Number must be greater than 1");
		}
		
		Queue<Integer> numbers = new LinkedList<Integer>();
		for(int i=2; i<=n; i++){
			numbers.add(i);
		}
		Queue<Integer> results = new LinkedList<Integer>();
		
		int p=0;
		while(p<Math.sqrt(n)){
			p =numbers.remove();
			results.add(p);
			
			int originalSize = numbers.size();
			for(int i=0; i<originalSize; i++){
				int q = numbers.remove();
				if(q%p!=0){
					numbers.add(q);
				}
			}
		}
		
		int originalSize = numbers.size();
		for(int i=0; i<originalSize; i++){
			results.add(numbers.remove());
		}

		return results;
	}
	
	
	
	
}