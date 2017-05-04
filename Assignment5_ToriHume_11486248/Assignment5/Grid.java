import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

//this class contains all the information about the grid. 
//the grid is the games board as such
//it stores all the players and their positions and calculates 
//the distance and checks if spaces are taken already and 
//creates new positions for the players
public class Grid {

	//declare new variables
	private double distance;
	private Boolean empty;
	private int x;
	private Avatar[][] board;
	Map<Avatar, Position> players;
	Random random;

	//constructor create a 2D array off size x*x
	//and a HashMap to store the avatars and their positions
	public Grid(int x){
		this.x=x;
		empty=true;
		board= new Avatar[x][x];
		players = new HashMap<Avatar, Position>();
	}

	//this method updates the position of a player to the new position within the HashMap
	public void upDateplayers(Avatar avatar, Position pos){
		players.put(avatar, pos);
	}

	//getter and setter for boolean value empty, this is used to represent whether a position is full or free
	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(Boolean empty) {
		this.empty = empty;
	}


	//this method checks to see if a method is empty or taken. It changes the value of empty depending
	public void checkSpace(Avatar avatar,Position position){
		int posX = position.getPositionX();
		int posY = position.getPositionY();
		Set<Avatar> keySet= players.keySet();
		for(Avatar key: keySet){

			int X=players.get(key).getPositionX();
			int Y=players.get(key).getPositionY();

			if(X==posX && Y==posY){
				setEmpty(false);
				return;
			} else{
				setEmpty(true);
			}

		}
		if(!isEmpty()){
			System.out.println("Can not move to "+posX+","+posY+". The space is currently taken.");
		}

	}



	//this method is used to add new players to the board an the HashMap.
	//it calls on the checkSpace method to insure the space is free before adding a player to it.
	//if the space is taken it creates a new position to add the player to and trys again
	public void addPlayer(Avatar avatar, Position pos){
		checkSpace(avatar,pos);
		int i = pos.getPositionX();
		int j= pos.getPositionY(); 
		if(isEmpty()){

			players.put(avatar, pos);
			getBoard()[i][j]=avatar;
			System.out.println(avatar.getName()+" added to game board at position: "+i+","+j+".\n");

		}
		else {
			System.out.println(avatar.getName()+" could not be added to "+i+","+j+". The space is currently taken.\nNew position for "+avatar.getName()+" being calculated\n");
			Position newpos = getRandXY();
			addPlayer(avatar, newpos);
		}
	}

	//this is used to assess the array board
	public Avatar[][] getBoard() {

		return board;
	}

	//this method calculate the distance between the new and old positions.
	//It is assumed that the avatar always moves "as the crow flys"
	public void calculateDistance(Position oldPos, Position newPos ) {
		int newX= newPos.getPositionX();
		int newY= newPos.getPositionY();
		int oldX = oldPos.getPositionX();
		int oldY = oldPos.getPositionY();
		int diffX=(oldX-newX);
		int diffY=(oldY-newY);

		//the distance is calculated using pythagorean theorem.
		//math.round is used to round the answer to the nearest int.
		this.setDistance(Math.round(Math.sqrt((diffX*diffX)+(diffY*diffY))));

	}

	//ths method is used to generate new positions for the player to move to
	public Position getRandXY(){
		random = new Random();
		int numX=random.nextInt(x);
		int numY=random.nextInt(x);
		Position position = new Position(numX, numY);

		return position;
	}

	//this method is used to get the current position stored in the 
	//HashMap for the avatar/player entered
	public Position getAvatarPosition(Avatar avatar){
		return players.get(avatar);
	} 

	//getter and setter for the variable distance
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}


	//setter method for board
	public void setBoardposition(int x,int y, Avatar avatar) {
		getBoard()[x][y] = avatar;
	}


}
