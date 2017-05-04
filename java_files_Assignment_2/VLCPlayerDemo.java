package music;


public class VLCPlayerDemo {

	public static void main (String[] args ){

		//create instance of the VLCPlayer 

		VLCPlayer player = new VLCPlayer();

		//create instance of pluginadpter

		PluginAdapter adpt = new PluginAdapter();

		//Calls the setPluginAdapater method to set the player to adpt plugin
		player.setPluginAdapater(adpt);

		//create an new instance of audioFile called oggFile and pass it values
		AudioFile oggFile = new AudioFile("ogg", "C://Music/Amator_Silenti.ogg");

		//call register method of adpt to add new files and plugins to HashMap
		adpt.register("ogg", new OGGPlugin());
		adpt.register("mp3", new MP3Plugin());
		adpt.register("wma", new WMAPlugin());


		try{
			player.play(oggFile);
		}catch(UnSupportedAudioFormatException e){
			System.out.println(e.getMessage());
		}

		System.out.println("player playing: " + player.getPlayState()); 
		player.stop();

	}


}
