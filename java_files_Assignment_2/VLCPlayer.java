package music;
//This is a Concrete Music Player
public class VLCPlayer{

	private Plugin adapter; 
	//play state set to false 
	private boolean playState = false;

	public void play(AudioFile audio) throws UnSupportedAudioFormatException{		
		//play method of the adapter is called and passed a audio file
		this.adapter.play(audio);
		this.playState = true;
	}  

	public boolean getPlayState(){
		return playState;
	}

	public void stop(){
		//play state set to false to represent to player being stopped. 
		this.playState =false;
	}

	//a setPluginAdapter was created to allow the private variable adapter to be set.
	public void setPluginAdapater(Plugin pAdapter) {
		this.adapter= pAdapter;

	}	
}