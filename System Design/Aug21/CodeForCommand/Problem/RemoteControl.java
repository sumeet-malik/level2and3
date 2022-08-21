package CodeForCommand.Problem;

public class RemoteControl {
	Light light = new Light();
	
	void btn1Click() {
		light.on();
	}
	
	void btn2Click() {
		light.off();
	}
	
	void btn3Click() {
		System.out.println("No functionality");
	}
	
	void btn4Click() {
		System.out.println("No functionality");
	}
}
