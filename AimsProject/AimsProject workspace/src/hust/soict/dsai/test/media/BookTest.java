package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		Book book = new Book("name", "type", 69);
		book.setContent("This, is, a sentence! Also this. And this.");
		for (String word: book.getContentTokens())
			System.out.println("\"" + word + "\"");
		System.out.println(book.getWordFrequency().toString());
		System.out.println(book);
	}

}
