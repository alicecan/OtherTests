***************************************
README
***************************************

To Compile:
cd src 
javac -d ..\output -classpath ..\output -cp ..\output\gson-2.6.2.jar *.java

To run:
cd output
java -classpath .;gson-2.6.2.jar Compare file1.json file2.json


==============================
EXAMPLES:
==============================
==============================
src directory:
==============================
C:\OtherTests\NY\CL Tool2\src>dir

12/23/2017  12:03 AM    <DIR>          .
12/23/2017  12:03 AM    <DIR>          ..
12/22/2017  11:35 PM            12,217 Compare.java
12/22/2017  11:12 PM             1,129 Mapper.java
               2 File(s)         13,346 bytes
               2 Dir(s)  788,999,790,592 bytes free

==============================
output directory:
==============================
C:\OtherTests\NY\CL Tool2\output>dir

12/23/2017  12:10 AM    <DIR>          .
12/23/2017  12:10 AM    <DIR>          ..
12/23/2017  12:10 AM               278 Byline.class
12/23/2017  12:10 AM             8,524 Compare.class
12/23/2017  12:10 AM               691 Doc.class
12/16/2017  09:33 AM            14,654 file1.json
12/16/2017  09:33 AM            14,517 file2.json
12/22/2017  10:39 PM                 0 file3.json
12/22/2017  10:39 PM                 0 file4.json
12/01/2017  05:49 PM           229,650 gson-2.6.2.jar
12/23/2017  12:10 AM               249 Headline.class
12/23/2017  12:10 AM               273 Keyword.class
12/23/2017  12:10 AM               269 Legacy.class
12/23/2017  12:10 AM               218 Mapper.class
12/23/2017  12:10 AM               235 Meta.class
12/23/2017  12:10 AM               323 Multimedia.class
12/23/2017  12:10 AM               303 Person.class
12/23/2017  12:10 AM               236 Response.class
              16 File(s)        270,420 bytes
               2 Dir(s)  788,999,790,592 bytes free

			   
==============================
COMPILE:
==============================
C:\OtherTests\NY\CL Tool2\src>javac -d ..\output -classpath ..\output -cp ..\output\gson-2.6.2.jar *.java	   

==============================
RUN 1:
==============================
C:\OtherTests\NY\CL Tool2\output>java -classpath .;gson-2.6.2.jar Compare file1.json file2.json
doc[0]:
DIFFERENT FIELDS: web_url, print_page, news_desk, _id

doc[1]:
DIFFERENT FIELDS: web_url, multimedia[0]: width, multimedia[0]: url, multimedia[0]: height, multimedia[0]: subtype, multimedia[2]: width, multimedia[2]: url, multimedia[2]: height, multimedia[2]: subtype, keywords, _id

doc[2]:
DIFFERENT FIELDS: web_url, print_page, news_desk, _id

doc[3]:
DIFFERENT FIELDS: web_url, print_page, news_desk, _id

doc[4]:
DIFFERENT FIELDS: web_url, print_page, news_desk, _id

doc[5]:
DIFFERENT FIELDS: web_url, multimedia[0]: width, multimedia[0]: url, multimedia[0]: height, multimedia[0]: subtype, multimedia[2]: width, multimedia[2]: url, multimedia[2]: height, multimedia[2]: subtype, headline/print_headline, keywords[0]: is_major, _id

doc[6]:
DIFFERENT FIELDS: web_url, print_page, news_desk, _id

doc[7]:
DIFFERENT FIELDS: web_url, print_page, news_desk, _id

doc[8]:
DIFFERENT FIELDS: web_url, print_page, news_desk, _id

doc[9]:
DIFFERENT FIELDS: web_url, multimedia[0]: width, multimedia[0]: url, multimedia[0]: height, multimedia[0]: subtype, multimedia[2]: width, multimedia[2]: url, multimedia[2]: height, multimedia[2]: subtype, keywords[0]: is_major, keywords[1]: is_major, keywords[2]: is_major, keywords[3]: is_major, keywords[4]: is_major, _id


==============================
RUN 2:
==============================
C:\OtherTests\NY\CL Tool2\output>java -classpath .;gson-2.6.2.jar Compare file1.json file1.json
doc[0]:
SAME IN TWO FILES

doc[1]:
SAME IN TWO FILES

doc[2]:
SAME IN TWO FILES

doc[3]:
SAME IN TWO FILES

doc[4]:
SAME IN TWO FILES

doc[5]:
SAME IN TWO FILES

doc[6]:
SAME IN TWO FILES

doc[7]:
SAME IN TWO FILES

doc[8]:
SAME IN TWO FILES

doc[9]:
SAME IN TWO FILES


==============================
RUN 3:
==============================
C:\OtherTests\NY\CL Tool2\output>java -classpath .;gson-2.6.2.jar Compare file1.json file3.json
file3.json is empty


==============================
RUN 4:
==============================
C:\OtherTests\NY\CL Tool2\output>java -classpath .;gson-2.6.2.jar Compare file4.json file3.json
file4.json is empty
file3.json is empty