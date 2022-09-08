package CodeForMemento;

// Originator
public class Editor {
	String text;
	int cursorX;
	int cursorY;
	int fs;
	String ff;
	
	void write() {
		//
	}
	
	void delete() {
		//
	}
	
	EditorMemento getSnapshot() {
		return new EditorMemento(text, cursorX, cursorY, fs, ff);
	}
	
	void restore(EditorMemento m) {
		this.text = m.getText();
		this.cursorX = m.getCursorX();
		this.cursorY = m.getCursorY();
		this.fs = m.getFontSize();
		this.ff = m.getFontamily();
	}
	
	void print() {
		System.out.println("--------------------------");
		System.out.println(text);
		System.out.println(cursorX);
		System.out.println(cursorY);
		System.out.println(fs);
		System.out.println(ff);
		System.out.println("--------------------------");
	}
}
