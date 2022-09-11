package CodeForBridge.solution;

public abstract class Message {
	String body;
	String to;
	String from;
	String title;
	MessageSender sender;
	
	Message(String body, String to, String from, String title, MessageSender sender){
		this.body = body;
		this.to = to;
		this.from = from;
		this.title = title;
		this.sender = sender;
	}
	
	void send() {
		sender.send(from, to, body, title);
	}
}
