package shopping;

import java.util.ArrayList;

//this class contains all the order information.
//in this system it is passed its information by the ShoppingCart
//it autogenerates a orderNumber and has a method to print the order details to the screen
public class Order {

	//class variables
	private int orderID= 0;
	private static int ordercounter = 0;
	private ArrayList<Item> list;
	private Customer customer;


	//constructor
	public Order() {
		ordercounter++;
		this.orderID= ordercounter;
		this.list = new ArrayList<Item>(5);

	}

	//over loaded constructor
	public Order(Customer customer1) {
		ordercounter++;
		this.orderID= ordercounter;
		this.list = new ArrayList<Item>(5);
		this.setCustomer(customer1);
	}


	//returns the customer associated with this method, 
	//in this system a customer may or may not have and order BUT a order must have a customer 
	public Customer getCustomer() {
		return customer;
	}


	//getters and setters
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public int getOrderID() {
		return orderID;
	}



	public String setOrderID(int orderID) {
		return "You can not make changes to the order ID, this is pre-set";
	}


	public void addItem(Item item1) {
		this.list.add(item1);

	}

	//like the method is cart. this method calculates the total cost of the order
	public int getTotal() {
		int total = 0;
		for(Item it: list){
			total = total + it.getCost();
		}
		return total;
	}

	//this method prints a summary of the order to the screen 
	public void orderSummary(){
		System.out.println("\n\t\tORDER ID: "+getOrderID() +"\n\n\t\tORDER SUMMARY:\n");
		for(Item i: list){
			System.out.println("\t\t"+i.toString());
		}
		System.out.println("\t\tTOTAL COST: "+getTotal());
	}






}
