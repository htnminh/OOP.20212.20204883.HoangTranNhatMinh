package hust.soict.dsai.aims.store;


import java.util.ArrayList;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;

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
	
	public void print(String note) {
		System.out.println("***********************STORE**********************");
		System.out.println("Stored Items: " + note);
		for (Media media: itemsInStore) {
			if (media != null) 
				System.out.println(media);
		}
		System.out.println("**************************************************");
	}

}
