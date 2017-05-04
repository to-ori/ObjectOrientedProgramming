package music;

import java.util.HashMap;
import java.util.Map;

public class PluginAdapter implements Plugin {

	private Plugin player;

	//a HashMap was created called plugInMap to store the file type as a string and the associated plugin. 
	Map<String, Plugin> plugInMap = new HashMap<String, Plugin>();

	//the register method allows future extra plugins to be developed and added to the HashMap. 

	public void register(String key, Plugin player){
		plugInMap.put(key, player);
	}


	@Override
	public void play(AudioFile audio) throws UnSupportedAudioFormatException {

		//the variable key is set equal to the file type of the audio file passed into the play() method. 
		//is gotten by calling the getAudioType method of the audioFile  

		String key = audio.getAudioType();

		/* a if condition check if the file time is listed in the hashMap with a associated value
		 *( in our case the value is the associated plugin)
		 *if the key is in the hashMap the player is set to the plug in associated with it. 
		 *(this is gotten through the .get() method)
		 *the associated play() method is then called.
		 *
		 * If the filetype is not listed in the hashMap or does not have an associated plugIn,
		 * the UnSupportedAudioFormatException is thrown.
		 */

		if(plugInMap.containsKey(key)){

			this.player= plugInMap.get(key);
			this.player.play(audio);
		}else{
			throw new UnSupportedAudioFormatException("Unsuported format: " + audio.getAudioType());	
		}
	}
}
