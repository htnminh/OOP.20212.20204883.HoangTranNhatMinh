package hust.soict.dsai.aims.store;


import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
	private static final int MAX_NUMBER_STORED = 100;
	private int qtyStored = 0;
	private DigitalVideoDisc[] itemsInStore =
				new DigitalVideoDisc[MAX_NUMBER_STORED];
	
	public void addDVD(DigitalVideoDisc dvd) {
		if (qtyStored < MAX_NUMBER_STORED) {
			for (int i = 0; i < MAX_NUMBER_STORED; i++) {
				if (itemsInStore[i] == null) {
					itemsInStore[i] = dvd;
					qtyStored++;
					System.out.println(
							"Added to store the following disc: " + dvd.toString());
					if (qtyStored == MAX_NUMBER_STORED)
						System.out.println("The store is almost full");
					break;
				}
			}
		} else {
			System.out.println("Cannot add disc, the store is full");
		}
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
		for (int i = 0; i < MAX_NUMBER_STORED; i++) {
			if (itemsInStore[i] != null)
				if (itemsInStore[i].getTitle().equals(dvd.getTitle())) {
					itemsInStore[i] = null;
					qtyStored--;
					System.out.println(
							"Removed from store the following disc: "
													+ dvd.toString());
					return;
				}
		}
		System.out.println("The disc is not found");
	}
	
	public void removeDVD(String title) {
		DigitalVideoDisc dvd = new DigitalVideoDisc(title);
		removeDVD(dvd);
	}
	
	public int searchExact(String title) {
		for (int i = 0; i < MAX_NUMBER_STORED; i++) {
			if (itemsInStore[i] != null)
				if (itemsInStore[i].getTitle().equals(title)) {
					return i;
				}
		}
		return -1;
	}
	
	public void seeDetailsAndAskAddDVD(String title, Cart cart) {
		int i = searchExact(title);
		if (i >= 0) {
			DigitalVideoDisc dvd = itemsInStore[i];
			System.out.println("Found: " + dvd.toString());
			
			System.out.println("Add disc? 0. No / 1. Yes (exception not handled)");
			int inp = Aims.readIntInput(1);
			if (inp == 1)
				cart.addDigitalVideoDisc(dvd);
		} else
			System.out.println("The disc is not found");
	}
	
	public void addDVDToCart(String title, Cart cart) {
		int i = searchExact(title);
		if (i >= 0) {
			DigitalVideoDisc dvd = itemsInStore[i];
			cart.addDigitalVideoDisc(dvd);
			System.out.println("DVD added to cart");
		} else
			System.out.println("The disc is not found");
	}
	
	public void print(String note) {
		System.out.println("***********************STORE**********************");
		System.out.println("Stored Items: " + note);
		for (DigitalVideoDisc dvd: itemsInStore) {
			if (dvd != null) 
				System.out.println(dvd);
		}
		System.out.println("**************************************************");
	}

}
