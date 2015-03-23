/******************************************************************************
 * Bellevue Class: CS-211
 *           Term: Spring 2014
 *     Instructor: Robert Main
 *     
 * Textbook: Building Java Programs, A Back to Basics Approach
 *  Edition: 3rd
 *  Authors: Stuart Reges and Marty Stepp
 *  
 * Assigned Project: 6
 *
 *Class Name: Project 6 Client
 *File Name: project6client.java
 *
 * Programmer: Henry Howes
 *
 * Revision     Date                        Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     05/18/2014  Initial Release
 *
 * File Description
 * ----------------
 * This file defines the the class Project6client, which includes all methods,
 * variables, and constant values. Specifically, this class contains the Console
 * application entry method, main(), which is a static method, since no object
 * of the class type is ever instantiated.
 * 
 * Class Methods
 * -------------
 *    Name                                    Description
 * ----------  ----------------------------------------------------------------
 * main              The OS transfers control to this method upon program execution
 * StudentRecords    This method returns the contents of an ArrayList of student records
 * 					 as a formatted string in the form of a table with a header for each
 * 					 type of information
 *
 ******************************************************************************
 */

/**************************************************************************
	 * Method: main(String[])
	 * 
	 * Program Description
	 * -------------------
	 * This program implements the method,"StudentRecords", which returns the contents of
	 * an ArrayList of student records as a formatted string, in the form of a table with
	 * category headings for each type of information in the student object. In the main section,
	 * this program reads a file of student records in to an ArrayList of student objects and then
	 * uses the comparators for each type of information in a record, as well as the above "StudentRecords"
	 * method to sort, then print the list of records.
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
	 * 
	 * ArrayList.add()
	 * Collections.sort
	 * StudentRecords(ArrayList<Student> classList
	 *
	 **************************************************************************
	 */

import java.util.*;
import java.io.*;

public class project6client {
	public static void main(String[] args) throws FileNotFoundException {
		//Opens the scanner, creates the file object, and creates the ArrayList of student files
		Scanner fileReader = new Scanner(new File("StudentRecords.txt"));
		ArrayList<Student> classList = new ArrayList<Student>(); 
		
		
		//Reads the file into an ArrayList of student files
		while(fileReader.hasNextLine()){
			Student next = new Student(fileReader.next(), fileReader.next(),
					fileReader.next(), fileReader.nextDouble(), fileReader.next());
			classList.add(next);
		}
		
		//These lines print a header then sort and print the class list, based on the different comparators
		System.out.println("Student Records, as read from the database file:");
		System.out.println(StudentRecords(classList));
		
		System.out.println("Student Records, after sorting by last name:");
		Collections.sort(classList,new LastNameComparator());
		System.out.println(StudentRecords(classList));
		
		System.out.println("Student Records, after sorting by first name:");
		Collections.sort(classList, new FirstNameComparator());
		System.out.println(StudentRecords(classList));
		
		System.out.println("Student Records, after sorting by student ID:");
		Collections.sort(classList, new IDComparator());
		System.out.println(StudentRecords(classList));
		
		System.out.println("Student Records, after sorting by average:");
		Collections.sort(classList, new AverageComparator());
		System.out.println(StudentRecords(classList));
		
		System.out.println("Student Records, after sorting by letter grade:");
		Collections.sort(classList, new GradeComparator());
		System.out.println(StudentRecords(classList));
		
		fileReader.close();
	}
	
	//Method to format and return as a string the student record files in an ArrayList
	public static String StudentRecords(ArrayList<Student> classList){
		String str = String.format("%-12s%-12s%4s%11s%7s\n", "Last Name", "First Name", "ID", "Average", "Grade");
		for(int i=0; i<2; i++){
			for (int j=0; j<10; j++){
				str = str+"-";
			}
			str = str+"  ";
		}
		for(int i=0; i<6; i++){
			str=str+"-";
		}
		str = str+"  ";
		for(int i=0; i<7; i++){
			str=str+"-";
		}
		str = str+"  ";
		for(int i=0; i<5; i++){
			str=str+"-";
		}
		str=str+"\n";
		
		for(Student s: classList){
			str =str+ String.format("%-12s%-12s%6s%9.2f%5s\n", s.getLastName(), s.getFirstName(), s.getID(), s.getAverage(), s.getGrade());
	}
		return str;
	}
}