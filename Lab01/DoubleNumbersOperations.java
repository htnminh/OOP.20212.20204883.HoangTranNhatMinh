import java.util.Scanner;

public class DoubleNumbersOperations {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Input the first number: ");
        String strNum1 = keyboard.nextLine();
        System.out.print("Input the second number: ");
        String strNum2 = keyboard.nextLine();

        try {
            double num1 = Double.parseDouble(strNum1);
            double num2 = Double.parseDouble(strNum2);

            System.out.println(String.format("%f + %f = %f", num1, num2, num1+num2));
            System.out.println(String.format("%f - %f = %f", num1, num2, num1-num2));
            System.out.println(String.format("%f * %f = %f", num1, num2, num1*num2));

            if (num2 != 0) {
                System.out.println(String.format("%f / %f = %f", num1, num2, num1/num2));
            } else {
                System.out.println("Not divisible by 0");
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        keyboard.close();
    }
}