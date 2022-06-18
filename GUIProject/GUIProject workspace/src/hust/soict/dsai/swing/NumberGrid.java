package hust.soict.dsai.swing;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NumberGrid extends JFrame{
	private JButton btbNumbers[] = new JButton[10];
	private JButton btnDelete, btnReset;
	private JTextField tfDisplay;
	
	public static void main(String[] args) {
		new NumberGrid();
	}
	
	public NumberGrid() {
		tfDisplay = new JTextField();
		tfDisplay.setComponentOrientation(
				ComponentOrientation.RIGHT_TO_LEFT);
		
		JPanel panelButtons = new JPanel(new GridLayout(4, 3));
		addButtons(panelButtons);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(tfDisplay, BorderLayout.NORTH);
		cp.add(panelButtons, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Number Grid");
		setSize(200, 200);
		setVisible(true);
	}
	
	void addButtons(JPanel panelButtons) {
		ButtonListener btnListener = new ButtonListener();
		for (int i = 1; i <= 9; i++) {
			btbNumbers[i] = new JButton("" + i);
			panelButtons.add(btbNumbers[i]);
			btbNumbers[i].addActionListener(btnListener);
		}
		
		btnDelete = new JButton("DEL");
		panelButtons.add(btnDelete);
		btnDelete.addActionListener(btnListener);
		
		btbNumbers[0] = new JButton("0");
		panelButtons.add(btbNumbers[0]);
		btbNumbers[0].addActionListener(btnListener);
		
		btnReset = new JButton("C");
		panelButtons.add(btnReset);
		btnReset.addActionListener(btnListener);
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if (button.charAt(0) >= '0' && button.charAt(0) <= '9')
				tfDisplay.setText(tfDisplay.getText() + button);
			else if (button.equals("DEL")) {
				if (tfDisplay.getText().length() > 0)
					tfDisplay.setText(tfDisplay.getText()
							.substring(0, tfDisplay.getText().length() - 1));
			} else
				tfDisplay.setText("");
		}
		
	}
	
	
}
