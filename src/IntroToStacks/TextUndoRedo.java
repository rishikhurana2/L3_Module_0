package IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	Stack<Character> c = new Stack<Character>();
	public static void main(String[] args) {
		TextUndoRedo r = new TextUndoRedo();
		r.createUI();
	}
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	void createUI() {
		frame.setVisible(true);
		frame.setSize(1000, 1000);
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			String t = label.getText(); 
			int textLength = t.length();
			char deletedCharacter = t.charAt(textLength-1);
			label.setText(t.substring(0,textLength-1));
			//System.out.println(deletedCharacter+"");
			c.push(deletedCharacter);
		}
		else if (e.getKeyCode()== KeyEvent.VK_R) {
			char j = c.pop();
			String r = j + "";
			String t = label.getText();
			label.setText(t.concat(r));
		}
		else {
			char a = e.getKeyChar();
			String textEditor = a+"";
			label.setText(label.getText() + textEditor);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
