//This is the superclass
//it contains all the methods and variables and avatar class needs

public abstract class Avatar {

	//declare class variables 
	protected String name;
	protected Strategy strategy;
	protected Grid grid;


	//getter and setter methods

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
		strategy.setAvatar(this);
	}

	public void setGrid(Grid grid){
		this.grid=grid;
	}

	public String getName() {
		return name;
	}


	//a move method is used to call on other methods from the grid class to generate a new position, 
	//check if that position is free/
	//update the HashMap and array for the new position
	//calculate the distance and pass it into the strategy method.
	public void move(Grid boardGrid) throws InvalidInstructionException{
		setGrid(boardGrid);
		Position newPos = grid.getRandXY();
		grid.checkSpace(this, newPos);

		if(grid.isEmpty()){
			Position oldPos=grid.getAvatarPosition(this);
			grid.calculateDistance(oldPos, newPos);
			double distance = grid.getDistance();

			//add new position to HashMap 
			//add new position to array
			int oldx,oldy,newx,newy;
			oldx=oldPos.getPositionX();
			oldy= oldPos.getPositionY();
			newx= newPos.getPositionX();
			newy= newPos.getPositionY();

			grid.setBoardposition(oldx, oldy, null);
			grid.setBoardposition(newx, newy, this);
			grid.upDateplayers(this, newPos);

			System.out.println(getName()+" is moving to a new position: X: "+newPos.getPositionX()+" Y: "+newPos.getPositionY());
			System.out.println("The distance to the new postion is: "+distance);


			this.strategy.execute(distance);

		}else{
			System.out.println("Position: X: "+newPos.getPositionX()+" Y: "+newPos.getPositionY()+" is already taken, "+getName()+" must wait for next turn to move. \n ");
		}

	}



}
