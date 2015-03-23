/******************************************************************************
 *       Class: AverageComparator
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
 * This file defines the the class AverageComparator, which implements comparator for
 * Student objects and implements the method compare to compare the averages of two
 * students and return an int value.
 *
 * ----------------------------- Public Interface -----------------------------
 *           Method                               Description
 * --------------------------- ------------------------------------------------
 * compare(Student student1,	Compares the averages of two student objects
 * Student student2)			 and returns an int value to indicate whether
 * 								 student 1's average comes before, after, or is 
 *              				 equal to student 2's.	         
 ******************************************************************************
*/

import java.util.*;

public class AverageComparator implements Comparator<Student>{
	public int compare(Student student1, Student student2){
		return (int) (student1.getAverage()-student2.getAverage());
	}
}