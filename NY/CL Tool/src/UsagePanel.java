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
		// TODO Auto-generated method stub
		String command = input.getText();
		try {
			ComparisonPanel.showFile("file1.json", "file2.json");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//ResultPanel.display(command);
	}
}
