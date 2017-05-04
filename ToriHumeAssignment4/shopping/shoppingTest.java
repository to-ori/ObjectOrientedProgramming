package shopping;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class shoppingTest {

	//class variables are created
	Customer customer;
	ShoppingCart cart;
	Payment p;
	Email e;
	int cost1, cost2, cost3 ,cost4;
	Item hat, dress, top, jeans;
	
	
	
	//before tag insures the details in the method are used as the set up for each test. 
	@Before
	public void setUp() throws Exception {
		
		customer = new Customer("Paula", "paula@gmail.com");
		cart = new ShoppingCart(customer);
		customer.setCustomerBillAddress("apt 2, Sea Road, Galway");
		customer.setCustomerDeliveryAdd("Apt 4, Mannor House, Lake road, Kerry ");
		
		cost1 = 15;
		cost2 = 30;
		cost3 = 10;
		cost4 = 20;
		
		hat = new Item(12345666L, "Hat");
		hat.setCost(cost1);
		dress= new Item(123453456L, "Dress");
		dress.setCost(cost2);
		top = new Item(33334566L, "Top");
		top.setCost(cost3);
		jeans = new Item(33334566L, "Jeans");
		jeans.setCost(cost4);
		
		cart.addItem(hat);
		cart.addItem(dress);
		cart.addItem(top);
		cart.addItem(jeans);
		
	}

	
	//test that the customer exists and contains the name, email and addresses entered.
	@Test
	public void SetUpTest() {
		
		//expected values
		String Expname = "Paula";
		String Expemail="paula@gmail.com";
		String ExpBadd= "apt 2, Sea Road, Galway";
		String ExpDadd= "Apt 4, Mannor House, Lake road, Kerry ";
		
		//values returned by program
		String Rname = customer.getName();
		String Remail=customer.getEmailAddress();
		String RBadd= customer.getBillingAddress();
		String RDadd=customer.getDeliveryAddress();
		
		assertEquals(Expname, Rname);
		assertEquals(Expemail, Remail);
		assertEquals(ExpBadd, RBadd);
		assertEquals(ExpDadd, RDadd);
		
	}
	
	//test to see that the items have been added to the cart array 
	@Test
	public void ContainItemstest() {

		assertTrue(cart.list.contains(hat));
		assertTrue(cart.list.contains(top));
		assertTrue(cart.list.contains(dress));
		assertTrue(cart.list.contains(jeans));		
		
	}
	
	//test to see that the items have been added to the cart array 
	@Test
	public void costTest() {
		
		//actual cost returned by method
		int total= cart.getTotal();
		 
		//expected cost
		 int actual = cost1 + cost2 + cost3+ cost4;
			
		assertEquals(actual, total );
		
	}
	
	//test to see if an item can be removed from the cart array 
	@Test
	public void removeItemstest() {
		//call method to delete item from cart, pass it the item you wish to delete
		cart.deleteItem(dress);
		
		//test to insure it has been removed.
		assertFalse(cart.list.contains(dress));
				
	}
	
	//test to see that verify method for cardNum works first for a number that should pass than a second text class is used for a cardnumber that shouldn't pass
		@Test
		public void CorrectCardNotest() {
			
			//note it doesn't matter what values are entered into the command line re card values as they are over ridden below for the test;
			cart.finalises();
			 cart.payment.setCardNumber("4319123412341234");
			 cart.payment.setCVV("123");
			 cart.payment.verifyPayment();
			
			Boolean cardverify = cart.payment.getCnumValid();
			
			//values returned by program
		
			
			assertTrue(cardverify);
		}
		
		//test to see that verify method for cardNum works first for a number that should pass than a second text class is used for a cardnumber that shouldn't pass
			@Test
			public void InvalidCardNotest() {
				
				//note it doesn't matter what values are entered into the command line re card values as they are over ridden below for the test;
				cart.finalises();
				 cart.payment.setCardNumber("43191234123");
				 cart.payment.setCVV("123");
				 cart.payment.verifyPayment();
				
				Boolean cardverify = cart.payment.getCnumValid();
				
				//values returned by program
			
				
				assertFalse(cardverify);
			}
			
			
			
}
