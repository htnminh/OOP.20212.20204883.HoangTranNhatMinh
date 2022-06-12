package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class TestMediaCompareTo {

	public static void main(String[] args) {
		Book book1 = new Book("bb", "AA", 3);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("aa", "AA", 1);
		CompactDisc cd1 = new CompactDisc("aa", "BB", 5, "", "");
		
		ArrayList<Media> arraylist = new ArrayList<Media>();
		arraylist.add(book1);
		arraylist.add(dvd1);
		arraylist.add(cd1);
		System.out.println(arraylist.toString());
		
		Collections.sort(arraylist);
		System.out.println(arraylist.toString());
	}

}
