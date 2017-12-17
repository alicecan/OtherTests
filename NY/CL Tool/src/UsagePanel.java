import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UsagePanel extends JPanel implements ActionListener {
	public JLabel usage;
	public JTextField input;

	public UsagePanel() {
		usage = new JLabel("> Usage: diff file1 file2 (e.g. diff file1.json file2.json) : ");
		input = new JTextField("");
		input.addActionListener(this);

		setBorder(BorderFactory.createTitledBorder("Input"));

		setLayout(new GridLayout(1, 2));
		add(usage);
		add(input);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = input.getText();
		String[] tokens = command.split(" "); 
		try {
			if (tokens.length != 3 || !tokens[0].equals("diff")) {
				ResultPanel.display("Please enter: \"diff file1.json file2.json\"");
			} else {
				ResultPanel.display("");
				ComparisonPanel.showFile(tokens[1], tokens[2]);
			}
		} catch (IOException e1) {
			ResultPanel.display("Exception: " + e1.toString());
		}
	}
	
	
}
