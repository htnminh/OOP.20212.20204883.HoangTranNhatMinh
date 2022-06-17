package hust.soict.dsai.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

@SuppressWarnings("serial")
public class LookAndFeelDemo extends JFrame {
	public static void main(String[] args) {
		new LookAndFeelDemo();
	}
	
	public LookAndFeelDemo() {
		addDemoComponents();
		addLookAndFeelComboBox();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380, 100);
		setVisible(true);
	}
	
	void addDemoComponents() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Label:"));
		cp.add(new JTextField("Text field"));
		cp.add(new JRadioButton("Radio button"));
		cp.add(new JButton("Button"));
	}
	
	void addLookAndFeelComboBox() {
		Container cp = getContentPane();
		cp.add(new JLabel("Change Look and Feel here: "));
		
		LookAndFeelInfo lafInfos[] = UIManager.getInstalledLookAndFeels();
		String lafNames[] = new String[lafInfos.length + 2];
		for (int i = 0; i < lafInfos.length; i++)
			lafNames[i] = lafInfos[i].getName();
		
		lafNames[lafInfos.length] = "Java";
		lafNames[lafInfos.length + 1] = "System";
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox cbLookAndFeel = new JComboBox(lafNames);
		cp.add(cbLookAndFeel);
		
		JFrame frame = this;
		cbLookAndFeel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				int index = cbLookAndFeel.getSelectedIndex();
				
				if (index < lafInfos.length) {
					try {
						UIManager.setLookAndFeel(lafInfos[index].getClassName());
					} catch (Exception e) {
						e.printStackTrace();
					}
					SwingUtilities.updateComponentTreeUI(frame);
					setTitle(lafInfos[index].getName() + " Look and Feel");
				} else {
					try {
						switch (lafNames[index]) {
						case "Java":
							UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
							break;
						case "System":
							UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						default:
							break;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					SwingUtilities.updateComponentTreeUI(frame);
					setTitle(lafNames[index] + " Look and Feel");

				}
				
								
			}
		});
		
		
	}
}
