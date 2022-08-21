package CodeForCommand.Solution;

public class StereoOnCommand extends Command {
	Stereo stereo;
	public StereoOnCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	
	void execute() {
		stereo.on();
	}
	
	void undo() {
		stereo.off();
	}
}
