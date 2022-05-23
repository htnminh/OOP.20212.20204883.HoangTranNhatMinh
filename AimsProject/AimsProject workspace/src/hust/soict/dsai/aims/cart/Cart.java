package hust.soict.dsai.aims.cart;
import java.util.Arrays;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils;

public class Cart {
	
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBER_ORDERED) {
			for (int i = 0; i < MAX_NUMBER_ORDERED; i++) {
				if (itemsOrdered[i] == null) {
					itemsOrdered[i] = disc;
					qtyOrdered++;
					System.out.println(
							"The following disc has been added: " + disc.toString());
					if (qtyOrdered == MAX_NUMBER_ORDERED)
						System.out.println("The cart is almost full");
					break;
				}
			}
		} else {
			System.out.println("Cannot add disc, the cart is full");
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
		for (DigitalVideoDisc disc: dvdList) {
			addDigitalVideoDisc(disc);
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int i = searchExact(disc.getTitle());
		if (i >= 0) {
			itemsOrdered[i] = null;
			qtyOrdered--;
			System.out.println(
					"The following disc has been removed: " + disc.toString());
		} else
			System.out.println("The disc is not found");
	}
	
	public float totalCost() {
		float res = 0;
		for (DigitalVideoDisc disc: itemsOrdered)
			if (disc != null)
				res += disc.getCost();
		return res;
	}
	
	public String toString() {
		String res = "";
		for (DigitalVideoDisc disc: itemsOrdered)
			if (disc != null)
				res += disc.getTitle() + "; ";
		return res;
	}
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	
	public void print(String note) {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items: " + note);
		for (DigitalVideoDisc dvd: itemsOrdered) {
			if (dvd != null) 
				System.out.println(dvd);
		}
		System.out.println(String.format("Total cost: %.2f", totalCost()));
		System.out.println("**************************************************");
	}
	
	public void print() {
		sortByAttr();
		print("");
	}
	
	private void arrange() {
		// arrange the cart by pushing all nulls to right most
		DigitalVideoDisc[] arrangedItems = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
		int i = 0;
		for (DigitalVideoDisc dvd: itemsOrdered)
			if (dvd != null) {
				arrangedItems[i] = dvd;
				i++;
			}
		itemsOrdered = arrangedItems;
	} 
	
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
	
	public void search(int id) {
		boolean found = false;
		for (DigitalVideoDisc dvd: itemsOrdered)
			if (dvd != null)
				if (dvd.getId() == id) {
					found = true;
					System.out.println("Found: " + dvd);
				}
		if (!found)
			System.out.println("DVD not found");
	}
	
	public void search(String name) {
		// Aladin contains "a", The Lion King contains "in":
		// this type of results are included
		boolean found = false;
		for (DigitalVideoDisc dvd: itemsOrdered)
			if (dvd != null)
				if (dvd.isMatch(name)) {
					found = true;
					System.out.println("Found: " + dvd);
				}
		if (!found)
			System.out.println("DVD not found");
	}
	
	public int searchExact(String name) {
		for (int i = 0; i < MAX_NUMBER_ORDERED; i++) {
			if (itemsOrdered[i] != null)
				if (itemsOrdered[i].getTitle().equals(name)) {
					return i;
				}
		}
		return -1;
	}
	
	public void empty() {
		qtyOrdered = 0;
		for (int i = 0; i < MAX_NUMBER_ORDERED; i++)
			itemsOrdered[i] = null;
	}
}
