//this class is designed to store X and Y coordinates of an avatar position
public class Position {

	//declare variables to store the X and Y positions
	protected int positionX;
	protected int positionY;

	//Constructor sued to set x and y
	public Position(int x, int y){
		setPositionX(x);
		setPositionY(y);
	}

	//create the getters and setters for the variables
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

}
