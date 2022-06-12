package hust.soict.dsai.aims.utils;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.Media;

public class MediaUtils {
	public static void sortByCostTitle(ArrayList<Media> mediaArrayList) {
		Collections.sort(mediaArrayList, Media.COMPARE_BY_COST_TITLE);
	}
	
	public static void sortByTitleCost(ArrayList<Media> mediaArrayList) {
		Collections.sort(mediaArrayList, Media.COMPARE_BY_TITLE_COST);
	}
	
	
}