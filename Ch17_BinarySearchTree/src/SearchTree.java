/******************************************************************************
 * Generic Class: SearchTree<E>
 *   Super Class: None (Object inferred)
 *    Implements: Comparable<E>
 *
 * Programmer: Robert Main

 * Revision     Date                          Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     06/19/2013  Initial Release
 * 
 * Class Description
 * -----------------
 * This class represents a generic, Binary Search Tree Data Structure, whose
 * data type is specified during instantiation of the "SearchTree<E> object.
 * This version of the class provides two Constructors, 1) A Default Constructor
 * that sets the reference to the top-most Tree Node to "null", i.e. an empty
 * Tree, and 2) An Initializing Constructor that creates one Node that becomes
 * the top-most Node in the Tree.
 * 
 * This version of the class adds the "remove" method, which removes the Node,
 * if present, whose data value matches that passed as a parameter to the
 * method. This method invokes a recursive method to search and remove
 * the specified Node. The recursive method is located in the internal,
 * "TreeNode" class for convenience. A description of the remove algorithm
 * is contained there,
 * 
 * This class contains a method to add a Node to the tree. In this case, the
 * client supplies the data value for the Node, and the method, "add" will
 * insert the Node at the proper point, such that the Node data values will
 * appear sorted, in ascending order, when an in-order traversal of the Tree
 * is performed.
 * 
 * The overridden "toString()" method will present a "sideways", visual view
 * of the Tree structure.
 * 
 * In addition, public, recursive methods are provided to display the Tree
 * traversals for pre-order, in-order, and post-order traversal schemes.
 * 
 * Common public methods are provided to, 1) The maximum level of the Tree,
 * and 2) The number of leaf Nodes in the Tree.
 * 
 * Finally, this class implements a method to search the tree for a specified
 * Node data value. The method, "contains" determines if a specific value is
 * in the Tree. If the Tree is well balanced, the search algorithm approaches
 * O(logN) complexity.
 *
 * ----------------------------- Public Interface -----------------------------
 *   Public Methods                           Description
 * -----------------  ---------------------------------------------------------
 * SearchTree()       Default Constructor: Tree set to "empty"
 * SearchTree(<E>)    Constructor: Creates top-most Tree Root Node
 * add(<E>)           Adds a Node to the Tree, in sorted order.
 * remove(<E>)        Removes Node, if present, with specified data value
 * contains(<E>)      Determines, by a binary Search, if Tree contains "value"
 * printPreOrder()    Request to display Tree in pre-order traversal sequence
 * printInOrder()     Request to display Tree in in-order traversal sequence
 * printPostOrder()   Request to display Tree in post-order traversal sequence
 * countLevels()      Request for the maximum levels in the Tree
 * countLeaves()      Request for the number of leaf Nodes in the Tree
 * toString()         RETurns the "String" of the Tree in "sideways" format
 * 
 *      Private Methods                               Description
 * -------------------------------- -------------------------------------------
 * printPreOrder(TreeNode<E>)       Display pre-order traversal sequence
 * printInOrder(TreeNode<E>)        Display in-order traversal sequence
 * printPostOrder(TreeNode<E>)      Display post-order traversal sequence
 * countLevels(TreeNode<E>)         RETurn the maximum levels in the Tree
 * countLeaves(TreeNode<E>)         RETurn the number of leaf Nodes in the Tree
 * displaySideways(TreeNode<E>,int, RETurns the "String" of Tree in a visual,
 *                 String,int)      "sideways" display format
 * 
 * ------------------------- Private Data Members -----------------------------
 *                Data
 *    Type        Type           Name                    Description
 * ----------  ------------  ------------  ------------------------------------
 * non-static  IntTreeNode   topRootNode   Reference to the top-most Tree Node
 *
 ******************************************************************************
 */
// Imported Packages
// None

public class SearchTree<E extends Comparable<E> >
{
	// Public Interface
	// 1. Constructors
	//    A. Default Constructor
	public SearchTree()
	{
		topRootNode = null;
	}
	
	//    B. Initializing Constructor
	public SearchTree(E data)
	{
		topRootNode = new TreeNode<E>(data);
	}
	
	//    C. Copy Constructor
	//       Not implemented  
	
