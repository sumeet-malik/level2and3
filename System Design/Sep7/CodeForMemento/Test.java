package CodeForMemento;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CareTaker ct = new CareTaker();
		
		Editor e = new Editor();
		e.text = "hello";
		e.cursorX = 10;
		e.cursorY = 20;
		e.ff = "Times New Roman";
		e.fs = 20;
		e.print();
		
		EditorMemento em1 = e.getSnapshot();
		ct.save(em1);
		
		e.text += " World";
		e.cursorX = 30;
		e.print();
		
		EditorMemento em2 = e.getSnapshot();
		ct.save(em2);
		
		e.fs = 25;
		e.ff = "Comic Sans MS";
		e.print();
		
		EditorMemento em3 = e.getSnapshot();
		ct.save(em3);
		
		e.text += " , hope all is well!!";
		e.print();
		
		e.restore(ct.undo());
		e.print();
		
		e.restore(ct.undo());
		e.print();
		
		e.restore(ct.undo());
		e.print();
	}

}
