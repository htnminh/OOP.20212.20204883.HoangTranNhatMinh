package hust.soict.dsai.aims.utils;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media> {
	@Override
	public int compare(Media o1, Media o2) {
		return Comparator.comparing(Media::getCost, Comparator.reverseOrder())
				.thenComparing(Media::getTitle)
				.compare(o1, o2);
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
