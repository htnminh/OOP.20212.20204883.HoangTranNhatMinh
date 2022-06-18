package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public abstract class AddMediaToStoreScreen extends JFrame {
	protected Container cp;
	protected JPanel panel;
	
	public AddMediaToStoreScreen(String title, String... fieldNames) {
		getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.WHITE));
		
		cp = getContentPane();
		cp.setLayout(new GridLayout(fieldNames.length + 1, 2, 2, 2));
		
		for (String fieldName: fieldNames) {
			cp.add(new JLabel(fieldName));
			cp.add(new JTextField());
		}
		JButton addBtn = new JButton("Add");
		cp.add(addBtn);
		JButton cancelBtn = new JButton("Cancel");
		cp.add(cancelBtn);
		
		setTitle(title);
		setSize(550, 45 * fieldNames.length + 50);
		setLocationRelativeTo(null);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	

}
