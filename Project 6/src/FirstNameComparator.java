/******************************************************************************
 *       Class: FirstNameComparator
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
 * This file defines the the class FirstNameComparator, which implements comparator for
 * Student objects and implements the method compare to compare the first names of two
 * students and return an int value.
 *
 * ----------------------------- Public Interface -----------------------------
 *           Method                               Description
 * --------------------------- ------------------------------------------------
 * compare(Student student1,	Compares the first names of two student objects
 * Student student2)			 and returns an int value to indicate whether
 * 								 student 1's name comes before, after, or is 
 *              				 equal to student 2's.	         
 ******************************************************************************
*/


import java.util.*;

public class FirstNameComparator implements Comparator<Student>{
	public int compare(Student student1, Student student2){
		return student1.getFirstName().compareTo(student2.getFirstName());
	}
}