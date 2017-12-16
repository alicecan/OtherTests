import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class DiffTool extends JFrame {
	private UsagePanel usagePanel;
	private ComparisonPanel compPanel;
	private ResultPanel resPanel;
	
	public DiffTool() throws IOException {
		// create a BorderLayout manager
		setLayout(new BorderLayout());
		
		// initialize panels
		usagePanel = new UsagePanel();
		compPanel = new ComparisonPanel();
		//resPanel = new ResultPanel();
		
		// add the panels to the content pane
		add(usagePanel, BorderLayout.NORTH);
		add(compPanel, BorderLayout.CENTER);	
		//add(resPanel, BorderLayout.SOUTH);
		
		// set frame properties
		setTitle("JSON Diff Tool");
		//pack();
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DiffTool frame = new DiffTool();
	}

}
