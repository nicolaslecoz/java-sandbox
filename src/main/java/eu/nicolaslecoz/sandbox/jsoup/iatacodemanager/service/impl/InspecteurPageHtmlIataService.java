package eu.nicolaslecoz.sandbox.jsoup.iatacodemanager.service.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.nicolaslecoz.sandbox.jsoup.iatacodemanager.model.CompagnieAerienne;

/**
 * 
 * @author nlecoz
 * @since 29 dec 2010
 */
public class InspecteurPageHtmlIataService {
	static private Logger logger = LoggerFactory.getLogger(InspecteurPageHtmlIataService.class);
	
	static private final String PATTERN_URL = "http://www.iata.org/membership/Pages/airline_members_list.aspx?All=true";

	static private int CONNECTION_TIMEOUT = 50000;
	
	private CompagnieAerienne findCompagnieAerienneById(List<CompagnieAerienne> result, String id) {
		if (id == null) {
			return null;
		}
		for (CompagnieAerienne ca : result) {
			if (id.equals(ca.getId())) {
				return ca;
			}
		}
		return null;
	}
	
	private void addInfos(List<CompagnieAerienne> result, String id,  
			String nom,
			String pays,
			String code3Digit,
			String codeIATA,
			String codeICAO) {
		CompagnieAerienne ca = findCompagnieAerienneById(result, id);
		
		if (ca == null) {
			ca = new CompagnieAerienne();
			ca.setId(id);			
			result.add(ca);
		}
		ca.setNom(nom);
		ca.setPays(pays);
		ca.setCode3Digit(code3Digit);
		ca.setCodeIATA(codeIATA);
		ca.setCodeICAO(codeICAO);
	}
	
	public List<CompagnieAerienne> recuperCompagnieAerienne() {
		List<CompagnieAerienne> result = new ArrayList<CompagnieAerienne>();
		
		Document doc = null;
		
		try {
			doc = Jsoup.parse(new URL(PATTERN_URL), CONNECTION_TIMEOUT);
		}
		catch(Exception e) {
			logger.warn("Erreur", e);
		}
		Elements elements = doc.select("div#divRegion0 > div > table > tr");
		
		for (Element e : elements) {
			if (e.hasAttr("id")) {

			} else {
				Elements cells = e.select("td");
				
				String callJsWithId = cells.get(0).child(0).attr("href");
				
				addInfos(result, 
						callJsWithId.split("'")[1], // id, 
						cells.get(0).child(0).text(), // nom, 
						cells.get(4).text(),  // pays, 
						cells.get(2).text(),  // code3Digit, 
						cells.get(1).text(),  // codeIATA, 
						cells.get(3).text()); // codeICAO)				
			}
		}
		return result;
	}	
}
