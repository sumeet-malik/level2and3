package CodeForMemento;

import java.time.LocalDateTime;

public class EditorMemento {
	private String text;
	private int cursorX;
	private int cursorY;
	private int fs;
	private String ff;
	private LocalDateTime moment;
	
	public String getText() {
		return this.text;
	}
	
	public int getCursorX() {
		return this.cursorX;
	}
	
	public int getCursorY() {
		return this.cursorY;
	}
	
	public int getFontSize() {
		return this.fs;
	}
	
	public String getFontamily() {
		return this.ff;
	}
	
	EditorMemento(String text, int cursorX, int cursorY, int fs, String ff){
		this.text = text;
		this.cursorX = cursorX;
		this.cursorY = cursorY;
		this.fs = fs;
		this.ff = ff;
		this.moment = LocalDateTime.now();
	}
}
