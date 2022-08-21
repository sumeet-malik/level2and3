package CodeForCommand.Solution;

public class StereoIncVolumeCommand extends Command {
	Stereo stereo;
	public StereoIncVolumeCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	
	void execute() {
		stereo.incVolume(1);
	}
	
	void undo() {
		stereo.incVolume(-1);
	}
}
