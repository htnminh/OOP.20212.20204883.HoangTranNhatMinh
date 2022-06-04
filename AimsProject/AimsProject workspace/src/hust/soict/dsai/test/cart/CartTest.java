package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(
				"The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(
				"Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(
							"Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);

		cart.print();
		cart.sortByCostDescTitleAndPrint();
		cart.sortByTitleAndPrint();
		
		cart.search(2);
		cart.search(5);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc(
				"Star Zars", "Test Fiction", "Test Lucas", 15, 69f);
		cart.addDigitalVideoDisc(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc(
				"Star Wars", "Test Fiction", "Test Lucas", 15, 69f);
		cart.addDigitalVideoDisc(dvd5);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc(
				"Star Wars", "Test Fiction", "Test Lucas", 42, 69f);
		cart.addDigitalVideoDisc(dvd6);
		
		cart.print();
		
		cart.addDigitalVideoDisc(dvd1);
		cart.search(1);
		
		System.out.println();
		cart.search("There is a star in the galaxy");
		// Aladin contains "a", The Lion King contains "in"
		
		System.out.println();
		cart.search("star is an astronomical object");
		
		cart.removeDigitalVideoDisc(dvd4);
		cart.addDigitalVideoDisc(dvd4);
		
		cart.sortByCostDescTitleAndPrint();
		
	}

}
