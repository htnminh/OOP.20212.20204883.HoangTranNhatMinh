package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.store.Store;


@SuppressWarnings("serial")
public abstract class AddMediaToStoreScreen extends JFrame {
	protected StoreManagerScreen screen;
	protected Store store;
	protected Container cp;
	protected JPanel panel;
	protected String[] fieldNames;
	protected JTextField[] textFields;
	
	public AddMediaToStoreScreen(StoreManagerScreen screen, String title, String... fieldNames) {
		this.screen = screen;
		this.store = screen.getStore();
		this.fieldNames = fieldNames;
		textFields = new JTextField[fieldNames.length];
		
		getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.WHITE));
		
		cp = getContentPane();
		cp.setLayout(new GridLayout(fieldNames.length + 1, 2, 2, 2));
		
		for (int i = 0; i < fieldNames.length; i++) {
			cp.add(new JLabel(fieldNames[i]));
			textFields[i] = new JTextField();
			cp.add(textFields[i]);
		}
		AddCancelListener btnListener = new AddCancelListener(this);
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(btnListener);
		cp.add(addBtn);
		JButton cancelBtn = new JButton("Cancel");
		cp.add(cancelBtn);
		cancelBtn.addActionListener(btnListener);
		
		setTitle(title);
		setSize(550, 45 * fieldNames.length + 50);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public String[] getData() {
		String res[] = new String[fieldNames.length];
		for (int i = 0; i < fieldNames.length; i++) {
			res[i] = textFields[i].getText();
		}
		return res;
		
	}
	
	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	public abstract void add();
	
	

}
