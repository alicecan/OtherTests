class Headline {
	String main;
	String print_headline;
}

class Person {
	String organization;
	String role;
	String firstname;
	int rank;
	String lastname;
}

class Byline {
	Person[] person;
	String original;
	String organization;
}

class Legacy {
	String xlargewidth;
	String xlarge;
	String xlargeheight;
}

class Multimedia {
	int width;
	String url;
	int height;
	String subtype;
	Legacy legacy;
	String type;
}

class Keyword {
	String rank;
	String is_major;
	String name;
	String value;
}

class Doc {
	String web_url;
	String snippet;
	String lead_paragraph;
	String print_page;
	String[] blog;
	String source;
	Multimedia[] multimedia;
	Headline headline;
	Keyword[] keywords;
	String pub_date;
	String document_type;
	String news_desk;
	String section_name;
	String subsection_name;
	Byline byline;
	String type_of_material;
	String _id;
	String word_count;
	String slideshow_credits;
	int score;
}

class Meta {
	int hits;
	int time;
	int offset;
}
class Response {
	Doc[] docs;
	Meta meta;
}

public class Mapper {
	Response response;
}
