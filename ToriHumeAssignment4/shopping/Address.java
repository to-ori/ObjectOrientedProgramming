package shopping;

//the Address class contains billing and delivery address's.
//this class is passed the customer class and it sets the billing and deliver address as those in the customer class
public class Address {


	//class variables
	private String billingAddress;
	private String deliveryAddress;
	Customer c;

	//constructor
	public Address(){
		this.billingAddress="Null";
		this.deliveryAddress= "Null";
	}


	//overloaded constructor
	public Address(Customer c){
		this.c=c;
		this.billingAddress=c.getBillingAddress();
		this.deliveryAddress=c.getDeliveryAddress();
	}

	//getters and setters 
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String address) {
		billingAddress = address;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String address) {
		deliveryAddress = address;
	}

}
