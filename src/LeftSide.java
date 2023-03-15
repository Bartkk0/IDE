import java.awt.*;
import java.awt.event.*;	// ActionListener
import javax.swing.*;
import javax.swing.event.*;	// ListSelectionListener
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class LeftSide extends JPanel implements ListSelectionListener {
	static DefaultListModel data;
	JList lst;
	JTextArea txa;

	LeftSide(DefaultListModel data2, JList lst2, JTextArea txa){
	//	this.data = data;
	//	this.lst = lst;
		this.txa = txa;
		data = new DefaultListModel();
		data.addElement("plik1.txt");
		data.addElement("plik2.txt");
		data.addElement("dokument5.txt");
		data.addElement("lista7.csv");
		lst = new JList(data);
		lst.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		lst.setLayoutOrientation(JList.VERTICAL);
		lst.setSelectedIndex(0);
		lst.setVisibleRowCount(5);
		lst.addListSelectionListener(this);
		JScrollPane lstScr = new JScrollPane(lst);
		add(lstScr);
	}

	private String openFile(String name){
		String content = "";
		try {
			File file = new File(name);
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()){
				content+= scan.nextLine();
				content+= "\n";
			}
			scan.close();
		} catch(FileNotFoundException e){
			// plik nie istnieje
		}
		return content;
	}

	public void valueChanged(ListSelectionEvent e){
		Object src = e.getSource();
		if( src == lst ){
			if( e.getValueIsAdjusting() == false ){
				if( lst.getSelectedIndex() != -1 ){
				//	pnl.setBackground(Color.RED);
				//} else {
					String fileName = data.getElementAt(lst.getSelectedIndex()).toString();
					String content = openFile(fileName);
					txa.setText(content);
				}
			}
		}
	}

}
