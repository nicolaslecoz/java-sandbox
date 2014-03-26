package org.jsoup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import junit.framework.Assert;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JsoupTest {

	@Test
	public void testJsoup() throws Exception {
		Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
		Elements newsHeadlines = doc.select("#mp-itn b a");
	}

	@Test
	public void testJsoupWithProxy() throws Exception {
		URL url = new URL("http://www.topito.com/top-chats-personnalites-ressemblance");
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("srvproxy", 9708));
		HttpURLConnection uc = (HttpURLConnection) url.openConnection(proxy);

		uc.connect();

		String line = null;
		StringBuffer tmp = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				uc.getInputStream()));
		while ((line = in.readLine()) != null) {
			tmp.append(line);
		}
		Document doc = Jsoup.parse(String.valueOf(tmp));
		Elements titreElements = doc.select("h1.toptitle");
		
		Assert.assertNotNull(titreElements);
		Assert.assertTrue(titreElements.size() == 1);
		Assert.assertNotNull(titreElements.get(0));
		Assert.assertEquals("Top 24 des chats qui se payent le tête de personnalités", titreElements.get(0).text());
	}
}
