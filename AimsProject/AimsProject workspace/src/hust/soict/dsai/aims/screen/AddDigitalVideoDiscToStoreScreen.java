package hust.soict.dsai.aims.screen;

import java.util.Arrays;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

@SuppressWarnings("serial")
public class AddDigitalVideoDiscToStoreScreen extends AddMediaToStoreScreen {
	private DigitalVideoDisc dvd;
	
	public AddDigitalVideoDiscToStoreScreen(StoreManagerScreen screen) {
		// String title, String category, String director, int length, float cost
		super(screen, "Add Digital Video Disc to store",
				"Title", "Category", "Director", "Length", "Cost");
		
	}
	
	@Override
	public void add() {
		// System.out.println(Arrays.toString(getData()));
		String data[] = getData();
		dvd = new DigitalVideoDisc(data[0], data[1], data[2],
				(int) Integer.parseInt(data[3]), (float) Float.parseFloat(data[4]));
		store.addMedia(dvd);
		close();
		screen.refresh();
	}
	
	
	
}
