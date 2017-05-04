//the main method if this class is used to test the avatar game that has been created
public class AvatarGame {

	public static void main(String[] args) throws InvalidInstructionException{

		//create a new grid
		Grid grid = new Grid(10);

		//create new palyers
		Avatar player1 = new TeleportingAvatar("Tori");
		Avatar player2 = new FlyingAvatar("Jade");
		Avatar player3 = new TeleportingAvatar("Tessa");
		Avatar player4 = new FlyingAvatar("Zeus") ;

		//add the players to the board to set positions
		grid.addPlayer(player1, new Position (0,0));
		grid.addPlayer(player2, new Position (0,0));
		grid.addPlayer(player3, new Position (5,6));
		grid.addPlayer(player4, new Position (8,2));


		//create new instances of movementStrategy
		//add behaviors to them
		Strategy fly = new MovementStrategy();
		fly.addBehaviour("walk", new Walk());
		fly.addBehaviour("fly", new Fly());
		Strategy teleport = new MovementStrategy();
		teleport.addBehaviour("walk", new Walk());
		teleport.addBehaviour("teleport", new Teleport());


		//add the strategies to the players
		player1.setStrategy(teleport);
		player3.setStrategy(teleport);
		player2.setStrategy(fly);
		player4.setStrategy(fly);

		//"play" the game for 20 rounds by calling the move method for each player each round, 
		//and have them move around the board (provided the generated space is available)
		for(int round=0; round<100; round++){
			player1.move(grid);
			player2.move(grid);
			player3.move(grid);
			player4.move(grid);
		}

	}
}
