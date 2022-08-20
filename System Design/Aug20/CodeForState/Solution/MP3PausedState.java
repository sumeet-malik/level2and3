package CodeForState.Solution;

public class MP3PausedState extends AudioPlayerState {
	@Override
	public void pressPlay(AudioPlayer pl) {
		System.out.println("Playing mp3");
		pl.state = new MP3PlayingState();
	}

	@Override
	public void pressChangeSource(AudioPlayer pl) {
		System.out.println("Setting source to radio");
		pl.state = new RadioState();
	}
}
