package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

@SuppressWarnings("serial")
public class AddDigitalVideoDiscToStoreScreen extends AddMediaToStoreScreen {
	private DigitalVideoDisc dvd;
	
	public AddDigitalVideoDiscToStoreScreen(StoreManagerScreen screen) {
		// String title, String category, String director, int length, float cost
		super(screen, "Add Digital Video Disc to store",
				"Title", "Category", "Director", "Length (int)", "Cost (float)");
		
	}
	
	@Override
	public void add() {
		String data[] = getData();
		dvd = new DigitalVideoDisc(data[0], data[1], data[2],
				(int) Integer.parseInt(data[3]), (float) Float.parseFloat(data[4]));
		store.addMedia(dvd);
		close();
		screen.refresh();
	}
	
}
