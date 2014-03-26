package patternSpecification.regleMetier.panier;

import patternSpecification.domaine.Abricot;
import patternSpecification.domaine.Carotte;
import patternSpecification.domaine.Citrouille;
import patternSpecification.domaine.Mandarine;
import patternSpecification.domaine.Orange;
import patternSpecification.domaine.Panier;
import patternSpecification.domaine.Produit;
import patternSpecification.regleMetier.util.LeafSpecification;

public class RegleProduitsDuPanierSontOranges extends LeafSpecification<Panier> {
    public boolean isSatisfiedBy(Panier panier) {
	for (Produit produit : panier.getProduits()) {
	    if (produit instanceof Abricot
		    || produit instanceof Carotte
		    || produit instanceof Citrouille
		    || produit instanceof Mandarine
		    || produit instanceof Orange) {
		return true;
	    }
	}
	return false;
    }
}
