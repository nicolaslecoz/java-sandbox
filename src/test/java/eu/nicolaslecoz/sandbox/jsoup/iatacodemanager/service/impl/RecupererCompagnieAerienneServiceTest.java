package eu.nicolaslecoz.sandbox.jsoup.iatacodemanager.service.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import eu.nicolaslecoz.sandbox.jsoup.iatacodemanager.model.CompagnieAerienne;
import eu.nicolaslecoz.sandbox.jsoup.iatacodemanager.service.impl.InspecteurPageHtmlIataService;

/**
 * 
 * @author nlecoz
 * @since 30 dec 2010
 */
public class RecupererCompagnieAerienneServiceTest {
	
	private CompagnieAerienne findCompagnieAerienneById(List<CompagnieAerienne> cas, String id) {
		for (CompagnieAerienne ca : cas) {
			if (id.equals(ca.getId())) {
				return ca;
			}
		}
		return null;
	}
	
	private void assertCompagnieAerienne(CompagnieAerienne ca, 
			String expectedId, 
			String expectedNom,
			String expectedCodeICAO, 
			String expectedCodeIATA, 
			String expectedCode3Digit, 
			String expectedPays) {
		Assert.assertNotNull(ca);
		Assert.assertEquals(expectedId, ca.getId());
		Assert.assertEquals(expectedNom, ca.getNom());
		Assert.assertEquals(expectedCodeIATA, ca.getCodeIATA());
		Assert.assertEquals(expectedCodeICAO, ca.getCodeICAO());
		Assert.assertEquals(expectedCode3Digit, ca.getCode3Digit());
		Assert.assertEquals(expectedPays, ca.getPays());
	}
	
	@Test
	public void test01() {
		List<CompagnieAerienne> cas = new InspecteurPageHtmlIataService().recuperCompagnieAerienne();
		
		Assert.assertNotNull(cas);
		Assert.assertTrue(0 < cas.size());
		Assert.assertTrue(10 < cas.size());
		
		CompagnieAerienne ca1 = findCompagnieAerienneById(cas, "pnl20.0000000000000"); // Air France
		
		assertCompagnieAerienne(ca1, "pnl20.0000000000000", "Air France", "AFR", "AF", "057", "France");
		
		CompagnieAerienne ca2 = findCompagnieAerienneById(cas, "pnl139.000000000000"); // LAM
		
		assertCompagnieAerienne(ca2, "pnl139.000000000000", "LAM", "LAM", "TM", "068", "Mozambique");
	}
}
