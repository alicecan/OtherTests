import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ComparisonPanel extends JPanel {
	private static JScrollPane leftPane;
	private static JScrollPane rightPane;
	private static JTextArea leftArea;
	private static JTextArea rightArea;

	public ComparisonPanel() {
		leftArea = new JTextArea(40, 100);
		leftPane = new JScrollPane(leftArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		rightArea = new JTextArea(40, 100);
		rightPane = new JScrollPane(rightArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		setBorder(BorderFactory.createTitledBorder("Files"));

		setLayout(new GridLayout(1, 2));
		add(leftPane);
		add(rightPane);
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
			for (int i = 0; i < docNum; i++) {
				sb.append("doc[" + i + "]:\n");
				sb.append("\tweb_url:" + p.response.docs[i].web_url + "\n");
				sb.append("\tsnippet: " + p.response.docs[i].snippet + "\n");
				sb.append("\tlead_paragraph: " + p.response.docs[i].lead_paragraph + "\n");
				sb.append("\tprint_page: " + p.response.docs[i].print_page + "\n");
				if (p.response.docs[i].blog != null && p.response.docs[i].blog.length != 0) {
				} else {
					sb.append("\tblog: []\n");
				}
				sb.append("\tsource: " + p.response.docs[i].source + "\n");
				if (p.response.docs[i].multimedia != null) {
					sb.append("\tmultimedia:\n");
					for (Multimedia m : p.response.docs[i].multimedia) {
						sb.append("\t\twidth: " + m.width + "\n");
						sb.append("\t\turl: " + m.url + "\n");
						sb.append("\t\theight: " + m.height + "\n");
						sb.append("\t\tsubtype: " + m.subtype + "\n");
						if (m.legacy != null) {
							Legacy l = m.legacy;
							sb.append("\t\tlegacy:\n");
							sb.append("\t\t\txlargewidth: " + l.xlargewidth + "\n");
							sb.append("\t\t\txlarge: " + l.xlarge + "\n");
							sb.append("\t\t\txlargeheight: " + l.xlargeheight + "\n");
						}
						sb.append("\t\ttype: " + m.type + "\n\n");
					}
				} else {
					sb.append("\tmultimedia: null\n");
				}
				if (p.response.docs[i].headline != null) {
					sb.append("\theadline:\n");
					sb.append("\t\tmain: " + p.response.docs[i].headline.main + "\n");
					sb.append("\t\tprint_headline: " + p.response.docs[i].headline.print_headline + "\n");
				}
				if (p.response.docs[i].keywords != null) {
					sb.append("\tkeywords:\n");
					for (Keyword k : p.response.docs[i].keywords) {
						sb.append("\t\trank: " + k.rank + "\n");
						sb.append("\t\tis_major: " + k.is_major + "\n");
						sb.append("\t\tname: " + k.name + "\n");
						sb.append("\t\tvalue: " + k.value + "\n\n");
					}
				}
				sb.append("\tpub_date: " + p.response.docs[i].pub_date + "\n");
				sb.append("\tdocument_type: " + p.response.docs[i].document_type + "\n");
				sb.append("\tnews_desk: " + p.response.docs[i].news_desk + "\n");
				sb.append("\tsection_name: " + p.response.docs[i].section_name + "\n");
				sb.append("\tsubsection_name: " + p.response.docs[i].subsection_name + "\n");
				if (p.response.docs[i].byline != null) {
					sb.append("\tbyline:\n");
					if (p.response.docs[i].byline.person != null && p.response.docs[i].byline.person.length != 0) {
						for (Person per : p.response.docs[i].byline.person) {
							sb.append("\t\torganization: " + per.organization + "\n");
							sb.append("\t\trole: " + per.role + "\n");
							sb.append("\t\tfirstname: " + per.firstname + "\n");
							sb.append("\t\trank: " + per.rank + "\n");
							sb.append("\t\tlastname: " + per.lastname + "\n\n");
						}
					}
					sb.append("\toriginal: " + p.response.docs[i].byline.original + "\n");
					sb.append("\torganization: " + p.response.docs[i].byline.organization + "\n");
				}
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

		leftArea.setText(leftData);
		rightArea.setText(rightData);
	}
}
