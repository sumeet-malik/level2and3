package CodeForState.Solution;

public class AudioPlayer {
	AudioPlayerState state;
	
	public AudioPlayer() {
		this.state = new StandByState();
	}
	
	public void pressPlay() {
		this.state.pressPlay(this);
	}
	
	public void pressChangeSource() {
		this.state.pressChangeSource(this);
	}
}
