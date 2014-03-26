package patternSpecification.regleMetier.util;

import patternSpecification.domaine.Panier;
import patternSpecification.domaine.Produit;

public abstract class ParcoursEnEtSurProduitsDuPanier extends LeafSpecification<Panier> {

    abstract protected boolean isProduitSatisfiedBy(Produit produit);

    public boolean isSatisfiedBy(Panier panier) {
	for (Produit produit : panier.getProduits()) {
	    if ( ! isProduitSatisfiedBy(produit)) {
		return false;
	    }
	}
	return true;
    }
}
