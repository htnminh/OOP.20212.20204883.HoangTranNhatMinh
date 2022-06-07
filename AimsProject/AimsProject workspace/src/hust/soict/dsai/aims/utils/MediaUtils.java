package hust.soict.dsai.aims.utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import hust.soict.dsai.aims.media.Media;


public class MediaUtils {
	// title, category, cost
	public static int compareByCost(Media media1, Media media2) {
		MediaCostDescendingTitleCompare mediaCostCompare1
			= new MediaCostDescendingTitleCompare(media1);
		MediaCostDescendingTitleCompare mediaCostCompare2
			= new MediaCostDescendingTitleCompare(media2);
		return mediaCostCompare1.compareTo(mediaCostCompare2);
	}
	
	public static int compareByTitle(Media media1, Media media2) {
		MediaTitleCompare mediaTitleCompare1
			= new MediaTitleCompare(media1);
		MediaTitleCompare mediaTitleCompare2
			= new MediaTitleCompare(media2);
		return mediaTitleCompare1.compareTo(mediaTitleCompare2); 
	}

	
	public static ArrayList<Media> sortByCostDescendingTitle(ArrayList<Media> mediaArrayList) {
		ArrayList<MediaCostDescendingTitleCompare> mediaTempArrayList
			= new ArrayList<MediaCostDescendingTitleCompare>();
		for (Media media: mediaArrayList) {
			mediaTempArrayList.add((MediaCostDescendingTitleCompare)media);
		}
		Collections.sort(mediaTempArrayList);
		
		ArrayList<Media> res = new ArrayList<Media>();
		for (MediaCostDescendingTitleCompare mediaTemp: mediaTempArrayList) {
			res.add((Media)mediaTemp);
		}
		return res;
	}
	
	public static ArrayList<Media> sortByTitle(ArrayList<Media> mediaArrayList) {
		ArrayList<MediaTitleCompare> mediaTempArrayList
			= new ArrayList<MediaTitleCompare>();
		for (Media media: mediaArrayList) {
			mediaTempArrayList.add((MediaTitleCompare)media);
		}
		Collections.sort(mediaTempArrayList);
		
		ArrayList<Media> res = new ArrayList<Media>();
		for (MediaTitleCompare mediaTemp: mediaTempArrayList) {
			res.add((Media)mediaTemp);
		}
		return res;
	}
	
	// sortByAttr IS DEPRECATED, SINCE THERE IS NO 
	// LENGTH OF A BOOK
	/*
	public static DigitalVideoDisc[] sortByAttr(DigitalVideoDisc[] dvdArray) {
		int length = dvdArray.length;
		DigitalVideoDiscAttrCompare[] dvdAArray
			= new DigitalVideoDiscAttrCompare[length];
		for (int i = 0; i < length; i++) {
			dvdAArray[i] = new DigitalVideoDiscAttrCompare(dvdArray[i]);
		}
		Arrays.sort(dvdAArray);
		return dvdAArray;
	}
	*/
	
}

class MediaCostDescendingTitleCompare
		extends Media
		implements java.lang.Comparable<MediaCostDescendingTitleCompare> {

	public MediaCostDescendingTitleCompare(Media media) {
		super(media.getTitle(), media.getCategory(), media.getCost());
	}
	
	@Override
	public int compareTo(MediaCostDescendingTitleCompare other) {
		int costCompare = Float.compare(this.getCost(), other.getCost()) * -1;
		if (costCompare != 0)
			return costCompare;
		return this.getTitle().compareTo(other.getTitle());
	}
	
	@Override
	public String toString() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
}


class MediaTitleCompare
		extends Media
		implements java.lang.Comparable<MediaTitleCompare> {

	public MediaTitleCompare(Media media) {
		super(media.getTitle(), media.getCategory(), media.getCost());
	}
	
	@Override
	public int compareTo(MediaTitleCompare other) {
		return this.getTitle().compareTo(other.getTitle());
	}
	
	@Override
	public String toString() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
}

// MediaAttrCompare IS DEPRECATED, SINCE THERE IS NO 
// LENGTH OF A BOOK
/*
class DigitalVideoDiscAttrCompare
		extends DigitalVideoDisc
		implements java.lang.Comparable<DigitalVideoDiscAttrCompare> {
	
	public DigitalVideoDiscAttrCompare(DigitalVideoDisc dvd) {
		super(dvd.getTitle(), dvd.getCategory(), dvd.getDirector(), dvd.getLength(), dvd.getCost(), dvd.getId());
	}
	
	@Override
	public int compareTo(DigitalVideoDiscAttrCompare other) {
		int titleCompare = this.getTitle().compareTo(other.getTitle());
		if (titleCompare != 0)
			return titleCompare;
		
		int costCompare = Float.compare(this.getCost(), other.getCost());
		if (costCompare != 0)
			return costCompare * -1;
		
		int lengthCompare = Integer.compare(this.getLength(), other.getLength());
		return lengthCompare * -1;
		

	}
}
*/
