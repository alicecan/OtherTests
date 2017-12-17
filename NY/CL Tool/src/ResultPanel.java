import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ResultPanel extends JPanel {
	private static JLabel output;
	private static JTextArea textArea;
	private static JScrollPane scroll;

	public ResultPanel() {
		textArea = new JTextArea(20, 80);
		scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.getViewport().setViewPosition(new Point(0,0));
		
		setBorder(BorderFactory.createTitledBorder("Comparison Results"));
		
		add(scroll);
	}

	public static void display(String text) {
		textArea.setText(text); 
	}
}
	
	
