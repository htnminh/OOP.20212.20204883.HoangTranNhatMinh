package hust.soict.dsai.aims.utils;
import java.util.Arrays;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;


public class DVDUtils {
	public static int compareByCost(
			DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		DigitalVideoDiscCostDescTitleComparable dvdC1
			= new DigitalVideoDiscCostDescTitleComparable(dvd1);
		DigitalVideoDiscCostDescTitleComparable dvdC2
			= new DigitalVideoDiscCostDescTitleComparable(dvd2);
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
		DigitalVideoDiscCostDescTitleComparable[] dvdCArray
			= new DigitalVideoDiscCostDescTitleComparable[length];
		for (int i = 0; i < length; i++) {
			dvdCArray[i] = new DigitalVideoDiscCostDescTitleComparable(dvdArray[i]);
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
	public static DigitalVideoDisc[] sortByAttr(DigitalVideoDisc[] dvdArray) {
		int length = dvdArray.length;
		DigitalVideoDiscAttrComparable[] dvdAArray
			= new DigitalVideoDiscAttrComparable[length];
		for (int i = 0; i < length; i++) {
			dvdAArray[i] = new DigitalVideoDiscAttrComparable(dvdArray[i]);
		}
		Arrays.sort(dvdAArray);
		return dvdAArray;
	}
	
}

class DigitalVideoDiscCostDescTitleComparable
		extends DigitalVideoDisc
		implements java.lang.Comparable<DigitalVideoDiscCostDescTitleComparable> {

	public DigitalVideoDiscCostDescTitleComparable(DigitalVideoDisc dvd) {
		super(dvd.getTitle(), dvd.getCategory(), dvd.getDirector(), dvd.getLength(), dvd.getCost(), dvd.getId());
	}
	
	@Override
	public int compareTo(DigitalVideoDiscCostDescTitleComparable other) {
		int costCompare = Float.compare(this.getCost(), other.getCost()) * -1;
		if (costCompare != 0)
			return costCompare;
		return this.getTitle().compareTo(other.getTitle());
	}
}


class DigitalVideoDiscTitleComparable
		extends DigitalVideoDisc
		implements java.lang.Comparable<DigitalVideoDiscTitleComparable> {

	public DigitalVideoDiscTitleComparable(DigitalVideoDisc dvd) {
		super(dvd.getTitle(), dvd.getCategory(), dvd.getDirector(), dvd.getLength(), dvd.getCost(), dvd.getId());
	}
	
	@Override
	public int compareTo(DigitalVideoDiscTitleComparable other) {
		return this.getTitle().compareTo(other.getTitle());
	}
}


class DigitalVideoDiscAttrComparable
		extends DigitalVideoDisc
		implements java.lang.Comparable<DigitalVideoDiscAttrComparable> {
	
	public DigitalVideoDiscAttrComparable(DigitalVideoDisc dvd) {
		super(dvd.getTitle(), dvd.getCategory(), dvd.getDirector(), dvd.getLength(), dvd.getCost(), dvd.getId());
	}
	
	@Override
	public int compareTo(DigitalVideoDiscAttrComparable other) {
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

