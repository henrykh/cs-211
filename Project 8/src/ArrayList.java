/*********************************************************************************
 *       Class: JavaClassTemplate
 * Super Class: None (Object implied)
 *  Implements: Iterator
 *
 * Programmer: Robert Main

 * Revision     Date                          Release Comment
 * --------  ----------  ---------------------------------------------------------
 *   1.0     05/28/2013  Initial Release
 *   1.1     05/29/2013  Added comment in Initializing Constructor
 *                       Changes in class "ArrayListIterator", see its header.
 * 
 * Class Description
 * -----------------
 * This class defines features of an "ArrayList" of generic class object elements.
 *
 * ----------------------------- Public Interface --------------------------------
 *           Method                               Description
 * --------------------  ---------------------------------------------------------
 * ArrayIntList<E>()     Default Constructor: Creates an array of fixed size
 * ArrayIntList<E<(int)  Constructor: Creates an array of specified size
 * remove(int)           Removes element at specified index
 * remove(<E>)           Removes first element <E>, if it exists
 * add(int)              Adds an "int" element to the end of the list's array
 * add(int,int)          Add "int" element at specified index in the list
 * indexOf(int)          Searches list for element with specified value
 * size()                RETurns the size of the list (number of elements used)
 * get(int)              RETurns value at the specified list element index
 * addAll(ArrayList<E>)  Appends another list to "this" list
 * clear()               Purges the list of all items
 * contains(int)         Searches for "item": true - item found
 * equals(ArrayIntList)  Test "this" with other class object for equality
 * toString()            RETurns "String" description of class object
 * ensureCapacityint)    Helper method: Checks array capacity, resizes if required
 * testIndex(int)        Ensures index value is within allowed range for array
 * 
 * ------------------------- Private Data Members --------------------------------
 *               Data
 *    Type       Type       Name                    Description
 * ------------  -----  ------------  --------------------------------------------
 * static-final  int    DEFAULT_SIZE  Default size for the list's array
 * non-static    int[]  elements      The list's array
 * non-static    int    size          Number of elements in the array
 *
 *********************************************************************************
 */
