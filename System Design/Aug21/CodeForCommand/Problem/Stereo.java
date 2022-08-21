package CodeForCommand.Problem;

public class Stereo {
	private int volume = 5;
	
	void on() {
		System.out.println("Turn on the stereo");
	}
	
	void off() {
		System.out.println("Turn off the stereo");
	}
	
	void incVolume(int delta) {
		volume += delta;
		System.out.println("Volume set to " + volume);
	}
	
	void decVolumne(int delta) {
		volume -= delta;
		System.out.println("Volume set to " + volume);
	}
}
