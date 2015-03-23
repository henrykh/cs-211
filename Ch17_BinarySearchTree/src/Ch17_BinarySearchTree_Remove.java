/******************************************************************************
 * Bellevue Class: CS-211
 * 
 * Textbook: Building Java Programs, A Back to Basics Approach, 2nd Edition
 *  Authors: Stuart Reges and Marty Stepp
 * 
 * Textbook Program Example
 *   Chapter: 17
 *     Pages: 1021
 *
 * Class Name: Ch17_BinarySearchTree_Remove
 * File Name:  Ch17_BinarySearchTree_Remove.java
 *
 * Programmer: Robert Main
 *
 * Revision     Date                        Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     06/11/2013  Initial Release
 *
 * File Description
 * ----------------
 * This file defines the the class "Ch17_BinarySearchTree_Remove", which
 * includes all methods, variables, and constant values. Specifically, this
 * class contains the Console application entry method, main(), which is a
 * static method, since no object of the class type is ever instantiated.
 * 
 * Class Methods
 * -------------
 *    Name                                    Description
 * ----------  ----------------------------------------------------------------
 * main        The OS transfers control to this method upon program execution
 *
 ******************************************************************************
 */
// Imported Package
import java.util.*;


class Ch17_BinarySearchTree_Remove
{
	/**************************************************************************
	 * Method: main(String[])
	 * 
	 * Description
	 * -----------
	 * This client program demonstrates the building of an "int" Binary,
	 * Search Tree structure, with random values added to the Tree to produce
	 * an "in order" traversal sequence.
	 * 
	 * This is accomplished by inserting Nodes in the left branch of the
	 * top-most root Node (first item added to the Tree) whose data values
	 * are less than that data value in the top-most root Node. Consequently,
	 * all items whose data values are greater than the data value in the
	 * top-most root Node are inserted in the right branch. By following this
	 * method at EACH level in the Tree, a sorted list will be created when
	 * traversed in the "in-order" traversal scheme.
	 * 
	 * The class also supports a search for a specific value in the Tree.
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
		// Initialized Variable Declarations
		// 1. Create an empty "SearchTree" object, of type "Integer"
		SearchTree<Integer> tree = new SearchTree<Integer>();
		// 2. Create a "Scanner" object, bound to the Console Input device 
		Scanner parser = new Scanner(System.in);
		Integer[] intValuesToAdd = { 42, 9, 18, 55, 7, 47, 108, 4, 70, 203, 15 };
		
		// Uninitialized Variable Declaration
		int data;
        
		
		// Describe the textbook program example to the User
		System.out.println("Chapter 17 - Binary Search Tree" +
						 "\n      Method: remove(<E>)\n");

/*		
		System.out.println("Example #1: Generic Type - \"Integer\"");
		do
		{
			System.out.print("  Next value to add (0 to quit): ");
			data = parser.nextInt();
			if (data != 0)
				tree.add(data);
		}
		while (data != 0);
*/
		for (int index = 0; index < intValuesToAdd.length; ++index)
			tree.add(intValuesToAdd[index]);
		
		// Display tree:
		System.out.println("\n  1. Visual representation of the tree:");
		System.out.println(tree);
		
		System.out.println(  "  2.   Maximum Tree Level: " + tree.countLevels() );
		System.out.println(  "  3.     Number of leaves: " + tree.countLeaves() );
		System.out.print(    "  4. ");
		tree.printPreOrder();
		System.out.print(    "  5. ");
		tree.printInOrder();
		System.out.print(    "  6. ");
		tree.printPostOrder();
		System.out.print(    "  7.          Sorted List:");
		tree.printSorted();
		System.out.println("\n  8. Remove Tree Nodes:");
		
		do
		{
			System.out.print("     Next value to remove (0 to quit): ");
			data = parser.nextInt();
			if (data != 0)
			{
				System.out.print("       ");
				if (tree.remove(data) )
				{
					System.out.println(data + " was found in the Tree");
					System.out.println(tree);
				}
				else
					System.out.println(data + " is NOT in the Tree");
			}		
		}
		while (data != 0);
		
		parser.close();
     
	}   // End method: main(String[])
	
}   // End class definition: Ch17_BinarySearchTree_Remove
