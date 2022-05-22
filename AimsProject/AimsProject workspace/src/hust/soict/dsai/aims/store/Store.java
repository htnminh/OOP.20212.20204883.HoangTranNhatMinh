package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

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
	
//	public void seeDetailsDVD(String title) {
//		int i = searchExact(title);
//		if (i >= 0)
//			System.out.println(itemsInStore[i].toString());
//		else
//			System.out.println("The disc is not found");
//	}
	
	public int searchExact(String title) {
		for (int i = 0; i < MAX_NUMBER_STORED; i++) {
			if (itemsInStore[i] != null)
				if (itemsInStore[i].getTitle().equals(title)) {
					return i;
				}
		}
		return -1;
	}
}
