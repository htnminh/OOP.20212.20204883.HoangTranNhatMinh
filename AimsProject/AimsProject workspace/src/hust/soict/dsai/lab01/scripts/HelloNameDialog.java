package hust.soict.dsai.lab01.scripts;

import javax.swing.JOptionPane;

public class HelloNameDialog {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Please enter your name:");
        JOptionPane.showMessageDialog(null, "Hi " + name + "!");
        System.exit(0);
    }
}
