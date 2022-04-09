import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String notification = "You've just entered: ";

        String num1 = JOptionPane.showInputDialog(
            null,
            "Please input the first number: ",
            "Input the first number",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
