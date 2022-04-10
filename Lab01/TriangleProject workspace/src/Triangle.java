import java.util.Scanner;

public class Triangle {
	public static void main (String[] args) {
		System.out.print("n = ");
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		keyboard.close();
		
		String result = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-i-1; j++)
				result += " ";
			for (int j = 0; j < 2*i+1; j++)
				result += "*";
			result += "\n";
		}
		System.out.println(result);
	}
}