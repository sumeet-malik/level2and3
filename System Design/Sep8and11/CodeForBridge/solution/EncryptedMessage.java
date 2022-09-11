package CodeForBridge.solution;

public class EncryptedMessage extends Message {
	String key;
	
	EncryptedMessage(String body, String to, String from, String title, String key, MessageSender sender){
		super(body, to, from, title, sender);
		this.key = key;
		this.body = key + body;
	}
	
	
}
