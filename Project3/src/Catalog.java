/******************************************************************************
 *       Class: Catalog
 * Super Class: (Inferred: Object)
 *  Implements: None
 *
 * Programmer: Henry Howes

 * Revision     Date                          Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     04/24/2014   Initial Release
 * 
 * Class Description
 * -----------------
 * This class allows the client to create catalog objects, which store a list of item objects
 * in an arrayList. This class includes methods to return information on a catalog and a 
 * toString to print the name of the catalog and all the items in the array.
 *
 * ----------------------------- Public Interface -----------------------------
 *           Method                               Description
 * --------------------------- ------------------------------------------------
 * Catalog (String name)		 Initializing Constructor
 * add(GroceryItem)				 Adds an item to the catalog list
 * size()					     Returns the length of the catalog list
 * get(int i)			         Returns the item at position i in the list
 * getName()			         Returns the name of the catalog
 * toString()	                 Prints a string with the name of the catalog
 *                               and information about each item in it
 * equals(Catalog)               Tests this catalog with another for equality
 * 
 * ------------------------- Private Data Members -----------------------------
 *                  Data
 *    Type          Type         Name                    Description
 * ----------  --------------  ----------  ------------------------------------
 * non-static	String		     name       catalog's name as a string
 * non-static   ArraList<Item>   list		a list containing all the items in the catalog
 ******************************************************************************
 */

import java.util.*;

public class Catalog{
	private String name;
	private ArrayList<Item> list;
	
	//Constructor
	public Catalog(String name){
		this.name=name;
		this.list=new ArrayList<Item>();
	}
	
	//Adds an item to the catalog list
	public void add(Item item){
		list.add(item);
	}
	
	//Returns the size of the catalog list
	public int size(){
		return list.size();
	}
	
	//Returns the item at the given integer index
	public Item get(int i){
		return list.get(i);
	}
	
	//Returns the name of the catalog
	public String getName(){
		return name;
	}
	
	//Prints the name of the catalog and information on each item in the catalog
	public String toString(){
		String str = "Catalog: "+getName()+":";
		int itemNumber = 1;
		while(itemNumber<=list.size()){
			str = str+"\n  Item "+itemNumber+":\n     "+
				  list.get(itemNumber-1).toString();
			itemNumber++;
		}
		str=str+"\n";
		return str;
	}
	
	//Tests for equality between this catalog and another
	public boolean equals(Object obj){
		if(!(obj instanceof Catalog)){
			return false;
		}
		else{
			Catalog other = (Catalog) obj;
			
			return(this.name==other.name && (this.list.containsAll(other.list) && other.list.contains(this.list)));
		}
	}
}