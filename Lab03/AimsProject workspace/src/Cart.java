
public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
				if (itemsOrdered[i] == null) {
					itemsOrdered[i] = disc;
					qtyOrdered++;
					if (qtyOrdered < MAX_NUMBERS_ORDERED) {
						System.out.println(
							"The following disc has been added: " + disc.toString());
					} else {
						System.out.println("The cart is almost full");
					}
					break;
				}
			}
		} else {
			System.out.println("Cannot add disc, the cart is full");
		}
	}
	
	/*
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (DigitalVideoDisc disc: dvdList) {
			addDigitalVideoDisc(disc);
		}
	}
	*/
	
	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
		for (DigitalVideoDisc disc: dvdList) {
			addDigitalVideoDisc(disc);
		}
	}
	
	/*
	public void addDigitalVideoDisc(
			DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	*/
	
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] != null)
				if (itemsOrdered[i].getTitle().equals(disc.getTitle())) {
					itemsOrdered[i] = null;
					qtyOrdered--;
					System.out.println(
							"The following disc has been removed: " + disc.toString());
					return;
				}
		}
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
	
	
}