	// 3. Mutator Methods
	//    A. add(<E>)
	public void add(E data)
	{
		topRootNode = add(topRootNode, data);
	}
	//    B. remove(<E>)
	public boolean remove(E value)
	{
		if (topRootNode == null)
		{	// The Tree is empty, removal fails
			return false;
		}
		else
		{	// Need to determine if the top-most Node is 
			// the Node to remove
			if (topRootNode.data.compareTo(value) == 0)
			{	/* Top-most Node needs to be removed.
				 * The algorithm depends on a parent Node from which to start
				 * the search sequence.
				 * Create a "dummy" Node, with its left branch pointing to the
				 * top-most Node of "this" Tree and no right branch. The value
				 * of the Node is irrelevant.
				 */
				TreeNode<E> auxRoot = new TreeNode<E>();
				auxRoot.leftBranch = topRootNode;
				// Now start the recursive search/remove from the top-most Node
				// of this tree, with the "parent" being the "dummy" Node
				boolean result = topRootNode.remove(value, auxRoot);
				// When complete, the "dummy" Node's left branch becomes
				// the new, top-most Node of "this" Tree
				// Note: If no node is removed, the "dummy" Node's left branch
				//       will still be pointing to "this" Tree's top-most Node.
				topRootNode = auxRoot.leftBranch;
				
				return result;  // RETurn the status of the search/remove
			}
			else
			{
				return topRootNode.remove(value, null);
			}
		}
	}
	// 4. Observer Methods
	//    A. printInOrder()
	public void printInOrder()
	{
		System.out.print("  In Order Traversal:");
		printInOrder(topRootNode);
		System.out.println();
	}
	//    B. printPreOrder()
	public void printPreOrder()
	{
		System.out.print(" Pre-order Traversal:");
		printPreOrder(topRootNode);
		System.out.println();
	}
	//    C. printPostOrder
	public void printPostOrder()
	{
		System.out.print("Post-order Traversal:");
		printPostOrder(topRootNode);
		System.out.println();
	}
	//    D. printSorted()
	public void printSorted()
	{
		printInOrder(topRootNode);
	}
	//    D. countLevels()
	public int countLevels()
	{
		return countLevels(topRootNode);
	}
	//    E. countLeaves()
	public int countLeaves()
	{
		return countLeaves(topRootNode);
	}
	//    F. contains(<E>)
	public boolean contains(E value)
	{
		return contains(topRootNode, value);
	}
	// 4. Virtual (late binding) Methods: Extensions of class "Object"
	//    A. toString()
    //       Constructs Description "String" of the object
	public String toString()
	{
		String str = "";
		
		return printSideways(topRootNode, 0, str, 8);
	}
	

	
	// Private Class Members
	// 1. Private Class Data Members
	//    A. Variable Declarations
	private TreeNode<E> topRootNode;
	//    B. Methods
	//       i. Mutator Methods
	//          a. add(TreeNode<E>,<E>)
	private TreeNode<E> add(TreeNode<E> root, E data)
	{
		// Base Case: The insertion point is at a leaf Node
		if (root == null)
		{
			root = new TreeNode<E>(data);
		}
		else if (data.compareTo(root.data) < 0)
		{
			root.leftBranch = add(root.leftBranch, data);
		}
		else
		{
			root.rightBranch = add(root.rightBranch, data);
		}
		
		return root;
	}
	//
	//       ii. Observer Methods
	//          a. printInOrder(TreeNode<E>)
	private void printInOrder(TreeNode<E> root)
	{
		// Test for NOT the Base Case, as nothing is to done for the Base Case,
		// i.e. just RETurn to the previous Tree level.
		if (root != null)
		{	// At EACH Tree level, display the left branch Node first
			printInOrder(root.leftBranch);
			// Next, display THIS Node's data
			System.out.print(" " + root.data);
			// Then finally, display the right branch Node
			printInOrder(root.rightBranch);
		}
	}
	//          b. printPreOrder(TreeNode<E>)
	private void printPreOrder(TreeNode<E> root)
	{
		// Test for NOT the Base Case, as nothing is to done for the Base Case,
		// i.e. just RETurn to the previous Tree level.
		if (root != null)
		{	// At EACH Tree level, display THIS Node's data first
			System.out.print(" " + root.data);
			// Next, display the left branch Node 
			printPreOrder(root.leftBranch);
			// Then finally, display the right branch Node
			printPreOrder(root.rightBranch);
		}
	}
	//          c. printPostOrder(TreeNode<E>)
	private void printPostOrder(TreeNode<E> root)
	{
		// Test for NOT the Base Case, as nothing is to done for the Base Case,
		// i.e. just RETurn to the previous Tree level.
		if (root != null)
		{	// At EACH Tree level, display the left branch Node first
			printPostOrder(root.leftBranch);
			// Next, display the right branch Node
			printPostOrder(root.rightBranch);
			// Then finally, display THIS Node's data
			System.out.print(" " + root.data);
		}
	}
	//          d. countLevels(TreeNode<E>)
	private int countLevels(TreeNode<E> node)
	{
		// Base Case: No further Nodes
		if (node == null)
		{
			// This initializes the accumulating sum of the branch levels
			return 0;
		}
		else
		{	// More branch levels left
			// Count the number of left and right branch levels remaining
			int leftLevels =  countLevels(node.leftBranch);
			int rightLevels = countLevels(node.rightBranch);
			
			// Then return the maximum of the two branch levels, plus 1
			// (1 Tree Node, levels = 1)
			return (1 + Math.max(leftLevels, rightLevels) );
		}
	}
	//          e. countLeaves(TreeNode<E>)
	private int countLeaves(TreeNode<E> node)
	{
		// Base Case: No further Nodes
		if (node == null)
		{
			// This initializes the accumulating sum of branch leaves
			return 0;
		}
		else
		{	// More branch levels left
			// Count the number of left and right branch levels remaining
			if (node.leftBranch == null  &&  node.rightBranch == null)
				return 1;  // We have found the last leaf Node of the branch
			else
			{	// Otherwise, need to "dig" deeper into the tree to find the
				// last leaf node of the branch
				int leafNodesLeft =  countLeaves(node.leftBranch);
				int leafNodesRight = countLeaves(node.rightBranch);
				
				return leafNodesLeft + leafNodesRight;
				
			}
		}
	}
	//         f. contains(TreeNode<E>,<E>)
	public boolean contains(TreeNode<E> node, E value)
	{
		if (node == null)
		{	// Found a leaf Node, hence the value sought is NOT in the Tree!
			return false;
		}
		else if (value.equals(node.data))
		{	// Found a match!!
			// Can stop the search
			return true;
		}
		else
		{	// Not a leaf Node AND the Node's data does NOT match the sought value...
			if (value.compareTo(node.data) < 0)
			{	// Need to search the Left Branch (Values > current nodes...
				return contains(node.leftBranch, value);			
			}
			else
			{	// Otherwise, search the right branch Nodes...
				return contains(node.rightBranch, value);
			}
		}
	}	
	//          g. printSideways(TreeNode,<E>,int,String,int)
	private String printSideways(TreeNode<E> node, int level, String str, int indent)
	{
		// Test for NOT the Base Case, as nothing is to done for the Base Case,
		// i.e. just RETurn to the previous Tree level.
		if (node == null)
			
		{
			for (int count = 1; count <= indent; ++count)
				str += ' ';
			for (int count = 1; count <= level; ++count)
				str += "     ";
			str += "xxx\n";
		}
		else		
		{	// For the visual display of the Tree, the right
			// branch Nodes are to be displayed first, since
			// the deepest, right Node is displayed on the
			// first display line.
			
			// Find the deepest right Node, from THIS root level
			str = printSideways(node.rightBranch, level + 1, str, indent);
			// Before displaying it, need to give level spacing
			for (int count = 1; count <= indent; ++count)
				str += ' ';
			for (int count = 1; count <= level; ++count)
				str += "     ";
			
			// Will display the Nodes "in order"  traversal
			str += (node.data);
			if (node.leftBranch == null  &&  node.rightBranch == null)
				str += " (leaf)";
			str += '\n';
			// Now find all the left branch Nodes, from THIS root level
			str = printSideways(node.leftBranch, level + 1, str, indent);
		}
		
		return str;
	}
	
