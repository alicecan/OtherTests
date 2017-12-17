import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ComparisonPanel extends JPanel {
	private JScrollPane file1;
	private JScrollPane file2;
	private static JTextArea leftArea;
	private static JTextArea rightArea;
	
	public ComparisonPanel() {
		leftArea = new JTextArea(40,100);
		file1 = new JScrollPane(leftArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		rightArea = new JTextArea(40,100);
		file2 = new JScrollPane(rightArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		setBorder(BorderFactory.createTitledBorder("Files"));

		setLayout(new GridLayout(1, 2));
		add(file1);
		add(file2);
	}

    public static String convertStreamToString(InputStream is) {
    	// beginning of the input boundary
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
    
	public static String convertJSON(String filename) throws FileNotFoundException {
		FileInputStream in = new FileInputStream(new File(filename));
		String data = convertStreamToString(in);
        Gson gson = new GsonBuilder().create();
        Mapper p = gson.fromJson(data, Mapper.class);
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (p != null) {
        	int docNum = p.response.docs.length;
        	for (int i=0; i<docNum; i++) {
        		sb.append("doc[" + i + "]:\n");
        		sb.append("\tweb_url:" + p.response.docs[i].web_url + "\n");
        		sb.append("\tsnippet: " + p.response.docs[i].snippet + "\n");
        		sb.append("\tlead_paragraph: " + p.response.docs[i].lead_paragraph + "\n");
        		sb.append("\tprint_page: " + p.response.docs[i].print_page + "\n");
        		sb.append("\tblog: " + p.response.docs[i].blog + "\n");
        		sb.append("\tsource: " + p.response.docs[i].source + "\n");
        		sb.append("\tmultimedia: " + p.response.docs[i].multimedia + "\n");
        		sb.append("\theadline: " + p.response.docs[i].headline + "\n");
        		sb.append("\tkeywords: " + p.response.docs[i].keywords + "\n");
        		sb.append("\tpub_date: " + p.response.docs[i].pub_date + "\n");
        		sb.append("\tdocument_type: " + p.response.docs[i].document_type + "\n");
        		sb.append("\tnews_desk: " + p.response.docs[i].news_desk + "\n");
        		sb.append("\tsection_name: " + p.response.docs[i].section_name + "\n");
        		sb.append("\tsubsection_name: " + p.response.docs[i].subsection_name + "\n");
        		sb.append("\tbyline: " + p.response.docs[i].byline + "\n");
        		sb.append("\ttype_of_material: " + p.response.docs[i].type_of_material + "\n");
        		sb.append("\t_id: " + p.response.docs[i]._id + "\n");
        		sb.append("\tword_count: " + p.response.docs[i].word_count + "\n");
        		sb.append("\tslideshow_credits: " + p.response.docs[i].slideshow_credits + "\n");
        		sb.append("\tscore: " + p.response.docs[i].score + "\n");
        	}
        }
        
        return sb.toString();
	}
	
	public static void showFile(String filename1, String filename2) throws IOException {
		String leftData = convertJSON(filename1);
		String rightData = convertJSON(filename2);
		/*
		StringBuilder sb = new StringBuilder();

		List<String> list = new ArrayList<>();
		FileInputStream in = null;
		try {
			in = new FileInputStream(filename);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			int i = 0;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				list.add(line + "\n");
			}
		} catch (IOException ex) {
			ResultPanel.display(filename + " is not found.");
		} finally {
			if (in != null) {
				in.close();
			}
		}
		
		String[] data2 = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };
		
		DefaultListModel model = new DefaultListModel();
		//jList1 = new JList(model);
		/*for (int i=0; i<list.size(); i++)
			model.addElement(list.get(0));
		leftList.setModel(model);*/
		//String newLine = sb.toString().replace("{", "{\n").replace("}", "}\n");*/
		leftArea.setText(leftData);
		rightArea.setText(rightData);
		
		//ResultPanel.display(sb.toString());
	}
}
