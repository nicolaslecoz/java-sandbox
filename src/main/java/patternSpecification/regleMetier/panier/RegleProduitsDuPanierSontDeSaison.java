package patternSpecification.regleMetier.panier;

import patternSpecification.domaine.Mois;
import patternSpecification.domaine.Panier;
import patternSpecification.domaine.Produit;
import patternSpecification.regleMetier.util.LeafSpecification;

public class RegleProduitsDuPanierSontDeSaison extends LeafSpecification<Panier>{
    public boolean isSatisfiedBy(Panier panier) {
	for (Produit produit : panier.getProduits()) {
	    if (!Mois.estDeSaison(produit.getMoisDeSaison())) {
		return false;
	    }
	}
	return true;
    }
}