	// 3. Internal Class Definitions
	/**************************************************************************
	 * Generic Class: TreeNode<E> (Internal, Generic Class)
	 *   Super Class: None (Object inferred)
	 *    Implements: None
	 *
	 * Programmer: Robert Main
	 *
	 * Revision     Date                          Release Comment
	 * --------  ----------  --------------------------------------------------
	 *   1.0     06/19/2013  Initial Release
	 * 
	 * Class Description
	 * -----------------
	 * This class represents a Tree Node, whose date element is a "Generic"
	 * value. Tree Nodes have two references to other Tree Node objects,
	 * designated as the left and right Tree branches.
	 * 
	 * The data members are declared public to facilitate access to the Node's
	 * data and branch references. The class is defined within the "SearchTree"
	 * class definition to prohibit access by client code. Thus declaring the
	 * data members as public does not violate the intention of OO designs to
	 * encapsulate the data with client accessible methods.
	 * 
	 * This class contains a non-static, recursive method to remove a Node.
	 * It acts on a TreeNode object and receives two arguments, 1) The data
	 * value of a Node to remove, and 2) A reference to the "parent" of "this"
	 * Node.
	 * 
	 * The algorithm is as follows:
	 * 1. "this" Node's data value is compared with the data value to remove
	 * 2. If the value to remove is LESS THAN "this" Node's data value, then
	 *    the left branch of "this" Node must be searched recursively, unless
	 *    the left branch is empty, in which case there is no Node in the Tree
	 *    whose value matches the data vale to remove. In this case, the method
	 *    is invoked for the left branch Node, with the new parent being "this"
	 *    Node.
	 * 2. If the value to remove is GREATER THAN "this" Node's data value, then
	 *    the right branch of "this" Node must be searched recursively, unless
	 *    the right branch is empty, in which case there is no Node in the Tree
	 *    whose value matches the data vale to remove. In this case, the method
	 *    is invoked for the right branch Node, with the new parent being "this"
	 *    Node.
	 * 3. If "this" Node's data matches the selected value, then "this" Node is
	 *    to be removed. In this case, there are three possibilities:
	 *    A. "this" Node has two, non-null branches. This requires the Node with
	 *       the smallest value in the left branch (i.e the branch with ALL
	 *       values GREATER than "this" Node's data) to replace "this" Node.
	 *       Rather than removing "this" Node and "moving" the Node with the
	 *       smallest value in the left branch to the position of "this" Node,
	 *       the DATA from the smallest Node can simply replace the data value
	 *       of "this" Node, then the Node with the smallest value in the left
	 *       branch (of "this" Node) can be removed. Note that
	 *    If case A is not true, then "this Node is either a leaf OR, only
	 *    one branch exists.
	 *    B. The parent's left branch points to "this" Node. In this case, the
	 *       parent's left branch needs to "skip" over "this" Node OR be set
	 *       to "null" if "this" Node is a leaf. This is most efficiently
	 *       accomplished by setting the parent's left branch to 1) "this"
	 *       Node's left branch, if it is not "null"; otherwise set it to
	 *       "this" Node's right branch. If "this" Node is a leaf, then the
	 *       parent's left branch will be set to "null", as "this" right branch
	 *       is "null" in this case.
	 *    C. The parent's right branch points to "this" Node. In this case, the
	 *       parent's right branch needs to "skip" over "this" Node OR be set
	 *       to "null" if "this" Node is a leaf. As in the previous case, this
	 *       is most efficiently accomplished by setting the parent's right
	 *       branch to 1) "this" Node's left branch, if it is not "null";
	 *       otherwise set it to "this" Node's right branch. If "this" Node is
	 *       a leaf, then the parent's right branch will be set to "null", as
	 *       "this" right branch is "null" in this case.
	 *
	 * ------------------------- Public Data Members --------------------------
	 *                Data
	 *    Type        Type        Name                Description
	 * ---------- ----------- ----------- -------------------------------------
	 * non-static <E>         data        Node's data
	 * non-static TreeNode<E> leftBranch  Reference: Left, TreeNode<E> object
	 * non-static TreeNode<E> rightBranch Reference: Right, TreeNode<E> object
	 * 
	 * ----------------------------- Public Interface -------------------------
	 *     Method                            Description
	 * ----------------------  ------------------------------------------------
	 * TreeNode()              Default Constructor: "Empty" Tree Node
	 * TreeNode(<E>)           Initializing Constructor: data only (leaf Node)
	 * remove(<E>,TreeNode<E>  Remove Node with specified data value
	 * 
	 **************************************************************************
	 */
	@SuppressWarnings("hiding")
	private class TreeNode<E extends Comparable<E> >
	{
		// Public Interface
		public E data;
		public TreeNode<E> leftBranch;
		public TreeNode<E> rightBranch;
		
