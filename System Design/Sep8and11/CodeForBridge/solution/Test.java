package CodeForBridge.solution;

public class Test {

	public static void main(String[] args) {
		MessageSender viaEmail = new EmailSender();
		Message msg = new EncryptedMessage("alksdjf", "alskd", "iiser", "laksdjf", "key", viaEmail);
		msg.send();

	}

}
