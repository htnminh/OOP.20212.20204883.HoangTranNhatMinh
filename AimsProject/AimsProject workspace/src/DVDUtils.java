import java.util.Arrays;


public class DVDUtils {
	public static int compareByCost(
			DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		DigitalVideoDiscCostComparable dvdC1
			= new DigitalVideoDiscCostComparable(dvd1);
		DigitalVideoDiscCostComparable dvdC2
			= new DigitalVideoDiscCostComparable(dvd2);
		return dvdC1.compareTo(dvdC2);
	}
	
	public static int compareByTitle(
			DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		DigitalVideoDiscTitleComparable dvdC1
			= new DigitalVideoDiscTitleComparable(dvd1);
		DigitalVideoDiscTitleComparable dvdC2
			= new DigitalVideoDiscTitleComparable(dvd2);
		return dvdC1.compareTo(dvdC2); 
	}

	
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvdArray) {
		int length = dvdArray.length;
		DigitalVideoDiscCostComparable[] dvdCArray
			= new DigitalVideoDiscCostComparable[length];
		for (int i = 0; i < length; i++) {
			dvdCArray[i] = new DigitalVideoDiscCostComparable(dvdArray[i]);
		}
		Arrays.sort(dvdCArray);
		return dvdCArray;
	}
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvdArray) {
		int length = dvdArray.length;
		DigitalVideoDiscTitleComparable[] dvdTArray
			= new DigitalVideoDiscTitleComparable[length];
		for (int i = 0; i < length; i++) {
			dvdTArray[i] = new DigitalVideoDiscTitleComparable(dvdArray[i]);
		}
		Arrays.sort(dvdTArray);
		return dvdTArray;
	}
	
	
}

class DigitalVideoDiscCostComparable
		extends DigitalVideoDisc
		implements Comparable<DigitalVideoDiscCostComparable> {

	public DigitalVideoDiscCostComparable(
			String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	public DigitalVideoDiscCostComparable(DigitalVideoDisc dvd) {
		super(dvd.getTitle(), dvd.getCategory(), dvd.getDirector(), dvd.getLength(), dvd.getCost());
	}
	
	@Override
	public int compareTo(DigitalVideoDiscCostComparable other) {
		return Float.compare(this.getCost(), other.getCost());
	}
}


class DigitalVideoDiscTitleComparable
		extends DigitalVideoDisc
		implements Comparable<DigitalVideoDiscTitleComparable> {

	public DigitalVideoDiscTitleComparable(
			String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	public DigitalVideoDiscTitleComparable(DigitalVideoDisc dvd) {
		super(dvd.getTitle(), dvd.getCategory(), dvd.getDirector(), dvd.getLength(), dvd.getCost());
	}
	
	@Override
	public int compareTo(DigitalVideoDiscTitleComparable other) {
		return this.getTitle().compareTo(other.getTitle());
	}
}

