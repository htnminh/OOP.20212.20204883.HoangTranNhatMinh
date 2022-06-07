package hust.soict.dsai.aims.media;

public abstract class Disc extends Media {
	protected int length;
	protected String director;
	
	public Disc(String title, String category, float cost,
				int length, String director) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}
	
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	protected void setDirector(String director) {
		this.director = director;
	}
	protected void setLength(int length) {
		this.length = length;
	}
	
}
