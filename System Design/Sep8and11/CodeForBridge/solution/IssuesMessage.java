package CodeForBridge.solution;

import java.util.ArrayList;

public class IssuesMessage extends Message {
	ArrayList<String> issues;
	
	IssuesMessage(String body, String to, String from, String title, ArrayList<String> issues, MessageSender sender){
		super(body, to, from, title, sender);
		this.issues = issues;
		
		body += "Following issues - ";
		for(String issue: issues) {
			body += issue;
		}
	}
	
	
}
