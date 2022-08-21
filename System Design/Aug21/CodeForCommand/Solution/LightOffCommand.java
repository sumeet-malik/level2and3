package CodeForCommand.Solution;

public class LightOffCommand extends Command {
	Light light;
	public LightOffCommand(Light light) {
		this.light = light;
	}
	
	void execute() {
		light.off();
	}
	
	void undo() {
		light.on();
	}
}
