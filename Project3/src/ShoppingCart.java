/******************************************************************************
 *       Class: ShoppingCart
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
 * This class allows the client to create Shopping Cart objects, which create a
 * list to store item orders, check for preferred customer discounts, and print
 * receipts. Contains methods to add item orders to the cart, set the discount,
 * return information on the cart, and print a receipt with item order information
 * and totals, with subtotal and discount information for preferred customers. 
 *
 * ----------------------------- Public Interface -----------------------------
 *           Method                               Description
 * --------------------------- ------------------------------------------------
 * ShoppingCart()		 		 Initializing constructor, creates a new ArrayList
 * 								 for item orders
 * add(ItemOrder order)			 Adds an itemOrder to the shopping cart list
 * setDiscount(Boolean value)	 Sets the discount field for preferred customers
 * getTotal()					 Returns the total price of the cart's item orders
 * toString() 					 Returns a receipt for the cart, with info on each
 * 								 item order as well as the total and subtotal/discount
 * 								 information for preferred customers
 * equals(ShoppingCart other)    Tests for equality between this and another cart
 * ------------------------- Private Data Members -----------------------------
 *                  Data
 *    Type          Type         Name                    Description
 * ----------  --------------  ----------  ------------------------------------
 * non-static  ArrayList<ItemOrder> cart	 list to store the item orders in the cart
 * non-static     boolean        discount    stores whether customer gets discount
 * non-static     double         total       stores the total based on the orders
 ******************************************************************************
 */

import java.util.*;

public class ShoppingCart{
	private ArrayList<ItemOrder> cart;
	private boolean discount;
	private double total;
	
	//Initializing constructor
	public ShoppingCart(){
		this.total=0;
		this.cart = new ArrayList<ItemOrder>();
		this.discount=false;
	}
	
	//Adds an item order to the cart, replacing any previous
	//orders for that item, and updating the total
	public void add(ItemOrder order){
		boolean duplicate = false;
		
		for(ItemOrder listOrder: cart){
			if(listOrder.getItem()==order.getItem()){
				total=total-listOrder.getPrice();
				  cart.set(cart.indexOf(listOrder), order);
				  duplicate=true;
			}
		}
		if(!duplicate){
			cart.add(order);
		}
	
		this.total=total+order.getPrice();
	}
	
	//Sets the discount for a preferred customer
	public void setDiscount(Boolean value){
		this.discount=value;
	}
	
	//Returns the total for the item orders in the cart
	public double getTotal(){
			return total;
	}
	
	//Private method to return the discounted amount for use in calculating a discounted total
	private double discountAmount(){
		return Math.round((total*0.1)*100.0)/100.0;
	}
	
	
	//Returns a receipt including information on each item and totals
	public String toString(){
		int itemNumber = 1;
		String str="";
		while(itemNumber<=cart.size()){
			str=str+"Item "+itemNumber+":\n  "+cart.get(itemNumber-1).toString();
			itemNumber++;
			
		}
		if(discount){
			str=str+String.format("%8s: $ %.2f", "Subtotal", getTotal())+
				String.format("\n%8s: $ %.2f", "Discount", discountAmount())+
				String.format("\n%8s: $ %.2f\n", "Total", getTotal()-discountAmount());
		}
		else{
		str=str+String.format("Total: $ %.2f\n", getTotal());
		}
		
		return str;
	}
	
	//Tests for equality between this and another shopping cart
	public boolean equals(Object obj){
		if(!(obj instanceof ShoppingCart)){
			return false;
		}
		else{
			ShoppingCart other = (ShoppingCart) obj;
			
			return(this.total==other.total && this.discount == other.discount && (this.cart.containsAll(other.cart) && other.cart.containsAll(this.cart)));
		}
	}
}