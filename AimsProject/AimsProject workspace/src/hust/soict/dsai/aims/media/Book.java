package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public List<String> getAuthors() {
		return authors;
	}
	
	private int indexAuthor(String authorName) {
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).equals(authorName)) {
				return i;
			}
		}
		return -1;
	}
	
	private void addAuthor(String authorName) {
		if (indexAuthor(authorName) != -1)
			authors.add(authorName);
		// else
			
	}
	private void removeAuthor(String authorName) {
		int i = indexAuthor(authorName);
		if (i != -1)
			authors.remove(i);
		// else
	}
	
}
