import java.awt.*;
import java.awt.event.*;	// ActionListener
import javax.swing.*;
public class MainMenu extends JMenuBar implements ActionListener {


// wersja 1 klasy kontenera - z dziedziczeniem kontenera ogólnego
	JFrame box;
	JPanel pnl;
	JMenu menu, submenu;
	JMenuItem mi1, mi2, mi3, mi4, mi5, mi6;

	MainMenu(JFrame box, JPanel pnl){
		this.box = box;
		this.pnl = pnl;
		menu  = new JMenu(Localisation.GetString("MENU_FILE"));
		menu.setMnemonic(KeyEvent.VK_P);
		submenu  = new JMenu("TESTMenu1");
		mi1 = new JMenuItem(Localisation.GetString("MENU_FILE_NEW"));
		mi2 = new JMenuItem(Localisation.GetString("MENU_FILE_OPEN"));
		mi3 = new JMenuItem(Localisation.GetString("MENU_FILE_CONF"));
		mi4 = new JMenuItem("Opcja 4");
		mi5 = new JMenuItem("Opcja 5");
		mi6 = new JMenuItem(Localisation.GetString("MENU_FILE_QUIT"));
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);
		menu.add(mi1);
		menu.add(mi2);
		menu.add(mi3);
		submenu.add(mi4);
		submenu.add(mi5);
		menu.add(submenu);
		menu.add(mi6);
		this.add(menu);	// elementem zwracanym przez klasę będzie kontener
		// JPanel, do którego dodawane są Komponenty
	}

	public void actionPerformed(ActionEvent e){
		Object src = e.getSource();
		if( src == mi1 )
			pnl.setBackground(Color.RED);
		if( src == mi2 )
			pnl.setBackground(Color.GREEN);
		if( src == mi3 ) {
			pnl.setBackground(Color.BLUE);
			App.LOGGER.info("preferencje");
			new AppSettings();
		}
		if( src == mi4 )
			pnl.setBackground(Color.WHITE);
		if( src == mi6 )
			box.dispose();	// kończy / zamyka aplikację
	}

}
