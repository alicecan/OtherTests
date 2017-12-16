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
		textArea = new JTextArea(10, 50);
		scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.getViewport().setViewPosition(new Point(0,0));
		
		setBorder(BorderFactory.createTitledBorder("Comparison Results"));
		
		add(scroll);
	}

	public static void display(String text) {
		textArea.setText(text + "\n");
		/*
		 * String[] tokens = text.split(" "); if (tokens.length != 3 ||
		 * !tokens[0].equals("diff")) {
		 * textArea.setText("Please enter: \"diff file1.json file2.json\""); }
		 * else { textArea.setText(text); }
		 */
	}
}
