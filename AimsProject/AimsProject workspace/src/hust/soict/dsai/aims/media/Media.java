package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public abstract class Media {
	protected static int nbMedia = 0;
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected LocalDate dateAdded;

	public Media(String title, String category, float cost) {
		dateAdded = LocalDate.now();
		this.title = title;
		this.category = category;
		this.cost = cost;
		setNewId();
	}
	
	public boolean isMatch(String name) {
		String words[] = name.split(" ");
		for (String word: words) {
			if (title.toLowerCase().contains(word.toLowerCase()))
				return true;
		}
		return false;
	}

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
	
	public static void setNbMedia(int nbMedia) {
		Media.nbMedia = nbMedia;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public void setNewId() {
		nbMedia ++;
		id = nbMedia;
	}
}
