/******************************************************************************
 * Bellevue Class: CS 211
 *           Term: Spring 2013
 *     Instructor: Robert Main
 *     
 * Textbook: Building Java Programs, A Back to Basics Approach, 2nd Edition
 *  Authors: Stuart Reges and Marty Stepp
 *  
 * Instructor Project Solution
 * 
 *             Chapter: 10 
 * Programming Project: 1
 *                Page: 677
 *
 * Assigned Project: 4
 *
 * Class Name: ShoppingOrderClient
 * File Name:  ShoppingOrderClient.java
 *
 * Revision     Date                        Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     04/21/2013  Initial Release
 *   1.1     04/25/2013  Bug fix: Customer #5B - Set cart4, s/b cart5
 *
 * File Description
 * ----------------
 * This file defines the the class "ShoppingOrderClient", which includes
 * all methods, variables, and constant values. Specifically, this class 
 * contains the Console application entry method, main(), which is a static
 * method, since no object of the class type is ever instantiated.
 * 
 * Class Methods
 * -------------
 *    Name                                    Description
 * ----------  ----------------------------------------------------------------
 * main        The OS transfers control to this method upon program execution
 *
 ******************************************************************************
 */
public class ShoppingOrderClient
{
	/**************************************************************************
	 * Method: main(String[])
	 * 
	 * Program Description
	 * -------------------
	 * This client program tests the features of the class implementations
	 * for CS-211 Project #4, textbook Programming Project #1, page 677.
	 * 
	 * RETurn
	 *  Type
	 * ------
	 * void
	 *
	 * ------------------------------- Arguments ------------------------------
	 *   Type        Name                         Description
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
    	// Create store items for the CS-211 Gift Catalog
    	Item item1 = new Item("silly putty", 3.95, 10, 19.99);
    	Item item2 = new Item("silly string", 3.50, 10, 14.95);
    	Item item3 = new Item("bottle o bubbles", 0.99);
    	Item item4 = new Item("Nintendo Wii system", 389.99);
    	Item item5 = new Item("Mario Computer Science Party 2 (Wii)", 49.99);
    	Item item6 = new Item("Don Knuth Code Jam Challenge (Wii)", 49.99);
    	Item item7 = new Item("Computer Science pen", 3.40);
    	Item item8 = new Item("Rubik's cube", 9.10);
    	Item item9 = new Item("Computer Science Barbie", 19.99);
    	Item item10 = new Item("'Java Rules!' button", 0.99, 10, 5.0);
    	Item item11 = new Item("'Java Rules!' bumper sticker", 0.99, 20, 8.95);
    	
    	// Now create the CS-211 Gift Catalog
        Catalog catalogList = new Catalog("CS-211 Gift Catalog");
        catalogList.add(item1);
        catalogList.add(item2);
        catalogList.add(item3);
        catalogList.add(item4);
        catalogList.add(item5);
        catalogList.add(item6);
        catalogList.add(item7);
        catalogList.add(item8);
        catalogList.add(item9);
        catalogList.add(item10);
        catalogList.add(item11);
        
        // Then create some orders to test the various 
        ItemOrder order1A = new ItemOrder(item1, 10);
        ItemOrder order1B = new ItemOrder(item1, 9);
        ItemOrder order2 = new ItemOrder(item3, 6);
        ItemOrder order3A = new ItemOrder(item5, 1);
        ItemOrder order3B = new ItemOrder(item5, 5);
        ItemOrder order3C = new ItemOrder(item5, 0);
        ItemOrder order4 = new ItemOrder(item7, 3);
        ItemOrder order5 = new ItemOrder(item10, 12);
        ItemOrder order6A = new ItemOrder(item11, 12);
        ItemOrder order6B = new ItemOrder(item11, 20);
        ItemOrder order7 = new ItemOrder(item2, 20);
        ItemOrder order8 = new ItemOrder(item9, 0);
        
        // Next, create carts for five different customers.
        ShoppingCart cart1 = new ShoppingCart();
        cart1.add(order1A);
        cart1.add(order3A);
        cart1.add(order5);
        cart1.add(order2);
        
        ShoppingCart cart2 = new ShoppingCart();
        cart2.add(order4);
        cart2.add(order6B);
        cart2.add(order3B);
        cart2.add(order3C);
        cart2.add(order2);
        
        ShoppingCart cart3 = new ShoppingCart();
        cart3.add(order2);
        cart3.add(order7);
        
        ShoppingCart cart4 = new ShoppingCart();
        cart4.add(order8);
        
        ShoppingCart cart5 = new ShoppingCart();
        cart5.add(order6A);
        cart5.add(order3A);
        cart5.add(order3B);
        cart5.add(order1B);
        
        ShoppingCart[] carts = new ShoppingCart[]
        					   { cart1, cart2, cart3, cart4, cart5 };
        
        
        // Now display the results
        // First, display the CS-211 Gift Catalog
        System.out.println(catalogList);
        
        // Now display each customer's cart
        int customerNmbr = 1;
        for (ShoppingCart cart : carts)
        {
        	System.out.println("\nCustomer # " + customerNmbr++ + 
        			" Shopping cart:\n" + cart);
        }
        
        // Finally, allow a discount for customer #5
        cart5.setDiscount(true);
    	System.out.println("\nCustomer #5B Shopping cart:\n" + cart5);

	}   // End method: main(String[])
	
}   // End class definition: ShoppingOrderClient
