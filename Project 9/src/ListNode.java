/******************************************************************************
 *       Class: ListNode
 * Super Class: Object (Implicit)
 *  Implements: None
 *
 * Programmer: Robert Main

 * Revision     Date                          Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     05/31/2014  Initial Release
 * 
 * Class Description
 * -----------------
 * ListNode is a class for storing a single node of a linked list. This Node
 * Class is for a list of integer values.
 *
 * ----------------------------- Public Interface -----------------------------
 *        Method                               Description
 * ----------------------  ----------------------------------------------------
 * ListNode()              Default Constructor: Sets "data": 0, "next": "null"
 * ListNode(int)           Constructor: Sets "data", "next" to "null"
 * ListNode(int,ListNode)  Constructor: Sets "data" and "next"
 * 
 * ------------------------- Private Data Members -----------------------------
 *               Data
 *    Type       Type     Name                    Description
 * ----------  --------  ------  ----------------------------------------------
 * non-static  int       data    Node's "int" data value
 * non-static  ListNode  next    Reference: Next "ListNode" object
 *
 ******************************************************************************
 */
public class ListNode
{
	// Public Interface
	// 1. Constructors
	//    A. Default Constructor
	//       post: constructs an "empty" Node
	// post: constructs a node with "data": 0 and "next": "null"
	public ListNode()
	{
		this(0, null);
	}

	//    B. Initializing Constructor
	//       post: constructs a node with given "data" and "next": "null"
	public ListNode(int data)
	{
		this(data, null);
	}

	//    B. Initializing Constructor
	//       post: constructs a node with given "data" and given "next"
	public ListNode(int data, ListNode next)
	{
		this.data = data;
		this.next = next;
	}

	
	// Public Class Data Members
	// 1. Variable Declarations
	public int data;       // Data stored in this node
	public ListNode next;  // Link to next "ListNode" object in the LinkedList object

}	// End Class Definition: ListNode
