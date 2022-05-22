package hust.soict.dsai.lab01.array;

import java.util.Arrays;

public class ArrayProgram {
	public static void main(String[] args) {
		int[] array = {1789, 2035, 1899, 1456, 2013};
		
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
		System.out.println("Sum = " + Arrays.stream(array).sum());
		System.out.println("Avg = "
				+ Arrays.stream(array).average().getAsDouble());
	}
}
