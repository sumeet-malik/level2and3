package CodeForState.Solution;

public class RadioState extends AudioPlayerState {
	@Override
	public void pressPlay(AudioPlayer pl) {
		System.out.println("Changing station");
	}

	@Override
	public void pressChangeSource(AudioPlayer pl) {
		System.out.println("Going to MP3");
		pl.state = new MP3PausedState();
	}
}
