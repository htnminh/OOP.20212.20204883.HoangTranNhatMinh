package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;


public class Aims {
	private static Store store = new Store();
	private static Cart cart = new Cart();

	public static void main(String[] args) {
		showAction();
		exit();
	}
	
	// FUNCTION TEMPORARY DISABLED:
	// current bug: after adding a disc to store
	// it shows
	// Input = Input = 
	/*
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
	*/
	public static int readIntInput(int max) {
		Scanner scanner = new Scanner(System.in);

		int inp;
		do {
			System.out.print("Input (exception not handled) = ");
			inp = scanner.nextInt();
		} while (!((0 <= inp && inp <= max)));
		
		// scanner.close();
		return inp;
	}
	
	public static String readStringInput(String message) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print(message);
		String inp = scanner.nextLine();
		
		// scanner.close();	
		return inp;
	}
	
	// MAIN MENU
	public static void showAction() {
		showMenu();
		int inp = readIntInput(3);
		if (inp == 0) {
			exit();
		}
		if (inp == 1) storeAction();
		if (inp == 2) updateAction();
		if (inp == 3) cartAction();
	}
	
	// STORE
	public static void storeAction() {
		storeMenu();
		int inp = readIntInput(3);
		if (inp == 0) showAction();
		if (inp == 1) storeDetails();
		if (inp == 2) storeAdd();
		if (inp == 3) cartAction();
	}
	
	public static void storeDetails() {
		store.print("");
		String title = readStringInput("Enter title: ");
		
		store.seeDetailsAndAskAddMedia(title, cart);
		storeAction();
	}
	
	public static void storeAdd() {
		store.print("");
		String title = readStringInput("Enter title: ");
		store.addMediaToCart(title, cart);
		storeAction();
	}
	
	// UPDATE
	public static void updateAction() {
		store.print("");
		
		System.out.println("1. Add a DVD to store");
		System.out.println("2. Remove a DVD from store");
		System.out.println("0. Back");
		
		int inp = readIntInput(2);
		
		if (inp == 0) showAction();
		if (inp == 1) {
			String title = readStringInput("Enter title: ");
			String category = readStringInput("Enter category: ");
			String director = readStringInput("Enter director: ");
			
			Scanner scanner = new Scanner(System.in); 
			
			System.out.print("Enter length (int) (exception not handled): ");
			int length = scanner.nextInt();
			System.out.print("Enter cost (float) (exception not handled): ");
			float cost = scanner.nextFloat();
			
			
			DigitalVideoDisc dvd = new DigitalVideoDisc(
					title, category, director, length, cost);
			store.addDVD(dvd);
			
			updateAction();
		}
		if (inp == 2) {
			String title = readStringInput("Enter title: ");
			store.removeDVD(title);
			updateAction();
		}
		
	}

	// CART
	public static void cartAction() {
		cart.print();
		cartMenu();
		int inp = readIntInput(4);
		
		if (inp == 0) showAction();
		if (inp == 1) cartFilter();
		if (inp == 2) cartSort();
		if (inp == 3) cartRemove();
		if (inp == 4) cartOrder();
	}
	
	public static void cartFilter() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Filter by? 0. ID / 1. Title (exception not handled)");
		int inp = readIntInput(1);
		if (inp == 0) {
			System.out.print("Enter ID (int) (exception not handled): ");
			int id = scanner.nextInt();
			cart.search(id);
			cartAction();
		} else {
			String title = readStringInput("Enter title: ");
			cart.search(title);
			cartAction();
		}
	}
	
	public static void cartSort() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Sort by? 0. Title / 1. Cost (exception not handled)");
		int inp = readIntInput(1);
		if (inp == 0) {
			cart.sortByAttr();
			cart.print("(sorted by title, cost (descending))");
			cartAction();
		} else {
			cart.sortByCostDescTitleAndPrint();
			cartAction();
		}
	}
	
	public static void cartRemove() {
		String title = readStringInput("Enter title: ");
		DigitalVideoDisc dvd = new DigitalVideoDisc(title);
		cart.removeDigitalVideoDisc(dvd);
		cartAction();
	}
	
	public static void cartOrder() {
		System.out.println("An order is created");
		cart.empty();
		cartAction();
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

	public static void exit() {
		System.out.print("Program exited.");
		System.exit(0);
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
