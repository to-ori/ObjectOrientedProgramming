package shopping;

import java.util.ArrayList;
import java.util.Scanner;

//this class contains all the information relating to the cart.
//in this system a shopping cart must have a customer

public class ShoppingCart {

	//contains an array of items
	//class variables, ad arrays
	ArrayList<Item> list;
	private Order order;
	Scanner input = new Scanner(System.in);
	private Customer customer;
	Payment payment;

	//overloaded constructor
	public ShoppingCart(Customer customer1) {
		//create a new array list and set customer variable equal to the customer entered into the system
		this.list = new ArrayList<Item>(5);
		this.customer= customer1;
	}


	//getters 
	public Customer getCustomer(){
		return customer;
	}

	//this method is used to add items to the cart array if items
	public void addItem(Item item1) {
		this.list.add(item1);
	}

	//this method removes item from the array. 
	//it uses the command window to get the user to confirm they want to delete an item before doing so.
	//it also checks the array to make sure the item passed to the method is in the array before it trys to remove it
	public void deleteItem(Item item) {

		if(list.contains(item)){

			int answer=0;

			do{
				System.out.println("\nAre you sure you would like to delete the item: " + item.getItemName()+ "\nTo confirm detetion enter 1, to cancle press 2");
				answer = input.nextInt();
			} while(answer<0 || answer>2);
			input.nextLine();


			if(answer == 1){

				this.list.remove(item);

				System.out.println("Item: "+item.getItemName()+" has been removed from your cart.");
			}
			else{
				System.out.println("Deletion of item: "+ item.getItemName() +" cancelled");
			}
		} else {
			System.out.println("Item: "+ item.getItemName() + " not found.");
		}

	}


	//this method calculates the total cost of the items in the cart
	public int getTotal() {
		int total = 0;
		for(Item it: list){
			total = total + it.getCost();
		}
		return total;
	}


	//this method uses the command window to display the details of whats in the cart persently
	//And asks the user if they want to place an order
	//if they say yes it calls the create order method 
	public void finalises() {

		System.out.println("\n\nYour cart currently contains: ");
		for(Item i: list){
			System.out.println(i.toString());
		}

		int orderanswer=0;
		do{
			System.out.println("Would you like to place this order? \nTo confirm order enter 1, to cancel press 2");
			orderanswer = input.nextInt();
		} while(orderanswer<0 || orderanswer>2);
		input.nextLine();

		if(orderanswer==1){

			createOrder(customer);

		}else{
			System.out.println("You order has not been placed. Please continue shopping");
		}

	}


	//the create order method creates an instance of order and adds the item in the cart to the order
	//it then gets the user to input their payment details

	private void createOrder(Customer cutomer) {
		this.order = new Order(customer);

		String cardno, name, cvv;


		for(Item i: list){
			this.order.addItem(i);
		}
		System.out.println("\n\nOrder has been created. Order ID: "+ order.getOrderID() +"\nIn order to continue you must enter your payment details");

		payment = new Payment(order);

		//Add name on card
		System.out.println("\nPlease enter the Name on the Card");
		name = input.nextLine();

		payment.setNameonCard(name);
		//Add card number
		System.out.println("\nPlease enter the card number");
		cardno = input.nextLine();
		payment.setCardNumber(cardno);

		//Add cvv number 
		System.out.println("\nPlease enter the CVV number. This is the 3 numbers found on the back of the card");
		cvv = input.nextLine();
		payment.setCVV(cvv);

		input.nextLine();
	}



}
