package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.DVDUtils;

public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		itemsOrdered.add(media);
		System.out.println(
				"The following media has been added: " + media.toString());
	}
	
	public void addMedia(Media... mediaList) {
		for (Media media: mediaList) {
			addMedia(media);
		}
	}
	
	public void removeMedia(Media media) {
		int i = searchExact(media.getTitle());
		if (i >= 0) {
			itemsOrdered.remove(i);
			System.out.println(
					"The following media has been removed: " + media.toString());
		} else
			System.out.println("The media is not found");
	}
	
	public float totalCost() {
		float res = 0;
		for (Media media: itemsOrdered)
			if (media != null)
				res += media.getCost();
		return res;
	}
	
	public String toString() {
		String res = "";
		for (Media media: itemsOrdered)
			if (media != null)
				res += media.getTitle() + "; ";
		return res;
	}
	
	public void print(String note) {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items: " + note);
		for (Media media: itemsOrdered) {
			if (media != null) 
				System.out.println(media);
		}
		System.out.println(String.format("Total cost: %.2f", totalCost()));
		System.out.println("**************************************************");
	}
	
	public void print() {
		// sortByAttr();
		print("");
	}
	
	/*
	private void pasteArrayToItemsOrdered(DigitalVideoDisc[] array) {
		// paste the array to itemsOrdered
		for (int i = 0; i < MAX_NUMBER_ORDERED; i++) {
			if (i < array.length) {
				itemsOrdered[i] = array[i];
			} else {
				itemsOrdered[i] = null;
			}
		}
	}
	
	
	public void sortByCostDescTitleAndPrint() {
		arrange();
		DigitalVideoDisc[] subItemsOrdered
			= Arrays.copyOfRange(itemsOrdered, 0, qtyOrdered);
		subItemsOrdered = DVDUtils.sortByCost(subItemsOrdered);
		pasteArrayToItemsOrdered(subItemsOrdered);
		print("(by cost (descending), then title)");
	}
	
	public void sortByTitleAndPrint() {
		arrange();
		DigitalVideoDisc[] subItemsOrdered
			= Arrays.copyOfRange(itemsOrdered, 0, qtyOrdered);
		subItemsOrdered = DVDUtils.sortByTitle(subItemsOrdered);
		pasteArrayToItemsOrdered(subItemsOrdered);
		print("(by title)");
	}
	
	public void sortByAttr() {
		arrange();
		DigitalVideoDisc[] subItemsOrdered
			= Arrays.copyOfRange(itemsOrdered, 0, qtyOrdered);
		subItemsOrdered = DVDUtils.sortByAttr(subItemsOrdered);
		pasteArrayToItemsOrdered(subItemsOrdered);
	}
	*/
	
	public void search(int id) {
		boolean found = false;
		for (Media media: itemsOrdered)
			if (media != null)
				if (media.getId() == id) {
					found = true;
					System.out.println("Found: " + media);
				}
		if (!found)
			System.out.println("Media not found");
	}
	
	public void search(String name) {
		// Aladin contains "a", The Lion King contains "in":
		// this type of results are included
		boolean found = false;
		for (Media media: itemsOrdered)
			if (media != null)
				if (media.isMatch(name)) {
					found = true;
					System.out.println("Found: " + media);
				}
		if (!found)
			System.out.println("Media not found");
	}
	
	public int searchExact(String name) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i) != null)
				if (itemsOrdered.get(i).getTitle().equals(name)) {
					return i;
				}
		}
		return -1;
	}
	
	public void empty() {
		itemsOrdered = new ArrayList<Media>();
	}
}
