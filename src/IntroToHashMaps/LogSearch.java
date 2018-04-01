package IntroToHashMaps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	HashMap <Integer, String> h = new HashMap<Integer, String>();
	public static void main(String[] args) {
		LogSearch l = new LogSearch();
		l.createGUI();
	}
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	
	public void createGUI() {
		frame.setVisible(true);
		frame.setSize(500, 75);
		frame.add(panel);
		b1.setText("Add Entry");
		b2.setText("Search by ID");
		b3.setText("View List");
		b4.setText("Remove Entry");
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			String messageID = JOptionPane.showInputDialog("Please enter an ID");
			String name = JOptionPane.showInputDialog("Now enter a name");
			int ID = Integer.parseInt(messageID);
			h.put(ID, name);
		}
		if (e.getSource() == b2) {
			String enterStringID = JOptionPane.showInputDialog("Please enter an ID");
			int enterID = Integer.parseInt(enterStringID);
			for (int key: h.keySet()) {
				if (enterID == key) {
					JOptionPane.showMessageDialog(null, "That persons name is " + h.get(key));
				}
				if (!h.containsKey(key)) {
					JOptionPane.showMessageDialog(null, "That person doesn't exist");
				}
			}
		}
		if (e.getSource() == b3) {
			String displayName = "";
			for(int key: h.keySet()) {
				String name = h.get(key);
				int nameID = key;
				displayName += "ID: " + nameID + " Name: " + name + "\n";
			}
			JOptionPane.showMessageDialog(null, displayName);
		}
		if (e.getSource() == b4) {
			String IDremovalWords = JOptionPane.showInputDialog("Please enter the ID that needs to be removed");
			int IDremoved = Integer.parseInt(IDremovalWords);
					if (h.keySet().contains(IDremoved)) {
						h.remove(IDremoved);
					}
					else if (!h.containsKey(IDremoved)) {
						JOptionPane.showMessageDialog(null, "That ID is not on the list");
					}
		}
	}
}
