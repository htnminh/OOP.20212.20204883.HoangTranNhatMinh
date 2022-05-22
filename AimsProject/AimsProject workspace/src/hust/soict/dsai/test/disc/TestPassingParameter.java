package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungleDVD title: " + jungleDVD.getTitle());
		System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungleDVD title: " + jungleDVD.getTitle());
	}
	
	/*
	public static void swap(Object o1, Object o2) {
		// of course it doesn't work
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	*/
	
	public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		// this solution only works with DigitalVideoDisc
		/* As I understand, there is no way to write a method of the form
		 * swap(Object o1, Object o2)
		 * since Java just pass the value of references,
		 * so it doesn't modify the references after running the method.
		 */
		DigitalVideoDisc.swap(dvd1, dvd2);
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);  // ?
	}
}


