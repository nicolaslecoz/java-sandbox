package templating.velocity;

import com.google.common.base.Joiner;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import templating.velocity.domain.Client;
import templating.velocity.domain.Contact;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public class VelocityTest {

    static public String formaterListeString(List<String> listeTelephone) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (String telephone : listeTelephone) {
            sb.append("\"").append(telephone).append("\"");
        }
        sb.append("]");

        return sb.toString().replaceAll("\"\"", "\",\"");
    }

    private Client buildClient(String name, List<String> listeTelephone) {
        Client client = new Client();

        client.setName(name);
        client.setContact(new Contact());
        client.getContact().setListeTelephone(listeTelephone);

        return client;
    }

    private List<Client> buildDomain() {
        List<Client> listeClient = new ArrayList<Client>();

        listeClient.add(buildClient("EDF", Arrays.asList("0145785689", "0601235678")));
        listeClient.add(buildClient("Orange", Arrays.asList("0145531389", "098754456", "0147586925")));
        listeClient.add(buildClient("Free", new ArrayList<String>()));
        listeClient.add(buildClient("EDF", Arrays.asList("0145564689", "0578979488")));
        return listeClient;
    }

    @Test
    public void test01() throws Exception {
        Properties props = new Properties();
        props.put("resource.loader", "class");
        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        VelocityEngine ve = new VelocityEngine();
        ve.init(props);
        Template template = ve.getTemplate("velocity-ex01.vm");

        VelocityContext context = new VelocityContext();
        context.put( "name", new String("Velocity") );
        context.put( "listeClient", buildDomain() );
        context.put( "myutil", VelocityTest.class);



        StringWriter sw = new StringWriter();

        template.merge( context, sw );

        System.out.println(sw);

    }

}
