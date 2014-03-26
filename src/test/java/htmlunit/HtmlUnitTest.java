package htmlunit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlUnitTest {

	@Test
	public void testHtmlUnit() throws Exception {
		final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_2, "srvproxy", 9708);

		webClient.setThrowExceptionOnScriptError(false);
		webClient.setJavaScriptEnabled(true);
		
		final HtmlPage page = (HtmlPage) webClient.getPage("http://www.allocine.fr/film/fichefilm_gen_cfilm=10568.html");

		Document doc = Jsoup.parse(String.valueOf(page.asXml()));
		Elements titreElements = doc.select("h1.toptitle");
		
		Assert.assertNotNull(titreElements);
		Assert.assertTrue(titreElements.size() == 1);
		Assert.assertNotNull(titreElements.get(0));
		Assert.assertEquals("Top 24 des chats qui se payent le tête de personnalités", titreElements.get(0).text());
	}
}
