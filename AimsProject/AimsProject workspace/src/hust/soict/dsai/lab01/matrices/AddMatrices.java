package hust.soict.dsai.lab01.matrices;

import java.util.Arrays;

public class AddMatrices {
	public static void main(String[] args) {
		double[][] a = {{1, 2}, {3, 4}};
		double[][] b = {{1, 1.1}, {5.2, 5.3}};
		
		int size = a.length;
				
		double[][] result = new double[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}
		
		System.out.println(Arrays.deepToString(result));	
 	}
}
