
//this is the strategy interface. 
public interface Strategy {

	public void execute(double distance) throws InvalidInstructionException;

	public void setAvatar(Avatar avatar);

	public void addBehaviour(String instruction, Behaviour behaviour);

	public boolean checkForBehaviour(String instruction);
}
