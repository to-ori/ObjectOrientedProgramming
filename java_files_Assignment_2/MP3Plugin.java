package music;

public class MP3Plugin implements Plugin {

	private static String format = "mp3";
	   
	@Override
	   public void play(AudioFile audio) {
		if(audio.getAudioType().equals(format)){
	      System.out.println("Playing mp3 file: "+ audio.getFileName());
	  
		}
	   }

}
