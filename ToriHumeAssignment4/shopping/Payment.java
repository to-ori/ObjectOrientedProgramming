package shopping;

import java.util.regex.Pattern;

//this class contains all the payment details.
//it tests the details and verifies the payment.
// it then create a instance of email and calls the appropriate method from that class i.e. success or failure

public class Payment {

	//class variables
	private Order order;
	private String cardNumber;
	private String nameonCard;
	private String CVV;
	Email email;
	private Boolean cnumValid, cvvValid;

	//Constructor 
	public Payment(Order order1) {
		this.order= new Order();
		this.order=order1;
		this.cardNumber= "null";
		this.nameonCard="null";
		this.CVV="null";

	}

	//getters and setters
	public Boolean getCvvValid() {
		return cvvValid;
	}


	public void setCvvValid(Boolean cvvValid) {
		this.cvvValid = cvvValid;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getNameonCard() {
		return nameonCard;
	}


	public void setNameonCard(String NameonCard) {
		nameonCard = NameonCard;
	}


	public String getCVV() {
		return CVV;
	}


	public void setCVV(String cVV) {
		CVV = cVV;
	}

	public Boolean getCnumValid() {
		return cnumValid;
	}


	public void setCnumValid(Boolean cnumValid) {
		this.cnumValid = cnumValid;
	}


	//this method is used to verify the card details. It checks the card Number and CVV number.
	public void verifyPayment(){

		//payment is verified by check that the card number is 16 digits long 
		//and only contains numbers and that the CVV number is 3 digits long 
		//and only contains numbers


		//check CardNumber
		if(cardNumber.length()==16 && Pattern.matches("[a-zA-Z]+", cardNumber) == false ){
			setCnumValid(true);
		}else {
			setCnumValid(false);	
		}


		//Check CVV number 
		if(CVV.length()==3 && Pattern.matches("[a-zA-Z]+", cardNumber) == false ){
			cvvValid=true;
		}else {
			cvvValid=false;	
		}

		//create an email object
		email= new Email(order);

		//call correct method based on whether the payment is successful or not
		if(cvvValid && getCnumValid() ){
			email.paymentSucess();
		}else{
			email.paymentFail();
		}
	}


}
