package shopping;

//This class creates and "sends" email's. 
//It gets the details it needs (email address and order info from the order and customer class's
//it has a send email method the prints a "email" to the command window. 
//the contents of the email depends on the message its passed when its called.. 
//
public class Email {

	//class variables
	private Customer c;
	private Order order;



	//overloaded constructor
	public Email(Order order) {
		this.order=order;
		c=order.getCustomer();

	}

	//method passes a success message to sendEmail when it calls it. The method its self is called when payment is verified
	public void paymentSucess() {
		System.out.println("Payment was Sucessfull! An email with your order details will be sent shortly.\n\n");
		String sucessMessage=("Payment was sucessfull. Your order has been placed, please see below for your order details."); 
		sendEmail(sucessMessage);
	}

	//method passes a failure message to sendEmail when it calls it. The method its self is called when payment fails
	public void paymentFail() {
		System.out.println("Payment was unsucessfull. An email will be sent to the customer shortly to notify them.");
		String failureMessage=("In relation to the order shown below, the payment was unsucessfull. The order has be canclled"); 
		sendEmail(failureMessage);

	}

	//this method prints the "sent" email to screen.
	public void sendEmail(String emailcontent){
		System.out.println("\nContent of email sent to customer:");
		System.out.println("Send to: "+c.getEmailAddress());
		System.out.println("Dear "+c.getName()+", \n");
		System.out.println("\t"+emailcontent);
		order.orderSummary();

	}




}
