import java.awt.*;
import javax.swing.*;
public class CenterEditor
{	// wersja 2 klasy kontenera - z dedykowaną metodą do zwracania
	JTextArea txa;	// opcjonalnie
	JScrollPane scp;

	CenterEditor(JTextArea txa){
		this.txa = txa;	// opcjonalnie
		scp = new JScrollPane(txa
			, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
		);	// VERTICAL / HORIZONTAL _SCROLLBAR_ { ALWAYS | AS_NEEDED | NEVER }
		scp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
	}

	public void setText(String text){
		txa.setText(text);
	}
	public void appendText(String text){
		txa.append(text);
	}

	public Container get()
	{	// jeżeli nie rozszeżamy żadnej klasy kontenera
		// to potrzebna jest metoda do zwracania tego kontenera
		return scp;
	}

}
