package CodeForMemento;

import java.util.Stack;

public class CareTaker {
	private Stack<EditorMemento> his = new Stack<>();
	
	public void save(EditorMemento m) {
		his.push(m);
	}
	
	public EditorMemento undo() {
		return his.pop();
	}
}
