package CodeForCommand.Solution;

public class StereoDecVolumeCommand extends Command {
	Stereo stereo;
	public StereoDecVolumeCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	
	void execute() {
		stereo.decVolume(1);
	}
	
	void undo() {
		stereo.decVolume(-1);
	}
}
