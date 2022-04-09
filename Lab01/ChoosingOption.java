import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Change to the first class ticket?");
        JOptionPane.showMessageDialog(null, "Chose: " + (
            option == JOptionPane.YES_OPTION ? "YES" : "NO"
        ));
    }
}
