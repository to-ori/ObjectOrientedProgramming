import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AvatarGameTest {

	//declaring the variables
	Grid grid;
	Avatar player1, player2, player3, player4, player5;
	MovementStrategy teleporsStrategy, flyersStrategy;

	@Before
	public void setUp() throws Exception {
		//creating the strategy variables
		teleporsStrategy = new MovementStrategy();
		flyersStrategy = new MovementStrategy();

		//add behaviors to the two instances of MovementStrategy
		teleporsStrategy.addBehaviour("walk", new Walk());
		teleporsStrategy.addBehaviour("teleport", new Teleport());

		flyersStrategy.addBehaviour("walk", new Walk());
		flyersStrategy.addBehaviour("fly", new Fly());

		//create the grid
		grid = new Grid(10);

		//create new players
		player1 = new TeleportingAvatar("Tori");
		player2 = new FlyingAvatar("Jade");
		player3 = new TeleportingAvatar("Tessa");
		player4 = new FlyingAvatar("Zeus");

		//player 5 will not be added to the came and was created to test that the HashMap only contains avataras we have 
		//added to the board
		player5 = new FlyingAvatar("Zeus2");

		//set strategies for players 1-4
		player1.setStrategy(teleporsStrategy);
		player2.setStrategy(teleporsStrategy);

		player3.setStrategy(flyersStrategy);
		player4.setStrategy(flyersStrategy);

		//add players 1-4 to the game through the addplayer method in the grid class
		grid.addPlayer(player1, new Position(0, 0));
		grid.addPlayer(player2, new Position(0, 1));
		grid.addPlayer(player3, new Position(5, 6));
		grid.addPlayer(player4, new Position(8, 2));
	}

	//this test shows players and added correctly and that the came only contains players we have added
	@Test
	public void AddPlayersTest() {
		assertFalse(grid.players.containsKey(player5));
		assertTrue(grid.players.containsKey(player2));
	}


	//the following two tests was used test the checkSpace method
	//the first for a space the already contains a avatar and 
	//the second for a space that does not already contain an avatar
	@Test
	public void CheckSpaceTest() {
		grid.checkSpace(player1, new Position(0, 0));

		assertFalse(grid.isEmpty());
	}

	@Test
	public void CheckSpacefreeTest() {
		grid.checkSpace(player1, new Position(9, 0));

		assertTrue(grid.isEmpty());
	}


	//this test checks that the distance calculated by the getDistance method in grid
	@Test
	public void distanceTest() {
		Position startPosition = new Position(0, 0);
		Position EndPosition = new Position(4, 4);
		grid.calculateDistance(startPosition, EndPosition);
		int actualDistance = (int) grid.getDistance();

		double expdouble = Math.round((Math.sqrt(32)));
		int expectedDistance = (int) expdouble;

		assertEquals(expectedDistance, actualDistance);
	}

	//checks that the right exceptions thrown
	@Test(expected = InvalidInstructionException.class)
	public void testException() throws InvalidInstructionException {

		flyersStrategy = new MovementStrategy();
		flyersStrategy.setAvatar(player1);
		flyersStrategy.execute(5);
	}
}
