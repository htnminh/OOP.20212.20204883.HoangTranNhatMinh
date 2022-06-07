package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title, String category, float cost,
						int length, String director, String artist) {
		super(title, category, cost, length, director);
		this.artist = artist;
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
		} else
			System.out.println("Cannot add track, track already exists");
	}
	public void removeTrack(Track track) {
		int i = indexTrack(track.getTitle());
		if (i != -1) {
			tracks.remove(i);
			System.out.println("Removed the track: " + track);
		} else
			System.out.print("Cannot remove track, track does not exist");
	}
	
	
	
}
