package CodeForCommand.Solution;

public class StereoOffCommand extends Command {
	Stereo stereo;
	public StereoOffCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	
	void execute() {
		stereo.off();
	}
	
	void undo() {
		stereo.on();
	}
}
