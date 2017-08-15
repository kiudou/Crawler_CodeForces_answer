package com.qidong;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestGetData {
	public static void main(String[] args) {
		try {
			test1();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void test1() throws Exception { 
		
		/*URL url = new URL("https://www.qiushibaike.com/text/");
		URLConnection con = (URLConnection)url.openConnection();
		*/
		//1.httpclient±Èhttp¸ß¶Ë¡¤
		//2.jsoup
		int i = 1;
		File fo = new File("C:\\Users\\37680\\Desktop\\out.txt");
		File fi = new File("C:\\Users\\37680\\Desktop\\in.txt");
		FileOutputStream fos = new FileOutputStream(fo);
		FileOutputStream fis = new FileOutputStream(fi);
		PrintStream out = new PrintStream(fos);
		PrintStream in = new PrintStream(fis);
		Document doc = Jsoup.connect("http://codeforces.com/contest/208/submission/16288986").get();
		Elements contents = doc.select("div.text");
		for(Element co : contents) {
			if(i == 1) {
			    in.println(co.text());
			    System.out.println(co.text());
				i++;
			}
			else if(i==2) {
				i++;
			}
			else if(i == 3) {
				out.println(co.text());
				System.out.println(co.text());
				i++;
			}
			else {
				i = 1;
			}
		}
	}
}
