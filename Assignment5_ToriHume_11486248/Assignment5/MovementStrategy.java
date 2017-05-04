import java.util.HashMap;

//this class implements the strategy class and over rides the methods declared there. 
public class MovementStrategy implements Strategy{

	//class variables
	private Avatar avatar;
	private HashMap<String, Behaviour> behaviours = new HashMap<String, Behaviour>();


	//overridden execute method. this chooses a instruction based on the distance and
	//calls the move method assigned to the behavior associated with the instruction. 
	//these instruction, behavior sets are stored in the behaviors HashMap
	//if the instruction does not match a behavior and InvalidInstructionException is thrown
	@Override
	public void  execute(double distance) throws InvalidInstructionException {
		String instruction;
		if(distance < 5){
			instruction = "walk";
		}
		else if(checkForBehaviour("fly")){
			instruction = "fly";
		} else
		{
			instruction = "teleport";
		}

		instruction = instruction.toLowerCase();
		if(behaviours.containsKey(instruction)){
			behaviours.get(instruction).move();
		}

		else{
			throw new InvalidInstructionException(instruction + " is not a valid move for a player of type "+ avatar.getClass().getSimpleName()+" to make");
		}
	}

	//sets the avatar variable
	@Override
	public void setAvatar(Avatar avatar) {
		this.avatar= avatar;

	}

	//adds a behaviour to the hashMap
	@Override
	public void addBehaviour(String instruction, Behaviour behaviour) {
		behaviours.put(instruction.toLowerCase(), behaviour);

	}

	//checks to see if a behavior is stored in a has map already
	public boolean checkForBehaviour(String instruction)
	{
		return behaviours.containsKey(instruction);
	}





}
