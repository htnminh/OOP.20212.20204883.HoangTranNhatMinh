package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;


public class Aims {
	private static Store store = new Store();
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		showAction();
		System.out.print("Program exited");
		scanner.close();
	}
	
	public static int readInput(int max) {
		String inpStr;
		int inpInt;
		
		do {
			try {
				System.out.print("Input = ");
				inpStr = scanner.nextLine();
				inpInt = Integer.parseInt(inpStr);
				if (0 <= inpInt && inpInt <= max)
					break;
			} catch (NumberFormatException e) {
			}
		} while (true);
		
		return inpInt;
	}
	
	// MAIN MENU
	public static void showAction() {
		showMenu();
		int inp = readInput(3);
		if (inp == 0) {}
		if (inp == 1) storeAction();
		if (inp == 2) updateAction();
		if (inp == 3) cartAction();
	}
	
	// STORE
	public static void storeAction() {
		storeMenu();
		int inp = readInput(3);
		if (inp == 0) showAction();
		if (inp == 1) seeDetailsDVD();
		if (inp == 2) addToCartDVD();
		if (inp == 3) seeCart();
	}
	
	public static void seeDetailsDVD() {
		System.out.print("Enter title: ");
		String title = scanner.nextLine();
		int res = store.searchExact(title);
		if (res >= 0) {
			
		}
		
	}
	
	public static void addToCartDVD() {
		
	}
	
	public static void seeCart() {
		
	}
	
	// UPDATE
	public static void updateAction() {
		//updateMenu();
		
	}

	// CART
	public static void cartAction() {
		
	}
	
	
	// 
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a DVD’s details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter DVDs in cart");
		System.out.println("2. Sort DVDs in cart");
		System.out.println("3. Remove DVD from cart");
		System.out.println("4. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
}

/*
 * Cart cart = new Cart();
		
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
*/
