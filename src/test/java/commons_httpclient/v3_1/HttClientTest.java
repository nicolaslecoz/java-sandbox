package commons_httpclient.v3_1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Nicolas Le Coz <lecoz.nicolas@gmail.com>
 * @since 27 mai 2010
 */

public class HttClientTest {
	private static Logger logger = LoggerFactory.getLogger(HttClientTest.class);

	@Test
	public void test01() {
		logger.info("start test01");

		String result = callGetHttp("https://www.amendes.gouv.fr/portail/index.jsp");
		logger.info("print content : ");
		logger.info(result);
		logger.info("stop test01");
	}

	private String callGetHttp(String url) {
		String result = "";
		
		HttpClient httpClient = new HttpClient();

		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(
				5000);
		httpClient.getHttpConnectionManager().getParams().setSoTimeout(5000);

		// Conf with proxy
		// httpClient.getHostConfiguration().setProxy("1.1.1.1", 8080);

		// Conf with proxy + auth on domain (proxy NTLM)
		// httpClient.getState().setProxyCredentials(
		// new AuthScope("1.1.1.1", 8080),
		// new NTCredentials("user", "password", "1.1.1.1", "domain"));

		HttpMethod method = null;

		try {
			method = new GetMethod(url);

			method.getParams().setParameter("http.socket.timeout", 1000);
			httpClient.executeMethod(method);
			InputStream is = method.getResponseBodyAsStream();

			try {
				String line = "";
				StringBuilder sb = new StringBuilder();
				
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is, "UTF-8"));
				while ((line = reader.readLine()) != null) {
					sb.append(line).append("\n");
				}
				result = sb.toString();
			} finally {
				is.close();
			}
		} catch (Exception e) {
			logger.error("", e);
			Assert.fail();
		} finally {
			if (method != null) {
				method.releaseConnection();
			}
		}
		return result;
	}
}
