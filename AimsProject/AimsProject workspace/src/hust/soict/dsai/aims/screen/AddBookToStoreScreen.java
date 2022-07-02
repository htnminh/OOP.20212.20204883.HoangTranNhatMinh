package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;

@SuppressWarnings("serial")
public class AddBookToStoreScreen extends AddMediaToStoreScreen {
	private Book book;
	
	public AddBookToStoreScreen(StoreManagerScreen screen) {
		// String title, String category, float cost
		// TODO authors, content -> contentTokens, wordFrequency
		super(screen, "Add Book to store",
				"Title", "Category", "Cost (float)");
		
	}
	
	@Override
	public void add() {
		String data[] = getData();
		book = new Book(data[0], data[1], (float) Float.parseFloat(data[2]));
		store.addMedia(book);
		close();
		screen.refresh();
	}
	
}
