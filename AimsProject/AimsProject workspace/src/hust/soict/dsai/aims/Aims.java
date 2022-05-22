package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(
				"The Lion King", "Animation", "Roger Allers",
				87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(
				"Star Wars", "Science Fiction", "George Lucas",
				87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(
				"Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		System.out.println(cart.getQtyOrdered() + " DVDs in Cart: " + cart.toString());
		System.out.println("Total Cost is: " + cart.totalCost());
		System.out.println();
		
		
		cart.removeDigitalVideoDisc(dvd2);
		System.out.println(cart.getQtyOrdered() + " DVDs in Cart: " + cart.toString());
		System.out.println("Total Cost is: " + cart.totalCost());
		System.out.println();
		
		DigitalVideoDisc[] dvdList = {dvd1, dvd1, dvd2};
		cart.addDigitalVideoDisc(dvdList);
		System.out.println(cart.getQtyOrdered() + " DVDs in Cart: " + cart.toString());
		System.out.println("Total Cost is: " + cart.totalCost());
		System.out.println();
		
		cart.addDigitalVideoDisc(dvd3, dvd2, dvd1);
		cart.print();
	}

}
