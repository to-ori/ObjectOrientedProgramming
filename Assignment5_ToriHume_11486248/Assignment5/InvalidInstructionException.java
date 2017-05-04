
//this is an exception that will be thrown when a invalid instruction is called.
public class InvalidInstructionException extends Exception {


	private static final long serialVersionUID = 1L;

	public InvalidInstructionException(String errMessage){
		super(errMessage);
	}

}
