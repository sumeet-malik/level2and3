package CodeForCommand.Solution;

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
	
	void decVolume(int delta) {
		volume -= delta;
		System.out.println("Volume set to " + volume);
	}
}