		// 2. Constructors		
		//   A. Initializing Constructors
		//      i. Data only
		public TreeNode()
		{
			leftBranch =  null;
			rightBranch = null;			
		}
		
		
		public TreeNode(E data)
		{
			this.data = data;
			leftBranch =  null;
			rightBranch = null;
		}
		
		public boolean remove(E value, TreeNode<E> parent)
		{
			/* Compare the search value with the "this" Node's data
			 * to determine the next course of action:
			 * 1. If less, continue the search in the parent's left branch
			 * 2. If greater, continue the search in the parent's right branch
			 * 3. A match is found, requiring the removal of the
			 *    current Node, with possible modification of one of
			 *    the parent's branch references:
			 *    A. The Node is a leaf  (simplest removal, parent's
			 *       branch reference set to "null")
			 *    B. The Node has only one branch (either left or right)
			 *       Parent's branch reference is set to to Node's (to remove)
			 *       branch reference.
			 *    C. The Node has both branches defined (most complex)
			 *       (Node's data set to smallest value in its left branch
			 *        and then that Node is removed.
			*/
			// First, compare the search value with this parent's Node value
			int comparison = value.compareTo(data);
			
			// Now determine the next course of action...
			if (comparison < 0)
			{	// The search value is LESS than the "parent"'s value
				// Need to search, if possible, the "parent"'s left branch
				if (leftBranch != null)
				{	/* The left branch exists, so search it
					 * "this" Node, at this level in the call Stack now
					 * becomes the "parent" in the next recursive call, and
					 * the Node referred to by the left branch reference
					 * becomes the new descendant (child) to search.
					 * 
					 * The status of the search and remove is passed back-up
					 * the call call Stack
					 */
					return leftBranch.remove(value, this);
				}
				else
				{	// Otherwise, there is no where else to search, so
					// RETurn "false": Search value is NOT in the Tree
					return false;
				}
			}
			
			else if (comparison > 0)
			{	// The search value is GREATER than the "parent"'s value
				// Need to search, if possible, the "parent"'s right branch
				if (rightBranch != null)
				{	/* The right branch exists, so search it
					 * "this" Node, at this level in the call Stack now
					 * becomes the "parent" in the next recursive call, and
					 * the Node referred to by the right branch reference
					 * becomes the new descendant (child) to search.
					 */
					return rightBranch.remove(value, this);
				}
				else
					return false;
			}
			else
			{	// "this" Node contains the search value, so it must be removed
				if (leftBranch != null && rightBranch != null)
				{	// The most complex case, the Node has two, non-empty branches
					// Find the Node in the right branch (all values greater
					// than the value in "this" parent Node to remove) that has
					// the smallest (of the largest) value, then replace the
					// value at "this" parent Node with the value found
					this.data = rightBranch.minValue();

					// Now remove that Node, the one with the minimum value
					// From the Tree. This in effect, "removes" this parent
					// Node from the Tree
					rightBranch.remove(data, this);

				}
				else if (parent.leftBranch == this)
				{	// In this case, the left branch of the parent points
					// to "this" Node, the Node that matches for removal.
					// The Parent's left branch depends on "this" Node's
					// left branch. If not "null", then the Parent's left
					// branch points to it; otherwise, the Parent's left
					// branch points to "this" Node's right branch.
					// Note: If "this" Node is a leaf, then the Parent's
					//       left branch will point to "null", thus removing
					//       "this" Node from the original Tree
					parent.leftBranch =
							(leftBranch != null) ? leftBranch : rightBranch;

				} else if (parent.rightBranch == this)
				{	// In this case, the right branch of the parent points
					// to "this" Node, the Node that matches for removal.
					// The Parent's right branch depends on "this" Node's
					// left branch. If not "null", then the Parent's left
					// branch points to it; otherwise, the Parent's left
					// branch points to "this" Node's right branch.
					// Note: If "this" Node is a leaf, then the Parent's
					//       right branch will point to "null", thus removing
					//       "this" Node from the original Tree
					parent.rightBranch =
							(leftBranch != null) ? leftBranch : rightBranch;
				}

				return true;
			}
			
		}

		public E minValue()
		{	// This recursive method will search consecutive
			// Tree left branches until the successive searches
			// result in the left branch (of the final, left branch Node)
			// pointing to "null"
	    	if (leftBranch == null)
	    	{	// No more left branches, so "this" Node contains
	    		// the minimum value of all preceding left branches
	    		// RETurn its data value
	    		return data;
	    	}
	    	else
	    	{	// The left branch exists, search it...
	    		return leftBranch.minValue();
	    	}

		}


		
	}	// End Internal Class Definition: TreeNode<E>
	
}	// End Class Definition: SearchTree<E extends Comparable<E> >
