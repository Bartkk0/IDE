/* Classname			- AppMenu
 * Version information	- 1.2.0
 * Date					- 2021-01-07
 * Copyright notice		- Petri Grzegorz
 */
import java.awt.*;
import java.awt.event.*;	// ActionListener
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javax.swing.*;
public class App extends JFrame{
	public static final Logger LOGGER = Logger.getLogger("current.package");

	static JPanel pnl, pnl2;
	static JTextArea txa;
// ##############################
// problemem na koniec lekcji z nieładującą się zawartością plików były
// puste zmienne lst oraz data przekazywane w konstruktorze klasy LeftSide
// a było to spowodowane ostatnimi zmianami, które próbowałem wprowadzić
// do aplikacji przed zajęciami - rozwiązanie: zakomentować linie 17 i 18
// w klasie LeftSide oraz zmienić nazwy zmiennych w kostruktorze klasy
// z lst i data na lst2 i data2 (przestać ich używać)
// ##############################
	static DefaultListModel data;
	static JList lst;

	private static App INSTANCE;
	public static App getInstance(){
		return INSTANCE;
	}

	App() {
		if(INSTANCE == null){
			INSTANCE = create();
		}
	}

	private App create(){
		LOGGER.info("OS language: "+Locale.getDefault().toString());
		String lang = Settings.getSetting(Settings.APPSETTING.comboLang,"en_US");
		LOGGER.info("App language: "+lang);

		Localisation.SetLanguage(Localisation.GetLocale(lang));

		setTitle(Localisation.GetString("APP_NAME"));

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (IllegalAccessException | ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException e) {
			e.printStackTrace();
		}

	// #1 PANEL MENU
		pnl = new JPanel();
		MainMenu mb = new MainMenu(this, pnl);
	// #2 PANEL IKON
		// deklarowanie ikon
		ToolBar tlb = new ToolBar(mb);
	// #3 Lewa Lista - na 3 sposoby
		txa = new JTextArea();
		JPanel lstScr = new LeftSide(data, lst, txa);
		add(lstScr, BorderLayout.LINE_START);
	// #4 dodawanie paneli do kontenera Ramki new FlowLayout()
		pnl2 = new JPanel(new BorderLayout());
		CenterEditor ce = new CenterEditor(txa);
		Container scp = ce.get();
		pnl2.add(scp,BorderLayout.CENTER);
	//	pnl2.add(txa,BorderLayout.CENTER);
		pnl.setLayout(new BoxLayout(pnl,BoxLayout.Y_AXIS));
		mb.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnl.add(mb);
		pnl.add(tlb);
		tlb.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(pnl,BorderLayout.PAGE_START);
		add(pnl2,BorderLayout.CENTER);
	// #5 ustawienia kontenera Ramki (okna)

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				updateDimension();
				super.componentResized(e);
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				updateLocation();
				super.componentMoved(e);
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				appClosing();
				super.windowClosed(e);
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,700);

		// winCenter
		if(Settings.getSetting(Settings.APPSETTING.cbMax, false)) {
			setLocationRelativeTo(null);
		}
		// winFullScr
		if(Settings.getSetting(Settings.APPSETTING.cbCenter, false)) {
			setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		// noWinBar
		if (false) {
			setUndecorated(true);
		}
		// setsize
		if(Settings.getSetting(Settings.APPSETTING.cbSaveSize, false)) {
			int w = Settings.getSetting(Settings.WINSETTING.WINW, 600);
			int h = Settings.getSetting(Settings.WINSETTING.WINH, 700);
			setSize(w, h);
		}

		// setLoc
		if(Settings.getSetting(Settings.APPSETTING.cbSavePos, false)) {
			int x = Settings.getSetting(Settings.WINSETTING.WINX, 0);
			int y = Settings.getSetting(Settings.WINSETTING.WINY, 0);
			setLocation(x, y);
		}

		//box.setLayout(null);
		setVisible(true);

		return this;
	}

	private void appClosing(){
		LOGGER.info("Zamykanie");

		Settings.storeSettings();

		dispose();
	}

	private void updateDimension(){
		LOGGER.info(getSize().toString());
	}

	private void updateLocation(){
		LOGGER.info(getLocation().toString());
	}
}
