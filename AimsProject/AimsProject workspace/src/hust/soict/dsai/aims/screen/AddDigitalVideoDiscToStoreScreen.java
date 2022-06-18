package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AddDigitalVideoDiscToStoreScreen extends AddMediaToStoreScreen {
	
	public static void main(String[] args) {
		new AddDigitalVideoDiscToStoreScreen();
	}
	
	public AddDigitalVideoDiscToStoreScreen() {
		//String title, String category, String director, int length, float cost
		super("Add Digital Video Disc to store",
				"Title", "Category", "Director", "Length", "Cost");
		
	}
	
}
