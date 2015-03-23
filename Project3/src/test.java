public class test{
	public static void main(String[] args){
		Item item1 = new Item("broccoli", 1.29);
		Item item2 = new Item("carrot", 0.55, 10, 5.00);
		
		System.out.println(item1.getBulkQuantity());
		System.out.println(item1.toString());
		System.out.println(item2.toString());
		
		ShoppingCart cart = new ShoppingCart();
		ShoppingCart cart2 = new ShoppingCart();
		ItemOrder a = new ItemOrder(item1, 10);
		ItemOrder b = new ItemOrder(item1, 5);
		ItemOrder c = new ItemOrder(item2, 10);
		
		
		cart.add(a);
		
		System.out.println(cart.getTotal());
		
		cart.add(b);
		
		System.out.println(cart.getTotal());
		
		cart.add(c);
		cart2.add(a);
		cart2.add(b);
		cart2.add(c);
		
		System.out.println(cart.equals(cart2));
		cart.setDiscount(true);
		System.out.println(cart);
	
	}
}