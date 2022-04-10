import java.util.Scanner;
import java.util.InputMismatchException;

public class DaysOfMonth {
	static int readMonth(String input) {
		String[] MONTH_NAMES = {
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December"
		};
		
		for (int i = 0; i < 12; i++) {
			String fullName = MONTH_NAMES[i];
			String threeLetterName = fullName.substring(0, 3);
			String abbr = threeLetterName + ".";
			String strNum = Integer.toString(i+1);
			
			if (input.equals(fullName) || input.equals(threeLetterName) ||
					input.equals(abbr) || input.equals(strNum)) {
				return i+1;
			};
		}
		
		return -1;
	}
	
	public static int readYear(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
	public static boolean leapYear(int year) {
		if (year % 4 != 0) return false;
		if (year % 400 == 0) return true;
		if (year % 100 == 0) return false;  // not divisible by 400
		return true;
	}
	
	public static int daysOfMonthInYear(int month, boolean leap) {
		int[] DAYS_OF_MONTHS_COMMON = {
				31,
				28,
				31,
				30,
				31,
				30,
				31,
				31,
				30,
				31,
				30,
				31};
		if (month == 2 && leap) {
			return 29;
		} else return DAYS_OF_MONTHS_COMMON[month - 1];
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String inputMonth;
		int month;
		
		while (true) {
			System.out.print("Input month: ");
			inputMonth = keyboard.nextLine();
			
			month = DaysOfMonth.readMonth(inputMonth);
			if (month != -1) break;
		}
		
		String inputYear;
		int year;
		
		while (true) {
			System.out.print("Input year: ");
			inputYear = keyboard.nextLine();
			
			year = DaysOfMonth.readYear(inputYear);
			if (year >= 0) break;
		};
		
		keyboard.close();
		
		boolean leap = DaysOfMonth.leapYear(year);
		System.out.println(
				"Month " + month + " of year " + year +
				" has "
				+ DaysOfMonth.daysOfMonthInYear(month, leap)
				+ " days.");
		
	}
}
