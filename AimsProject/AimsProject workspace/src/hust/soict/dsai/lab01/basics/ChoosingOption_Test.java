package hust.soict.dsai.lab01.basics;

import javax.swing.JOptionPane;

public class ChoosingOption_Test {
    public static void main(String[] args) {
    	String[] options = {"I do", "I don't", "Never mind"};
        int option = JOptionPane.showOptionDialog(
        		null,
        		"Do you want to change to the first class ticket?",
        		"Change ticket?",
        		JOptionPane.YES_NO_CANCEL_OPTION, 
        		JOptionPane.QUESTION_MESSAGE,
        		null,
        		options,
        		options[2]);
        JOptionPane.showMessageDialog(null, "You've chosen: " 
        		+ (option == JOptionPane.YES_OPTION ? "Yes" : "No"));     
        System.exit(0);
    }
}