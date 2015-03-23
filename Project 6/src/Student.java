/******************************************************************************
 *       Class: Student
 * Super Class: (Inferred: Object)
 *  Implements: None
 *
 * Programmer: Henry Howes

 * Revision     Date                          Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     05/18/2014  Initial Release
 * 
 * Class Description
 * -----------------
 * This file defines the the class Student, which stores information on student records including
 * first and last name, student ID, average, and grade. It also includes methods to access
 * those fields and a toString method to display student record information.
 *
 * ----------------------------- Public Interface -----------------------------
 *           Method                               Description
 * --------------------------- ------------------------------------------------
 * Student(String lastName, String     Initializing Constructor
 * firstName, String ID, double average,
 * String grade)                            
 * getLastName()					   Returns the student's last name
 * getFirstName()					   Returns the student's first name
 * getID()							   Returns the student's ID
 * getAverage()						   Returns the student's average
 * getGrade()						   Returns the student's grade
 * toString()						   Returns the student's last name, first name,
 * 									   ID, average, and grade, as a string
 * ------------------------- Private Data Members -----------------------------
 *                  Data
 *    Type          Type         Name                    Description
 * ----------  --------------  ----------  ------------------------------------
 * non-static    String 	    lastName	    Stores the student's last name
 * non-static    String			firstName		Stores the student's first name
 * non-static    String		     ID 			Stores the student's ID
 * non-static 	 double	        average         Stores the student's average
 * non-static    String	        grade 			Stores the student's grade
 ******************************************************************************
 */


public class Student {
	private String lastName;
	private String firstName;
	private String ID;
	private double average;
	private String grade;

//Initializing constructor
public Student(String lastName, String firstName, String ID, double average, String grade){
	this.lastName = lastName;
	this.firstName = firstName;
	this.ID = ID;
	this.average = average;
	this.grade = grade;
}

//Accessors
public String getLastName(){
	return lastName;
}

public String getFirstName(){
	return firstName;
}

public String getID(){
	return ID;
}

public double getAverage(){
	return average;
}

public String getGrade(){
	return grade;
}

//Returns the student's record information as a string
public String toString(){
	String str = lastName+" "+firstName+" "+ID+" "+average+" "+grade;
	return str;
}
}

