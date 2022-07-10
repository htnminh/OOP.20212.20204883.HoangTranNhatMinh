package hust.soict.dsai.aims.store;


import java.util.ArrayList;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		itemsInStore.add(media);
		System.out.println(
				"Added to store the following media: " + media.toString());
	}
	
	public void removeMedia(String title) {
		int i = searchExact(title);
		if (i >= 0) {
			System.out.println(
					"Removed from store the following media: "
								+ itemsInStore.get(i).toString());
			itemsInStore.remove(i);
		} else
			System.out.println("The media is not found");
	}

		
	public void removeMedia(Media media) {
		removeMedia(media.getTitle());
	}
	
	public int searchExact(String name) {
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i) != null)
				if (itemsInStore.get(i).getTitle().equals(name)) {
					return i;
				}
		}
		return -1;
	}
	
	public void seeDetailsAndAskAddMedia(String title, Cart cart) {
		int i = searchExact(title);
		if (i >= 0) {
			Media media = itemsInStore.get(i);
			System.out.println("Found: " + media.toString());
			
			System.out.println("Add media? 0. No / 1. Yes (exception not handled)");
			int inp = Aims.readInputInt(1);
			if (inp == 1)
				cart.addMedia(media);
		} else
			System.out.println("The media is not found");
	}
	
	public void addMediaToCart(String title, Cart cart) {
		int i = searchExact(title);
		if (i >= 0) {
			Media media = itemsInStore.get(i);
			cart.addMedia(media);
			System.out.println("Media added to cart");
		} else
			System.out.println("The media is not found");
	}
	
	public void playAMedia(String title) {
		int i = searchExact(title);
		if (i == -1) 
			System.out.println("The media is not found");
		Media media = itemsInStore.get(i);
		
		if (media instanceof Playable) 
			((Playable)media).play();
		else
			System.out.println("Not playable");
	}
	
	public void print(String note) {
		System.out.println("***********************STORE**********************");
		System.out.println("Stored Items: " + note);
		for (Media media: itemsInStore) {
			if (media != null) 
				System.out.println(media);
		}
		System.out.println("**************************************************");
	}
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public void addSampleMediae() {
		addMedia(new Book("The Book A", "The Category BookA", 3.2f));
		addMedia(new Book("The Book B", "The Category BookB", 1.4f));
		addMedia(new Book("The Book C", "The Category BookC", 1.2f));
		addMedia(new DigitalVideoDisc(
				"The DVD A", "The Category DVDA", "The Director DVDA", 6, 15f));
		addMedia(new DigitalVideoDisc(
				"The DVD B", "The Category DVDB", "The Director DVDB", 9, 12.8f));
		addMedia(new DigitalVideoDisc(
				"The DVD C", "The Category DVDC", "The Director DVDC", 14, 2.1f));
		addMedia(new CompactDisc(
				"The CD A", "The Category CDA", 2.3f, "The Director CDA", "The Artist CDA"));
		addMedia(new CompactDisc(
				"The CD B", "The Category CDB", 6.9f, "The Director CDB", "The Artist CDB"));
		addMedia(new CompactDisc(
				"The CD C", "The Category CDC", 5.5f, "The Director CDC", "The Artist CDC"));
	}
}
