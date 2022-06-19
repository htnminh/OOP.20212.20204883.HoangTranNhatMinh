package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public void play() {
		System.out.println(getPlayString());
	}
	@Override
	public String getPlayString() {
		String res = "Playing DVD: " + this.getTitle() + "\n";
		res += "DVD length: " + this.getLength() + "\n";
		return res;
	}
	
	public String toString() {
		return title + " " + length;
	}
	
	@Override
	public boolean equals(Object o) {
		Track that = (Track)o;
		return this.title.equals(that.getTitle())
				&& (this.length == that.getLength());
	}
}
