package IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	ArrayList<String> names = new ArrayList<String>();
	public static void main(String[] args) {
		GuestBook gb = new GuestBook();
		gb.createUI();
	}
	void createUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setVisible(true);
		frame.add(panel);
		frame.setSize(500, 75);
		panel.add(button1);
		panel.add(button2);
		button1.setText("Add Name");
		button2.setText("View Names");
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1) {
			String inputName = JOptionPane.showInputDialog("Enter a name please");
			names.add(inputName);
		}
		if (e.getSource() == button2) {
			String guest = "";
			for(int i = 0; i< names.size(); i++) {
				int guestNumber = i+1;
				guest += "Guest " + guestNumber + ": " + names.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, guest);
		}
	}
}
