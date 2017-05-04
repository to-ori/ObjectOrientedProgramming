package shopping;


public class ShoppingCartTest {


	public static void main(String[] args) {

		//create new customer and cart 
		Customer customer = new Customer("Paula", "paula@gmail.com");
		ShoppingCart cart = new ShoppingCart(customer);

		//set the address's
		customer.setCustomerBillAddress("apt 2, Sea Road, Galway");
		customer.setCustomerDeliveryAdd("Apt 4, Mannor House, Lake road, Kerry ");

		//print the customer details
		System.out.println(customer.toString());

		//create new variables
		int cost1 = 15;
		int cost2 = 30;
		int cost3 = 10;
		int cost4 = 20;


		//create new item objects and use setCost method to set their costs
		Item hat = new Item(12345666L, "Hat");
		hat.setCost(cost1);
		Item dress = new Item(123453456L, "Dress");
		dress.setCost(cost2);
		Item top = new Item(33334566L, "Top");
		top.setCost(cost3);
		Item jeans = new Item(33334566L, "Jeans");
		jeans.setCost(cost4);

		//dummy item not to be added to cart, used to test deletion of items not in cart
		Item dog = new Item(12343966L, "dog");

		//add the items into the cart
		cart.addItem(hat);
		cart.addItem(dress);
		cart.addItem(top);
		cart.addItem(jeans);

		//call the get total method and set variable total the int returned by the method
		int total= cart.getTotal();

		//actual is the cost we expect the total to return
		int actual = cost1 + cost2 + cost3+ cost4;

		//this if else loop test to see if the getTotal method works correctly
		if(total == actual){
			System.out.println("getTotal is correct");
		}else {
			System.out.println("getTotal is wrong");
			System.out.println("Ecpected: "+ actual);
			System.out.println("Returned: "+ total);
		}

		//call delete method on a item we know is not in the array		 
		cart.deleteItem(dog);

		//call the delete method on and item we know is in the array
		cart.deleteItem(dress);

		//call the finalize method
		cart.finalises();

		//call the verifyPayment method
		cart.payment.verifyPayment();
	}

}
