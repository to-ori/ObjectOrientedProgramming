package music;

public class OGGPlugin implements Plugin{

	private static String format = "ogg";

	@Override
	public void play(AudioFile audio) {
		if(audio.getAudioType().equals(format)){
			System.out.println("Playing ogg file: "+ audio.getFileName());

		}
	}
}