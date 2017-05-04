package music;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VLCPlayerTest {

	//class variables are created
	PluginAdapter adpt;
	VLCPlayer player;

	//before tag insures the details in the method are used as the set up for each test. 
	@Before
	public void setUp() throws Exception {

		adpt = new PluginAdapter();
		player = new VLCPlayer();

		adpt.register("ogg", new OGGPlugin());
		adpt.register("mp3", new MP3Plugin());
		adpt.register("wma", new WMAPlugin());
	}

	//this test tests to see if you can add a new plugin and file type key to the hashmap 
	@Test
	public void AddPlugintest() {

		/*each assertTrue tests to see is the string/file type passed in the containsKey method
		 * is in the HashMap, if it is there is it returns true.
		 */
		assertTrue(adpt.plugInMap.containsKey("ogg"));
		assertTrue(adpt.plugInMap.containsKey("mp3"));
		assertTrue(adpt.plugInMap.containsKey("wma"));
	}



	//this test will check to see that the play method is called correctly and runs.
	@Test 
	public void PlayListedFileType(){
		/*A boolean variable is created and set to true. This is what we expect the play state
		 * to be when the oggFile is "Played" as it is a supported file type.
		 */
		boolean ExpectedplayState = true;

		//new audioFile created
		AudioFile oggFile = new AudioFile("ogg", "C://Music/Amator_Silenti.ogg");

		//setPluginAdapater called
		player.setPluginAdapater(adpt);

		//play method called 
		try{
			player.play(oggFile);
		}catch(UnSupportedAudioFormatException e){
			System.out.println(e.getMessage());
		}

		//resultingPlaystate will be true if the file type was recognized and had a associated plugin
		boolean  resultingPlayState=player.getPlayState();
		//stop method called
		player.stop();


		assertEquals(ExpectedplayState, resultingPlayState);	
	}




	//this test will check to insure a unsupported file type is not played.
	// it is the same as above but a unsupported audio file is created and "Played"
	// the expectedplaystate is false as it should not be played
	@Test 
	public void PlaynotRegFileTypeTest(){
		boolean ExpectedplayState = false;

		AudioFile kmhFile = new AudioFile("kmh", "C://Music/Amator_Silenti.ogg");
		player.setPluginAdapater(adpt);

		try{
			player.play(kmhFile);
		}catch(UnSupportedAudioFormatException e){
			System.out.println(e.getMessage());
		}
		boolean  resultingPlayState=player.getPlayState();
		//player.stop();

		assertEquals(ExpectedplayState, resultingPlayState);	
	}



	//this test checks to see if the correct exception is thrown when a unsupported file type is "Played".
	@Test 
	public void CorrectExceptionTest()  throws UnSupportedAudioFormatException{

		AudioFile fooFile = new AudioFile("foo", "C://Music/Amator_Silenti.ogg");
		player.setPluginAdapater(adpt);

		try{
			player.play(fooFile);
			fail("not working");
		}catch(UnSupportedAudioFormatException e){
			assertTrue(true);
		}

	}
}
