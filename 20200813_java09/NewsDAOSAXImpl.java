package com.ssafy.hw.step09.console;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO{
	private ArrayList<News> al = new ArrayList<News>();
	News n = new News();
	public ArrayList<News> getNewsList(String url){
		connectNews(url);
//		for(int i = 0; i < al.size(); i++){
//			System.out.println(al.get(i).toString());
//		}
		return al;
	}
	public News search(int Index) {		
		return al.get(Index); 
	}
	public void connectNews(String url) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			SAXHandler handler = new SAXHandler();
			saxParser.parse(url, handler);
		}catch(ParserConfigurationException | SAXException | IOException e){
			e.printStackTrace();
		}
	}
	public class SAXHandler extends DefaultHandler {
		private StringBuilder data = null;
		private boolean flag_t = false;
		private boolean flag_d = false;
		private boolean flag_l = false;
		private boolean item = false;
		private News n = new News();

		public void startElement(String url, String localName, String qName, Attributes attributes) throws SAXException {
			
			if (qName.equals("item")) {
				item = true;
				n = new News();
			}
			if (item) {
				if (qName.equals("title")) {
					flag_t = true;
				} else if (qName.equals("description")) {
					flag_d = true;
				} else if (qName.equals("link")) {
					flag_l = true;
				}
			}
			data = new StringBuilder();
		}

		public void endElement(String url, String localName, String qName) throws SAXException {
			if (item) {
				if (flag_t) {
					n.setTitle(data.toString());
					flag_t = false;
				} else if (flag_d) {
					n.setDesc(data.toString());
					flag_d = false;
				} else if (flag_l) {
					n.setLink(data.toString());
					flag_l = false;
				}
			}
			if (qName.equals("item")) {
				item = false;
				al.add(n);
			}
		}
		

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			data.append(new String(ch, start, length));
		}
		public News getNews() {
			return n;
		}
	}
	
}
