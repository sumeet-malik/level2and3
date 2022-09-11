package CodeForBridge.problem;

public abstract class Message {
	String from;
	String to;
	String title;
	String body;
	abstract void send();
}
