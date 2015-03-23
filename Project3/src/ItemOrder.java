/******************************************************************************
 *       Class: ItemOrder
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
 * This class allows the client to create Item Order objects, which represent an order for
 * a given quantity of an item and can then be added to a shopping cart. This class
 * includes methods to return item, quantity, and price information as well as a
 * toString() method to print the item ordered and the final price (including any
 * available quantity discounts).
 *
 * ----------------------------- Public Interface -----------------------------
 *           Method                               Description
 * --------------------------- ------------------------------------------------
 * ItemOrder (Item item, int     Initializing constructor for an order of the
 * quantity)		 			 specified number of an item
 * getPrice()					 Returns the price for the specified quantity
 * getItem()					 Returns the item ordered
 * getQuantity()				 Returns the quantity ordered
 * toString()	                 Prints a string with the item, quantity and price
 * equals(Catalog)               Tests this item order with another for equality
 * 
 * ------------------------- Private Data Members -----------------------------
 *                  Data
 *    Type          Type         Name                    Description
 * ----------  --------------  ----------  ------------------------------------
 * non-static	    Item		 item       the item ordered
 * non-static       int         quantity	the quantity ordered
 ******************************************************************************
 */

public class ItemOrder{
	
	private Item item;
	private int quantity;
	
	
	//Constructor, creates an order for the given item with the specified quantity
	public ItemOrder(Item item, int quantity){
		if(quantity<0){
			throw new IllegalArgumentException("Quantity must be positive");
		}
		else{
			this.item=item;
			this.quantity=quantity;
		}
	}
	
	//Returns the price for the specified quantity, accounting for available bulk discounts
	public double getPrice(){
		return item.priceFor(quantity);
	}
	
	//Returns the item ordered
	public Item getItem(){
		return item;
	}
	
	//Returns the quantity ordered
	public int getQuantity(){
		return quantity;
	}
	
	//Returns the order in a string, with item information and price based on quantity
	public String toString(){
		String str=this.item.toString()+"\n  Quantity: "+this.quantity+
			String.format("\n  Final Price: %.2f\n\n", this.getPrice());
		
		return str;
	}
	
	//Tests this order with another for equality
	public boolean equals(Object obj){
		if(!(obj instanceof ItemOrder)){
			return false;
		}
		else{
			ItemOrder other = (ItemOrder) obj;
			
			return (this.item==other.item && this.quantity==other.quantity);
		}
	}
}