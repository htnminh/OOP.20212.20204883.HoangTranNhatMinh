package hust.soict.dsai.aims.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AddCancelListener implements ActionListener {
	AddMediaToStoreScreen frame;
	
	public AddCancelListener(AddMediaToStoreScreen frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Add")) {
			frame.add();
		} else {
			frame.close();
		}
		
	}
	
}