// Imported Packages
import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayList<E>
{
	// Public Interface
	// 1. Constructors
	//    A. Default Constructor
	public ArrayList()
	{
		// Create an array for the elements of the predefined, fixed size
		// Note: Utilize the Initializing Constructor!!
		this(DEFAULT_SIZE);
	}
	
	//    B. Initializing Constructor
	@SuppressWarnings("unchecked") // See Note, below
	public ArrayList(int capacity)
	{
		// Make sure a positive value, greater than 0 is requested
		if (capacity < 1)
			throw new IllegalArgumentException();
		
		/* The capacity is valid, create the array of that size
		 *Note:
		 *  Java does not allow the creation of an array of a generic
		 *  type, only concrete types are allowed. Therefore, an array 
		 *  of type "Object" is created, which is then explicitly cast
		 *  to an array of the generic type. Java will issue a warning
		 *  indicating a possible illegal cast. This warning is issued
		 *  at compile time, since the type of "E" is unknown until
		 *  run time. The runtime error, in this case, will not occur
		 *  since all class methods that interact with the array
		 *  "elements" will access the elements as <E> objects.
		 *  
		 *  In order to eliminate the compiler warning, the "supressWarnings"
		 *  directive to the compiler is included, see above
		 */
		elements = (E[])new Object[capacity];
		size = 0;
	}
	
	//    C. Copy Constructor
	//       Not implemented
	
	// 2. Mutator Methods
	//    A. remove(int)
	//       Removes the element at the specified list index
	//       RETurns the value of the element removed
	//         Pre-Condition: None
	public E remove(int index)
	{
		// Make sure the specified index value can be removed!
		testIndex(index);
		
		E value = elements[index];
		
		// Collapse the list, by shifting all remaining (if any)
		// elements starting at the next element following the
		// specified index, one element to the left
		for (int index1 = index; index1 < size - 1; ++index1)
			elements[index1] = elements[index1 + 1];
		
		// The decrement the size of the list
		--size;
		// Make sure there is only ONE reference to the last
		// list element (a reference) that was shifted one element
		// to the left.
		elements[size] = null;
		
		return value;
	}
	//    B. add(int)
	//       Adds an item to the end of the list
	//         Pre-Condition: None
	public void add(E item)
	{
		// First, make sure there is still room in the array!
		ensureCapacity(1);
		
		// "Insert" the specified item at the end of the list
		elements[size] = item;
		// Then increment the size of the list
		++size;
	}
	//    C. add(int,int)
	//       Adds item at the specified index of the list
	//         Pre-Condition: None
	public void add(int index, E item)
	{
		// First, make sure there is still room in the array!
		ensureCapacity(1);
		// Then make sure the insertion can occur at the specified index value!
		testIndex(index);
		
		// Okay to add, must shift all elements starting with the specified
		// index, 1 element to the right...
		for (int index1 = size; index1 > index; --index1)
			elements[index1] = elements[index1 - 1];
		
		// Now "insert" the specified value at the specified index
		elements[index] = item;
		// And, of course, increment the size of the list
		++size;
	}
	
	//    D. clear()
	//       Purges the list of all items
	//         Pre-Condition: None
	public void clear()
	{
		// Before resetting "size" to 0, all used
		// elements must have their references set to "null",
		// to allow proper action by the Garbage Collector!
		for (int index = 0; index < size; ++index)
			elements[index] = null;
		// Now set the size of the list to 0
		size = 0;
	}
	
	// 3. Observer Methods
	//    A. indexOf(int)
	//       Searches the current list for the specified item value
	//         Pre-Condition: None
	public int indexOf(E item)
	{
		// Perform a linear search of the array, looking for the
		// the first occurrence of the specified item
		for (int index = 0; index < size; ++index)
		{	// Does the next array element match?
			if (elements[index].equals(item) )
			{	// Yes, RETurn its index value
				return index;
			}
		}
		// Otherwise, the item value was NOT found!
		return -1;
	}
	//
	//    B. size()
	//       RETurns the current size of the list
	//         Pre-Condition: None
	public int size()
	{
		return size;
	}
	//
	//    C. get(int)
	//       RETurns the value at the specified array index element
	//         Pre-Condition: None
	public E get(int index)
	{
		// Make sure an item at the specified index value exists!
		testIndex(index);
		
		return elements[index];
	}
	//
	//    D. contains(int)
	//       Searches the current list for the specified item value
	//         Pre-Condition: None
	public boolean contains(E item)
	{
		return (indexOf(item) >= 0);
	}
	//    E. iterator()
	public Iterator<E> iterator()
	{		
		return new ArrayListIterator();
	}
		
	
	// 4. Virtual (late binding) Methods: Extensions of class "Object"
    //    A. equals(Object)
    public boolean equals(Object object)
    {
    	boolean isEqual = false;
    	
    	if (object instanceof ArrayList)
    	{
    		@SuppressWarnings("unchecked")
			ArrayList<E> other = (ArrayList<E>) object;
    		
    		if (elements.length == other.elements.length  &&  size == other.size)
    		{
    			isEqual = true;
    			for (int index = 0; isEqual && index < size; ++index)
    				isEqual = elements[index] == other.elements[index];
    				
    		}         	
    	}
    	
		return isEqual;
    }
	//    B. toString()
    //       Constructs Description "String" of the object
	public String toString()
	{
		// Build your class specific "String" object here...
		String str = "[";
		if (size == 0)
			str += ']';
		else
		{
			str += elements[0];
			for (int index = 1; index < size; ++index)
				str += (", " + elements[index]);
			str += ']';
		}
		
		return str;
	}
	
	// 5. Class Helper methods
	//    A. ensureCapacity(int)
	//       Determines if specified number of elements can be added.
	//       If not, a new array is created at least twice as big as the
	//       current array, and the current list elements are copied to
	//       the new array, which then replaces the old array.
	//       Post: Throws "OutOfMemoryError" if new Array cannot be allocated
	private void ensureCapacity(int elementsToAdd)
	{
		int requiredCapacity = size + elementsToAdd;
		
		if (requiredCapacity > elements.length)
		{
			int newCapacity = 2 * requiredCapacity;
			
			@SuppressWarnings("unchecked")
			E[] newList = (E[])new Object[newCapacity];
			
			for (int index = 0; index < size; ++index)
				newList[index] = elements[index];
			
			elements = newList;
		}
	}
	//    B. testIndex(int)
	//       Checks index value for non-inclusive maximum value
	//       Post: Throws "IllegalStateException" if "index" is invalid
	private void testIndex(int index)
	{
		if (index < 0  ||  index > size - 1)
			throw new IllegalStateException();
	}
	
	
	// 6. Added methods
	
	
    //Checks whether this list contains all the elements in the given list
	public boolean containsAll(ArrayList<E> list){
		for(int i = 0; i<list.size; i++){
			if(!(this.contains(list.get(i)))){
				return false;
			}
		}
		return true;
	}
	
	//Searches for and removes the first instance of the given item
	public boolean remove(Object item){
		for(int i=0; i<size; i++){
			if(elements[i].equals(item)){	
				for (int index1 = i; index1 < size - 1; ++index1){
					elements[index1] = elements[index1 + 1];
				}
				size--;
				elements[size]=null;
			return true;
			}
		}
		return false;
	}
	
	//Removes, from the list, all elements found in the given list.
	//Then, returns true if the list was changed.
	public boolean removeAll(ArrayList<E> list){
		boolean removed=false;
		for(int i = 0; i<size; i++){
			if(list.contains(elements[i])){
				this.remove(elements[i]);
				removed = true;
				i--;
			}
		}
		return removed;
	}
	
	//Retains, in the list, only those elements found in the given list.
	//Then, returns true if the list was changed.
	public boolean retainAll(ArrayList<E> list){
		boolean retained = true;
		
		//The commented-out "boolean changed" lines abide
		//by the Java API suggestion that the method
		//should return true if the list was changed but
		//do not produce the correct output from the client.
		
		//boolean changed = false;
		for(int i=0; i<size; i++){
			if(!list.contains(elements[i])){
				this.remove(elements[i]);
				//changed = true;
				i--;
			}
		}
		if(size==0){
			retained = false;
		}
		
		return retained;
	}
	
	//Returns the index of the last instance of the given item
	public int lastIndexOf(Object item){
		for (int i = size-1; i>=0; i--){
			if(elements[i].equals(item)){
				return i;
			}
		}
		return -1;
	}
	
	
	// Private Class Data Members
	// 1. Constant "final" Value Declarations
	private static final int DEFAULT_SIZE = 100;
	
	// 2. Variable Declarations
	private E[] elements;
	private int size;
	
	
	/******************************************************************************
	 * Inner Class: ArrayListIterator
	 * Super Class: None ("ArrayList<E>" implied)
	 *  Implements: Iterator<E>
	 *
	 * Programmer: Robert Main

	 * Revision     Date                          Release Comment
	 * --------  ----------  ------------------------------------------------------
	 *   1.0     05/28/2013  Initial Release
	 *   1.1     05/29/2013  Added general comments.
	 *                       Removed unnecessary cast to "E" in method "next"
	 * 
	 * Class Description
	 * -----------------
	 * This class defines an Iterator object, bound to the "ArrayList<E>" class.
	 * By defining the class within the "ArrayList<E>" class, this class has access
	 * to all the data members and methods of that class. This eliminates the need
	 * for a private data member reference to a list object of type "ArrayList<E>".
	 * 
	 * This class defines the standard, required Java methods for an Iterator.
	 *
	 * ----------------------------- Public Interface -----------------------------
	 *           Method                               Description
	 * ---------------------------------- -----------------------------------------
	 * ArrayIntListIterator(ArrayIntList) Default Constructor: Reference to list
	 * hasNext()                          Determines if more elements to iterate
	 * next()                             RETurns next element, if another exists
	 * remove()                           Removes element "position", if allowed
	 * 
	 * ------------------------- Private Data Members -----------------------------
	 *                 Data
	 *    Type         Type         Name                    Description
	 * ----------  ------------  --------  ----------------------------------------
	 * non-static  ArrayIntList  list      Reference to list to be iterated
	 * non-static  int           position  Next position in the list
	 * non-static  boolean       removeOk  true: Element "position" can be removed
	 *
	 ******************************************************************************
	 */
	// Imported Packages
	// None
	
	// Since this class implements the methods of the "Iterator" Interface, and
	// since class "Iterator" is a generic Interface, it must be declared with
	// the <E> declared in the outer class, "ArrayList<E>".
	private class ArrayListIterator implements Iterator<E>
	{
		// Public Interface
		// 1. Constructors
		//    A. Default Constructor
		public ArrayListIterator()
		{
			position = 0;
			removeOk = false;
		}
			
		// 2. Mutator Methods
		//    A. remove()
		public void remove()
		{
			if (!removeOk)
			{	// Not allowed to remove
				// "next()" was not immediately called prior 
                throw new IllegalStateException();
            }
            
			// Adjust the (next) position pointer, since the next position
			// to access will be at the same location as the element removed.
			--position;
			/* "position" is now the index of the array element to remove.
			 * Note:
			 *   Will utilize the "remove" method in class "ArrayList" to
			 *   accomplish the removal. Since that method signature as the
			 *   same as in this class, the call must be scoped to the
			 *   "ArrayList" class, using the "dot" Operator.
			 */
			ArrayList.this.remove(position);
			// Not allowed to remove again until the next call to
			// "next()" occurs.
			removeOk = false;
		}
		
		// 3. Observer Methods
		//    A. hasNext()
		//       RETurns "true" if the "position" index is within the range
		//       of valid index values; otherwise, "false" RETurned.
		public boolean hasNext()
		{
			return position < size();
		}
		
		//    B. next()
		//       RETurns the next array value, if more elements to iterate
		//       Throws "NoSuchElementException" if iteration is already
		//       completed.
		public E next()
		{
			if (!hasNext() )
				throw new NoSuchElementException();
			
			// Retrieve the next element
			E value = get(position);
			
			// Point to the next element (if one exists)
			++position;
			// Allowed to "remove" the element just accessed
			removeOk = true;
			
			return value;
		}

		
		// Private Class Data Members
		int position;
		boolean removeOk;
		
	}	// End Class Definition: ArrayListIterator
	
}	// End Class Definition: ArrayList<E>
