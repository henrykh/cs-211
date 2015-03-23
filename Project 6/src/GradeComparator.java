/******************************************************************************
 *       Class: GradeComparator
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
 * This file defines the the class GradeComparator, which implements comparator for
 * Student objects and implements the method compare to compare the grades of two
 * students and return an int value.
 *
 * ----------------------------- Public Interface -----------------------------
 *           Method                               Description
 * --------------------------- ------------------------------------------------
 * compare(Student student1,	Compares the grades of two student objects
 * Student student2)			 and returns an int value to indicate whether
 * 								 student 1's grade comes before, after, or is 
 *              				 equal to student 2's.	         
 ******************************************************************************
*/

import java.util.*;

public class GradeComparator implements Comparator<Student>{
	public int compare(Student student1, Student student2){
		return student1.getGrade().compareTo(student2.getGrade());
	}
}