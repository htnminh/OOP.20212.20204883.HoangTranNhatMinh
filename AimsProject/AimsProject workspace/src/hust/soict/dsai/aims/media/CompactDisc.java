package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title, String category, float cost,
						String director, String artist) {
		super(title, category, cost, 0, director);
		updateLength();
		this.artist = artist;
	}
	
	@Override
	public String toString() {
		return String.format("%s. CD - %s - %s - %s - %s - %s: %s $",
				id, title, category, director, length, artist, cost);
	}
	public String tracksString() {
		// solution found here:
		// https://stackoverflow.com/questions/599161/best-way-to-convert-an-arraylist-to-a-string
		return tracks.stream().map(Object::toString)
								.collect(Collectors.joining(", "));
	}
	
	public void play() {
		System.out.println("Playing: CD " + title + " of " + artist);
		for (Track track: tracks) {
			track.play();
		}
	}
	
	public String getArtist() {
		return artist;
	}
	protected void setArtist(String artist) {
		this.artist = artist;
	}
	public int getLength() {
		int res = 0;
		for (Track track: tracks)
			res += track.getLength();
		return res;
	}
	private void updateLength() {
		this.length = getLength();
	}
	
	public int indexTrack(String title) {
		for (int i = 0; i < tracks.size(); i++) {
			if (title.equals(tracks.get(i).getTitle()))
				return i;
		}
		return -1;
	}
	public void addTrack(Track track) {
		if (indexTrack(track.getTitle()) == -1) {
			tracks.add(track);
			System.out.println("Added the track: " + track);
			updateLength();
		} else
			System.out.println("Cannot add track, track already exists");
	}
	public void removeTrack(Track track) {
		int i = indexTrack(track.getTitle());
		if (i != -1) {
			tracks.remove(i);
			System.out.println("Removed the track: " + track);
			updateLength();
		} else
			System.out.print("Cannot remove track, track does not exist");
	}

	
}
