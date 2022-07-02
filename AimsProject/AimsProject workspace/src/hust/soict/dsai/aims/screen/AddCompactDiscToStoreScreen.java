package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;

@SuppressWarnings("serial")
public class AddCompactDiscToStoreScreen extends AddMediaToStoreScreen {
	private CompactDisc cd;
	
	public AddCompactDiscToStoreScreen(StoreManagerScreen screen) {
		// String title, String category, float cost, String director, String artist
		// TODO tracks
		super(screen, "Add Compact Disc to store",
				"Title", "Category", "Director", "Artist", "Cost (float)");
		//		0		1			2			3			4
		
	}
	
	@Override
	public void add() {
		String data[] = getData();
		cd = new CompactDisc(data[0], data[1], (float) Float.parseFloat(data[4]),
				data[2], data[3]);
		store.addMedia(cd);
		close();
		screen.refresh();
	}
	
}
