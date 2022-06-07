package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.MediaUtils;

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
	
	public void removeMedia(String title) {
		int i = searchExact(title);
		if (i >= 0) {
			System.out.println(
					"The following media has been removed: "
								+ itemsOrdered.get(i).toString());
			itemsOrdered.remove(i);
		} else
			System.out.println("The media is not found");
	}

		
	public void removeMedia(Media media) {
		removeMedia(media.getTitle());
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
	*/
	
	public void sortByCostDescendingTitleAndPrint() {
		itemsOrdered = MediaUtils.sortByCostDescendingTitle(itemsOrdered);
		print("(by cost (descending), then title)");
	}
	
	public void sortByTitleAndPrint() {
		itemsOrdered = MediaUtils.sortByTitle(itemsOrdered);
		print("(by title)");
	}
	
	public void sortByAttr() {
		System.out.println("This function is temporary disabled");
		/*
		arrange();
		DigitalVideoDisc[] subItemsOrdered
			= Arrays.copyOfRange(itemsOrdered, 0, qtyOrdered);
		subItemsOrdered = DVDUtils.sortByAttr(subItemsOrdered);
		pasteArrayToItemsOrdered(subItemsOrdered);
		*/
	}
	
	
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
	
	public Media getALuckyItem() {
		if (itemsOrdered.size() >= 5) {
			//       random        -> [0.0, 1.0)
			//       random * size -> [0.0, size)
			// (int) random * size -> [0,   size)
			int i = (int) Math.random() * itemsOrdered.size();
			return itemsOrdered.get(i);
		} else
			return null;
	}
	
	public void order() {
		Media luckyItem = getALuckyItem();
		if (luckyItem == null) {
			System.out.println("No free item this time.");
			System.out.println("Total cost: " + totalCost());
		} else {
			System.out.println("Your free item: " + luckyItem.toString());
			System.out.println("Discounted total cost: " + 
							(totalCost() - luckyItem.getCost()));
		}
		empty();
	}
}