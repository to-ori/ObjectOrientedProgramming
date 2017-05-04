package shopping;

//this class contains all the customers detail in one place
public class Customer {


	//class variables
	private String name;
	private String emailAddress;
	private String billingAddress;
	private String deliveryAddress;


	//constructor
	public Customer(){
		this.setName("Null");
		this.setEmailAddress("Null");
	}

	//overloaded constructor
	public Customer(String name1, String emailAdd){
		this.setName(name1);
		this.setEmailAddress(emailAdd);
	}


	//getters and setters
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public void setCustomerBillAddress(String billAdd){
		billingAddress=billAdd;
	}

	public void setCustomerDeliveryAdd(String cusAdd){
		deliveryAddress=cusAdd;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	//Overridden toString
	@Override
	public String toString() {
		return "Customer: \nname=\t" + name + ",\n emailAddress=\t" + emailAddress + ",\n  billingAddress=\t" + billingAddress + ",\n deliveryAddress=\t" + deliveryAddress ;
	}

}
