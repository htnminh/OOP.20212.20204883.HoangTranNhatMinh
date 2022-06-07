package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	
	// constructors
	public DigitalVideoDisc(String title) {
		super(title, "", 0f, 0, "");
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost, 0, "");
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost, 0, director);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost, length, director);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost, int id) {
		super(title, category, cost, length, director);
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	// toString
	@Override
	public String toString() {
		return String.format("%s. DVD - %s - %s - %s - %s: %s $",
				id, title, category, director, length, cost);
	}
	
	// swap
	public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String title1 = dvd1.getTitle();
		dvd1.setTitle(dvd2.getTitle());
		dvd2.setTitle(title1);
		
		String category1 = dvd1.getCategory();
		dvd1.setCategory(dvd2.getCategory());
		dvd2.setCategory(category1);
		
		String director1 = dvd1.getDirector();
		dvd1.setDirector(dvd2.getDirector());
		dvd2.setDirector(director1);
		
		int length1 = dvd1.getLength();
		dvd1.setLength(dvd2.getLength());
		dvd2.setLength(length1);
		
		float cost1 = dvd1.getCost();
		dvd1.setCost(dvd2.getCost());
		dvd2.setCost(cost1);
	}
}
