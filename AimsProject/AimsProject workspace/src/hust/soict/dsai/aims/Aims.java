package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;


public class Aims {
	private static Store store = new Store();
	private static Cart cart = new Cart();

	public static void main(String[] args) {
		showAction();
		exit();
	}
	
	public static int readInputInt(int max) {
		Scanner scanner = new Scanner(System.in);

		int inp;
		do {
			System.out.print("Input (exception not handled) = ");
			inp = scanner.nextInt();
		} while (!((0 <= inp && inp <= max)));
		
		return inp;
	}
	
	public static String readInputString(String message) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print(message);
		String inp = scanner.nextLine();
		
		return inp;
	}
	
	// MAIN MENU
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
	
	public static void showAction() {
		showMenu();
		int inp = readInputInt(3);
		if (inp == 0) exit();
		if (inp == 1) storeAction();
		if (inp == 2) updateAction();
		if (inp == 3) cartAction();
	}
	
	// STORE
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a Media’s details");
		System.out.println("2. Add a Media to cart");
		System.out.println("3. See current cart");
		System.out.println("4. Play a Media in store");  // TODO
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeAction() {
		storeMenu();
		int inp = readInputInt(4);
		if (inp == 0) showAction();
		if (inp == 1) storeDetails();
		if (inp == 2) storeAdd();
		if (inp == 3) cartAction();
		if (inp == 4) storePlay();
	}
	
	public static void storeDetails() {
		store.print("");
		String title = readInputString("Enter title: ");
		
		store.seeDetailsAndAskAddMedia(title, cart);
		storeAction();
	}
	
	public static void storeAdd() {
		store.print("");
		String title = readInputString("Enter title: ");
		store.addMediaToCart(title, cart);
		storeAction();
	}
	
	public static void storePlay() {
		store.print("");
		String title = readInputString("Enter title: ");
		store.playAMedia(title);
		storeAction();
	}
	
	// UPDATE
	public static void updateAction() {
		store.print("");
		
		System.out.println("1. Add a Book to store");
		System.out.println("2. Add a DVD to store");
		System.out.println("3. Add a CD to store");
		System.out.println("4. Remove a Media from store");
		System.out.println("0. Back");
		
		int inp = readInputInt(4);
		
		if (inp == 0) showAction();
		if (inp == 1) updateAddBook();
		if (inp == 2) updateAddDVD();
		if (inp == 3) updateAddCD();
		if (inp == 4) {
			String title = readInputString("Enter title: ");
			store.removeMedia(title);
			updateAction();
		}
		
	}
		
	public static void updateAddDVD() {
		String title = readInputString("Enter title: ");
		String category = readInputString("Enter category: ");
		String director = readInputString("Enter director: ");
		
		Scanner scanner = new Scanner(System.in); 
		
		System.out.print("Enter length (int) (exception not handled): ");
		int length = scanner.nextInt();
		System.out.print("Enter cost (float) (exception not handled): ");
		float cost = scanner.nextFloat();
		
		
		DigitalVideoDisc dvd = new DigitalVideoDisc(
				title, category, director, length, cost);
		store.addMedia(dvd);
		
		updateAction();
	}
	
	public static void updateAddBook() {
		String title = readInputString("Enter title: ");
		String category = readInputString("Enter category: ");
		
		Scanner scanner = new Scanner(System.in); 
		
		System.out.print("Enter cost (float) (exception not handled): ");
		float cost = scanner.nextFloat();
		
		Book book = new Book(title, category, cost);
		
		System.out.print("Number of author(s) (int) (exception not handled): ");
		int authorCount = scanner.nextInt();
		for (int i = 1; i <= authorCount; i++) {
			book.addAuthor(readInputString("Enter name author #" + i + ": "));
		}
		
		store.addMedia(book);
		
		updateAction();
	}

	public static void updateAddCD() {
		String title = readInputString("Enter title: ");
		String category = readInputString("Enter category: ");
		String director = readInputString("Enter director: ");
		String artist = readInputString("Enter artist: ");
		
		Scanner scanner = new Scanner(System.in); 
		
		System.out.print("Enter cost (float) (exception not handled): ");
		float cost = scanner.nextFloat();

		CompactDisc cd = new CompactDisc(title, category, cost, director, artist);
		
		String trackTitle;
		int trackLength;
		System.out.print("Number of track(s) (int) (exception not handled): ");
		int trackCount = scanner.nextInt();
		for (int i = 1; i <= trackCount; i++) {
			trackTitle = readInputString("Enter track title #" + i + ": ");
			System.out.print("Enter track length (int) (exception not handled): ");
			trackLength = scanner.nextInt();
			cd.addTrack(new Track(trackTitle, trackLength));
		}
		
		store.addMedia(cd);
		
		updateAction();
	}
	
	// CART
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter Medias in cart");
		System.out.println("2. Sort Medias in cart");
		System.out.println("3. Remove Media from cart");
		System.out.println("4. Place order");
		System.out.println("5. Play a Media in cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void cartAction() {
		cart.print();
		cartMenu();
		int inp = readInputInt(5);
		
		if (inp == 0) showAction();
		if (inp == 1) cartFilter();
		if (inp == 2) cartSort();
		if (inp == 3) cartRemove();
		if (inp == 4) cartOrder();
		if (inp == 5) cartPlay();
	}
	
	public static void cartFilter() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Filter by? 0. ID / 1. Title (exception not handled)");
		int inp = readInputInt(1);
		if (inp == 0) {
			System.out.print("Enter ID (int) (exception not handled): ");
			int id = scanner.nextInt();
			cart.search(id);
			cartAction();
		} else {
			String title = readInputString("Enter title: ");
			cart.search(title);
			cartAction();
		}
	}
	
	public static void cartSort() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Sort by? 0. Title / 1. Cost (exception not handled)");
		int inp = readInputInt(1);
		if (inp == 0) {
			cart.sortByTitleCostAndPrint();
		} else {
			cart.sortByCostTitleAndPrint();
		}
		cartAction();
	}
	
	public static void cartRemove() {
		String title = readInputString("Enter title: ");
		cart.removeMedia(title);
		cartAction();
	}
	
	
	public static void cartOrder() {
		System.out.println("An order is created");
		cart.order();
		cartAction();
	}
	
	public static void cartPlay() {
		store.print("");
		String title = readInputString("Enter title: ");
		store.playAMedia(title);
		cartAction();
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
