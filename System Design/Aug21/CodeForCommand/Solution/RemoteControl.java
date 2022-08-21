package CodeForCommand.Solution;

public class RemoteControl {
	Command b1Command;
	Command b2Command;
	Command b3Command;
	Command b4Command;
	
	void btn1Click() {
		if(b1Command == null) {
			System.out.println("No functionality");
			return;
		}
		b1Command.execute();
	}
	
	void btn2Click() {
		if(b2Command == null) {
			System.out.println("No functionality");
			return;
		}
		b2Command.execute();
	}
	
	void btn3Click() {
		if(b3Command == null) {
			System.out.println("No functionality");
			return;
		}
		b3Command.execute();
	}
	
	void btn4Click() {
		if(b4Command == null) {
			System.out.println("No functionality");
			return;
		}
		b4Command.execute();
	}
}
