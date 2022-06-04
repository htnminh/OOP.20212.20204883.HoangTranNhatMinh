package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public abstract class Media {
	private static int nbMedia = 0;
	private int id;
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded;
	
	public static int getNbMedia() {
		return nbMedia;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	public Media() {
		// TODO Auto-generated constructor stub
	}

		
}
