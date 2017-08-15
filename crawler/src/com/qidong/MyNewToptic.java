package com.qidong;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MyNewToptic {
	//用于存放服务器给浏览器返回的cookies;
	private static Map<String, String> cookies = new HashMap<String, String>();
	public static void main(String[] args) throws Exception {
		publishNewTopic(" ", " ");
	}
	public static void publishNewTopic(String title, String content) throws Exception {
		Response res =  Jsoup.connect("http://bbs.java1995.com/member.php?mod=logging&action=login")
			.method(Method.POST).execute();
		Map<String, String> resCookies = res.cookies();
		System.out.println(resCookies);
		cookies.putAll(resCookies);
		Document dc = res.parse();
		String login_formhash = dc.select("input[name=formhash]").val();
		System.out.println(login_formhash);
		
		res = Jsoup.connect("http://bbs.java1995.com/member.php?mod=logging&action=login&infloat=yes&handlekey=login&inajax=1&ajaxtarget=fwin_content_login")
				.data("formhash", login_formhash)
				.data("username","test1")
				.data("password","111111")
				.cookies(cookies)
				.execute();
	}

}
