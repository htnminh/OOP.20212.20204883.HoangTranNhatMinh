package hust.soict.dsai.lab01.scripts;

import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog(
            null,
            "Please input the first number: ",
            "Input the first number",
            JOptionPane.INFORMATION_MESSAGE
        );
        String strNum2 = JOptionPane.showInputDialog(
            null,
            "Please input the second number: ",
            "Input the second number",
            JOptionPane.INFORMATION_MESSAGE
        );
        String notification = "You've just entered: " + strNum1 + " and " + strNum2;

        JOptionPane.showMessageDialog(
            null, notification,
            "Show two numbers", JOptionPane.INFORMATION_MESSAGE
        );

        System.exit(0);
    }
}
