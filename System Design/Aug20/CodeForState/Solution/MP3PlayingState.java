package CodeForState.Solution;

public class MP3PlayingState extends AudioPlayerState {

	@Override
	public void pressPlay(AudioPlayer pl) {
		System.out.println("Paused mp3");
		pl.state = new MP3PausedState();
	}

	@Override
	public void pressChangeSource(AudioPlayer pl) {
		System.out.println("Setting source to radio");
		pl.state = new RadioState();
	}
	
}
