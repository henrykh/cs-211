/******************************************************************************
 * Bellevue Class: CS-211
 * 
 * Textbook: Building Java Programs, A Back to Basics Approach, 2nd Edition
 *  Authors: Stuart Reges and Marty Stepp
 * 
 * Instructor Project Solution
 * 
 *    Assigned Project: 8
 *             Chapter: 15
 * Programming Project: 1
 *                Page: 927
 *
 * Class Name: Project8_Solution
 * File Name:  Project8_Solution.java
 *
 * Programmer: Robert Main
 *
 * Revision     Date                        Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     05/29/2013  Initial Release
 *   1.1     06/05/2013  Added Tests 8A nad 8B for "containsAll"
 *
 * File Description
 * ----------------
 * This file defines the the class "Project8_Solution", which includes all
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
class Project8_Solution
{
	/**************************************************************************
	 * Method: main(String[])
	 * 
	 * Description
	 * -----------
	 * This program tests the variation of ArrayList that implements the
	 * generic version of the class, i.e. an ArrayList consisting of any User
	 * defined class objects.
	 * 
	 * In this variation, the class Iterator class is embedded in the
	 * ArrayList<E> class definition, thus allowing access to the data members
	 * and methods of the ArrayList<E> class.
	 * 
	 * In addition, method "addAll(ArrayList<E>)" is added to the "ArrayList<E>"
	 * class.
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
	 * None                            
	 *
	 **************************************************************************
	 */
	public static void main(String[] args)
	{
		// Constant "final" Array Definition
		final int[] data1 = {13, 4, 85, 13, 40, -8, 17, -5 };
		final int[] data2 = {16, 9, 23, -8, 17, 47, -10, 85 };
		final int[] data3 = {11, 56, 13, -23, 17, 47, -10, 85 };
		final int[] data4 = {11, 56, 14, -23, 19, 47, -10, 94 };
		final int[] data5 = {4, 13, -8, 85 };
		final int[] data6 = {4, 13, 41, -8, 85 };
		
		// Initialized Variable Declaration
		// Create an "ArrayIntList" object, with the default capacity
		ArrayList<Integer> list1 = new ArrayList<Integer>(data1.length);
		ArrayList<Integer> list2 = new ArrayList<Integer>(data2.length);
		
		// Uninitialized Variable Declaration
		int elementValue;
		String str;
		
		
        // Display Project Description to the User
        System.out.println("       CS-211: Project #8 Solution" +
        		         "\nTextbook Programming Projects, Chapter 15" +
        		         "\n           Project #1, page 927\n");
		
		
		// Add the data1 items to the list1
		for (int value : data1)
			list1.add(value);
		
		// Add the data2 items to the list2
		for (int value : data2)
			list2.add(value);
		
		
		// Example #1: Remove a specific item from the list
		// Display the list
		System.out.println("Example #1: Remove a specific item from the list" +
						 "\n  list before removal: " + list1);
		elementValue = data1[2];
		// Note: MUST explicitly cast "elementValue", type "int" to same data
		//       type specified for "list1", "Integer", since the reference
		//       type of the method's argument is "Object".
		if (!list1.remove((Integer)elementValue) )
		{
			System.out.println("  Error: Unable to remove element \"" +
					elementValue + "\"");
		}
		else
		{
			System.out.println("  Success: Element \"" + elementValue + "\" was removed." +
							 "\n    List after removal: " + list1);
		}
		
		
		// Example #2: Attempt to remove an item from the list that is not the
		//             same data type specified for the list, "Integer"
		System.out.println("\nExample #2: Attempt to remove an invalid item " +
				"type from the list" +
				 "\n  list before removal: " + list1);
		str = "ABC";
		if (!list1.remove(str) )
			System.out.println("  Error: Unable to remove element \"" + str + "\"");
		else
		{
			System.out.println("  Success: Element \"" + str + "\" was removed." +
							 "\n    List after removal: " + list1);
		}
			
		
		// Example #3: Remove an item from "list1" at the specified index,
		//             RETurning the element value removed
		int index = 3;
		System.out.println("\nExample #3: Remove the element at index " + index +
				" from the list" +
						 "\n  list before removal: " + list1);
		elementValue = list1.remove(index);
		System.out.println("  Element \"" + elementValue + "\" was removed." +
							 "\n    List after removal: " + list1);

		
		// Example #4: Remove all elements in "list1" that also occur in "list2"
		// First, clear, then re-populate "list1"
		list1.clear();
		// Add all the "data1" items to the "list1"
		for (int value : data1)
			list1.add(value);
		
		System.out.println("\nExample #4: Remove all the elements in \"list1\"" +
				" that occur in \"list2\"" +
						  "\n  (Single occurrences in \"list1\")" +
						  "\n  list1 before removal: " + list1 +
						  "\n                 list2: " + list2);
		if (!list1.removeAll(list2) )
			System.out.println("  Error: Two items should have been removed!");
		else
			System.out.println("   Success: list1 after removal: " + list1);
		
		list2.add(data1[0]);

		
		// Example #5: Remove all elements in "list1" that also occur in "list2"		
		System.out.println("\nExample #5: Remove all the elements in \"list1\"" +
				" that occur in \"list2\"" +
				  		   "\n  (Multiple, non-consecutive occurrences in \"list1\")" +
						   "\n  list1 before removal: " + list1 +
						   "\n                 list2: " + list2);
		if (!list1.removeAll(list2) )
			System.out.println("  Error: Two items should have been removed!");
		else
			System.out.println("   Success: list1 after removal: " + list1);

		
		// Example #6A: Locate the last index in "list1" of a specific item in the list
		//              (Item at end of the list)
		// First, reestablish list1
		//   Clear, the add all items in array "data1"
		list1.clear();
		// Add all the "data1" items to the "list1"
		for (int value : data1)
			list1.add(value);
		elementValue = data1[0];
		list1.add(elementValue);
		System.out.println("\nExample #6A: Locate the last index of a specific " +
				"item in the list" +
						 "\n             Locate last index of: " + elementValue +
				"  (at the end of the list)" +
						 "\n  list before search: " + list1);
		index = list1.lastIndexOf(elementValue);
		if (index < 0)
		{
			System.out.println("  Error: Unable to locate \"" + elementValue +
					"\" in the list!");
		}
		else
		{
			System.out.println("  Success: Last index of \"" + data1[0] + "\": " + index);
			list1.remove(index);
		}
		
		// Example #6B: Locate the last index in "list1" of a specific item in the list
		//              (Item in the middle of the list)
		System.out.println("\nExample #6B: Locate the last index of a specific " +
				"item in the list" +
						 "\n             Locate last index of: " + elementValue +
				"  (middle of the list)" +
						 "\n  list before search: " + list1);
		index = list1.lastIndexOf(elementValue);
		if (index < 0)
		{
			System.out.println("Error: Unable to locate \"" + elementValue +
					"\" in the list!");
		}
		else
		{
			System.out.println("  Success: Last index of \"" + data1[0] + "\": " + index);
			list1.remove(index);
		}
		
		// Example #6C: Locate the last index in "list1" of a specific item in the list
		//              (Item at the beginning of the list)
		System.out.println("\nExample #6C: Locate the last index of a specific " +
				"item in the list" +
						 "\n             Locate last index of: " + elementValue +
				"  (at the beginning of the list)" +
						 "\n  list before search: " + list1);
		index = list1.lastIndexOf(elementValue);
		if (index < 0)
		{
			System.out.println("  Error: Unable to locate \"" + elementValue +
					"\" in the list!");
		}
		else
			System.out.println("  Success: Last index of \"" + data1[0] + "\": " + index);
		
		
		// Example #7A: Call "retainAll" to modify "list1" to be the intersection of
		//              itself with "list2" (Three elements in common)
		// First, reestablish both lists
		// list1: Clear, the add all items in array "data1"
		list1.clear();
		for (int value : data1)
			list1.add(value);
		// list2: Clear, the add all items in array "data3"
		list2.clear();
		for (int value : data3)
			list2.add(value);
		
		System.out.println("\nExample #7A: Modify \"list1\" to be the intersection of " +
				"itself with \"list2\"" +
						   "\n             (Three elements in common)" +
						 "  \n  list1 before intersection: " + list1 +
						   "\n                      list2: " + list2);
		if (!list1.retainAll(list2) )
			System.out.println("  Error: Empty intersection of \"list1\" with \"list2\"");
		else
			System.out.println("  Success: list1 after intersection: " + list1);
		
		
		// Example #7B: Call "retainAll" to modify "list1" to be the intersection of
		//              itself with "list2" (No elements in common)
		// First, reestablish both lists
		// list1: Clear, the add all items in array "data1"
		list1.clear();
		// Add all the "data1" items to the "list1"
		for (int value : data1)
			list1.add(value);
		// list2: Clear, the add all items in array "data4"
		list2.clear();
		for (int value : data4)
			list2.add(value);
		System.out.println("\nExample #7B: Modify \"list1\" to be the intersection of " +
				"itself with \"list2\"" +
						   "\n             (No elements in common)" +
						   "\n  list1 before intersection: " + list1 +
						   "\n                      list2: " + list2);
		if (!list1.retainAll(list2) )
			System.out.println("  Success: Empty intersection of \"list1\" with \"list2\"" +
							 "\n    list1: " + list1);
		else
			System.out.println("   Error: Common elements found!" +
							 "\n     list1 after intersection: " + list1);
		
		
		// Example #8A: Call "containsAll" to determine if all the elements in "list2"
		//              are contained in "list1". This test: All contained
		// First, reestablish both lists
		// list1: Clear, the add all items in array "data1"
		list1.clear();
		// Add all the "data1" items to the "list1"
		for (int value : data1)
			list1.add(value);
		// list2: Clear, the add all items in array "data5"
		list2.clear();
		for (int value : data5)
			list2.add(value);
		System.out.println("\nExample #8A: Determine if \"list1\" contains all the " +
				"elements in \"list2\"" +
						   "\n             (Does contain all elements)" +
						   "\n  list1: " + list1 +
						   "\n  list2: " + list2);
		if (list1.containsAll(list2) )
			System.out.println("  Success: \"list1\" contains all the elements in \"list2\"");
		else
			System.out.println("   Error: \"list1\" does NOT contain all the " +
					"elements in \"list2\"");
		
		
		// Example #8B: Call "containsAll" to determine if all the elements in "list2"
		//              are contained in "list1". This test: NOT all contained
		// First, reestablish "list2"
		list2.clear();
		for (int value : data6)
			list2.add(value);
		System.out.println("\nExample #8B: Determine if \"list1\" contains all the " +
				"elements in \"list2\"" +
						   "\n             (Does NOT contain all elements)" +
						   "\n  list1: " + list1 +
						   "\n  list2: " + list2);
		if (!list1.containsAll(list2) )
			System.out.println("  Success: \"list1\" does NOT contain all the elements in \"list2\"");
		else
			System.out.println("   Error: \"list1\" DOES contain all the " +
					"elements in \"list2\"");
		
	}   // End Static Method: main(String[])
	
}   // End class definition: Project8_Solution
