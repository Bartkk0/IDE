import java.awt.*;
import java.awt.event.*;	// ActionListener
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.*;
public class ToolBar extends JToolBar {
// wersja 1 klasy kontenera - z dziedziczeniem kontenera ogólnego
	JButton btnM0, btnM1, btn1, btn2, btn3, btn4, btn5;
	private Path dir;

	DarkMode dark = new DarkMode();

	ToolBar(JMenuBar mb){
		JToolBar tlb = this;

//		tlb.setBackground(dark.GetConstrain("BG_COLOR"));
//		tlb.setForeground(dark.GetConstrain("FG_COLOR"));

		btnM0 = new JButton("\u2630");	// zarządzać Paskiem menu
		btnM0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				mb.setVisible(!mb.isVisible());
			}
		});
		btnM1 = new JButton("\u2756");	// undocking Panelu narzędzi
		btnM1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tlb.setFloatable(!tlb.isFloatable());
			}
		});
		btn1 = new JButton("Otwórz");
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(PickDirectory())
					OpenDirectory();
			}
		});
		btn2 = new JButton("Zapisz");
		btn3 = new JButton("Kopiuj");
		btn4 = new JButton("Wklej");
		btn5 = new JButton();
//		btn5.setIcon(new ImageIcon("Icon-Search.png"));
		// deklarowanie Paska narzędziowego
		this.setFloatable(false);	// blokuje przeciąganie panelu
		this.setRollover(true); 	// ustawia efekt po najechaniu przycisku przez kursor
		this.add(btnM0);
		this.add(btnM1);
		this.add(btn1);
		this.add(btn2);
		this.addSeparator();
		this.add(btn3);
		this.add(btn4);
		add(btn5);
		// elementem zwracanym przez klasę będzie kontener JToolBar
	}

	private void OpenDirectory() {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
			for (Path file: stream){
				System.out.println(file.toString());
				LeftSide.data.addElement(file.getFileName().toString());
			}
		}
		catch (IOException | DirectoryIteratorException e){

		}
	}

	private boolean PickDirectory() {
		JFileChooser pick = new JFileChooser();
		pick.setCurrentDirectory(new File("."));
		pick.setDialogTitle(Localisation.GetString("CHOOSE_DIR"));
		pick.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		pick.setAcceptAllFileFilterUsed(false);
		if(pick.showDialog(this, "Tak") == JFileChooser.APPROVE_OPTION){
			this.dir = pick.getCurrentDirectory().toPath();
			return true;
		}
		else{

		}
		return false;
	}
}
