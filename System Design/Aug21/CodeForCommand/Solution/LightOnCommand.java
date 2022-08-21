package CodeForCommand.Solution;

public class LightOnCommand extends Command {
	Light light;
	public LightOnCommand(Light light) {
		this.light = light;
	}
	
	void execute() {
		light.on();
	}
	
	void undo() {
		light.off();
	}
}
