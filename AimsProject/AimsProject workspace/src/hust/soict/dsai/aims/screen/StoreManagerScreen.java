package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

@SuppressWarnings("serial")
public class StoreManagerScreen extends JFrame {
	private Store store;
	StoreManagerScreen thisFrame = this;
	
	public static void main(String[] args) {
		new StoreManagerScreen(new Store());
	}
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
		
		// TODO
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenuItem viewStoreItem = new JMenuItem("View store");
		viewStoreItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		menu.add(viewStoreItem);
		
		JMenu smUpdateStore = new JMenu("Update Store");
		AddMediaActionListener addMediaActionListener = new AddMediaActionListener();
		
		JMenuItem addBookItem = new JMenuItem("Add Book");
		addBookItem.addActionListener(addMediaActionListener);
		smUpdateStore.add(addBookItem);
		
		JMenuItem addCDItem = new JMenuItem("Add CD");
		addCDItem.addActionListener(addMediaActionListener);
		smUpdateStore.add(addCDItem);
		
		JMenuItem addDVDItem = new JMenuItem("Add DVD");
		addDVDItem.addActionListener(addMediaActionListener);
		smUpdateStore.add(addDVDItem);
		
		JMenuItem addSampleMediaeItem = new JMenuItem("Add sample Mediae");
		addSampleMediaeItem.addActionListener(addMediaActionListener);
		smUpdateStore.add(addSampleMediaeItem);
		
		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < Math.min(9, mediaInStore.size()); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	private void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	public void refresh() {
		close();
		new StoreManagerScreen(store);
	}

	public Store getStore() {
		return store;
	}
	
	private void addSampleMediae() {
		store.addMedia(new Book("The Book A", "The Category BookA", 3.2f));
		store.addMedia(new Book("The Book B", "The Category BookB", 1.4f));
		store.addMedia(new Book("The Book C", "The Category BookC", 1.2f));
		store.addMedia(new DigitalVideoDisc(
				"The DVD A", "The Category DVDA", "The Director DVDA", 6, 15f));
		store.addMedia(new DigitalVideoDisc(
				"The DVD B", "The Category DVDB", "The Director DVDB", 9, 12.8f));
		store.addMedia(new DigitalVideoDisc(
				"The DVD C", "The Category DVDC", "The Director DVDC", 14, 2.1f));
		store.addMedia(new CompactDisc(
				"The CD A", "The Category CDA", 2.3f, "The Director CDA", "The Artist CDA"));
		store.addMedia(new CompactDisc(
				"The CD B", "The Category CDB", 6.9f, "The Director CDB", "The Artist CDB"));
		store.addMedia(new CompactDisc(
				"The CD C", "The Category CDC", 5.5f, "The Director CDC", "The Artist CDC"));
		refresh();
	}
	
	private class AddMediaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if (button.equals("Add Book"))
				new AddBookToStoreScreen(thisFrame);
			else if (button.equals("Add DVD"))
				new AddDigitalVideoDiscToStoreScreen(thisFrame);
			else if (button.equals("Add CD"))
				new AddCompactDiscToStoreScreen(thisFrame);
			else 
				addSampleMediae();
		}
	}
}
