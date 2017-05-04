package music;

public class WMAPlugin implements Plugin{

	   @Override
	   public void play(AudioFile audio) {
	      System.out.println("Playing wma file: "+ audio.getFileName());		
	   }
	}
