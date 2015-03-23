/******************************************************************************
 *       Class: Item
 * Super Class: (Inferred: Object)
 *  Implements: None
 *
 * Programmer: Henry Howes

 * Revision     Date                          Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     04/24/2014  Initial Release
 * 
 * Class Description
 * -----------------
 * This file defines the the class Item, including constructors to create items
 * with and without bulk quantity discounts. It also includes methods to access
 * the bulk quantity, calculate the price based on quantity, return a string
 * description of the item, and test for equality between two items.
 *
 * ----------------------------- Public Interface -----------------------------
 *           Method                               Description
 * --------------------------- ------------------------------------------------
 * Item(String name, double price)   Initializing Constructor                              
 * Item(String name, double price	 Initializing Constructor with bulk discount
 * int bulkQuantity, double
 * bulkDiscount) 
 * get bulkQuantity                  Returns bulk quantity
 * priceFor(int quantity)			 Returns the price based on the quantity and
 * 									 qualifying bulk discounts
 * toString()						 Returns the item's name, price, and bulk
 * 									 discount information, if applicable
 * equals(Item)                      Tests this item with another for equality 
 * ------------------------- Private Data Members -----------------------------
 *                  Data
 *    Type          Type         Name                    Description
 * ----------  --------------  ----------  ------------------------------------
 * non-static    String 	    name	    Stores the item's name
 * non-static    double			price 		Stores the item's regular price
 * non-static     int		 bulkQuantity	Stores the quantity required for a bulk discount
 * non-static    double 	  bulkPrice		Stores the bulk discount price for the bulk quantity
 ******************************************************************************
 */

public class Item {
	private String name;
	private double price;
	private int bulkQuantity;
	private double bulkPrice;
	
	//Constructor
	public Item(String name, double price){
		if(price<0){
			throw new IllegalArgumentException("Price must be positive");
		}
		this.name=name;
		this.price=price;
	}
	
	//Constructor for items with bulk discounts
	public Item(String name, double price, int bulkQuantity, double bulkPrice){
		if(price<0 || bulkQuantity<0 || bulkPrice<0){
			throw new IllegalArgumentException("Values must be positive");
		}
		this.name=name;
		this.price=price;
		this.bulkQuantity=bulkQuantity;
		this.bulkPrice=bulkPrice;
	}
	
	//Accessor, returns bulk quantity
	public int getBulkQuantity(){
		return bulkQuantity;
	}
	
	//Returns the price for a given quantity of an item
	public double priceFor(int quantity){
		if(quantity>=bulkQuantity && bulkQuantity !=0){
			double totalPrice= (quantity/bulkQuantity)*bulkPrice;
			totalPrice=totalPrice+(price*(quantity%bulkQuantity));
			return totalPrice;
		}
		else{
			return quantity*price;
		}
		
	}
	
	//Returns a string with the name and price of the item, including bulk discounts if applicable
	public String toString(){
		String str = name+" @ "+String.format("%.2f",price);
		if(bulkQuantity>0){
			str=str+String.format(" (%d for %.2f)", bulkQuantity, bulkPrice);
		}
		return str;
		
	}
	
	//Tests for equality between this item and another
	public boolean equals(Object obj){
		if(!(obj instanceof Item)){
			return false;
		}
		else{
			Item other = (Item) obj;
			return (this.name==other.name && this.price==other.price
					&& this.bulkQuantity==other.bulkQuantity &&
					this.bulkPrice==other.bulkPrice);
		}
	}
	
}
