package patternSpecification.regleMetier.promo;

import junit.framework.Assert;

import org.junit.Test;

import patternSpecification.domaine.Panier;
import patternSpecification.regleMetier.promo.ReglePromoJAimeLesProduitsOranges;



public class ReglePromoJaimeLesProduitsOrangesTest {
    
    @Test
    public void test01PanierVide() {
	Panier panier = new Panier();
	ReglePromoJAimeLesProduitsOranges regle = new ReglePromoJAimeLesProduitsOranges();
	
	Assert.assertFalse(regle.isSatisfiedBy(panier));
    }
    
    public void test02PanierAvecUneBanane() {
	
    }
}
