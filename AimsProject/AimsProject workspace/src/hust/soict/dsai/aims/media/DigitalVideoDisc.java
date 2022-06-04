package hust.soict.dsai.aims.media;
import java.time.LocalDate;


public class DigitalVideoDisc extends Media {
	// private static int nbDigitalVideoDiscs = 0;
	
	private String director;
	private int length;
	// private LocalDate dateAdded;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public static int getNbDigitalVideoDiscs() {
		return nbMedia;
	}
	
	// constructors
	public DigitalVideoDisc(String title) {
		super();
		dateAdded = LocalDate.now();
		this.title = title;
		setNewId();
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		dateAdded = LocalDate.now();
		this.title = title;
		this.category = category;
		this.cost = cost;
		setNewId();
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		dateAdded = LocalDate.now();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		setNewId();
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		dateAdded = LocalDate.now();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		setNewId();
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost, int id) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = id;
	}
	
	// toString
	@Override
	public String toString() {
		return String.format("%s. DVD - %s - %s - %s - %s: %s $",
				id, title, category, director, length, cost);
	}
	
	private void setDirector(String director) {
		this.director = director;
	}
	private void setLength(int length) {
		this.length = length;
	}
	private void setNewId() {
		nbMedia ++;
		id = nbMedia;
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
	
	public boolean isMatch(String name) {
		String words[] = name.split(" ");
		for (String word: words) {
			if (title.toLowerCase().contains(word.toLowerCase()))
				return true;
		}
		return false;
	}
	
}
