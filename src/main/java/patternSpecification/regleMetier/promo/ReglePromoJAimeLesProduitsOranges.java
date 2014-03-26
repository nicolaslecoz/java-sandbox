package patternSpecification.regleMetier.promo;

import patternSpecification.domaine.Panier;
import patternSpecification.regleMetier.panier.RegleProduitsDuPanierSontDeSaison;
import patternSpecification.regleMetier.panier.RegleProduitsDuPanierSontOranges;
import patternSpecification.regleMetier.util.LeafSpecification;

public class ReglePromoJAimeLesProduitsOranges extends LeafSpecification<Panier> {
    RegleProduitsDuPanierSontOranges regleProduitsDuPanierSontOranges = new RegleProduitsDuPanierSontOranges();
    RegleProduitsDuPanierSontDeSaison regleProduitsDuPanierSontDeSaison = new RegleProduitsDuPanierSontDeSaison();
    
    public boolean isSatisfiedBy(Panier panier) {
	return regleProduitsDuPanierSontDeSaison.and(regleProduitsDuPanierSontOranges).isSatisfiedBy(panier);
    }
}
