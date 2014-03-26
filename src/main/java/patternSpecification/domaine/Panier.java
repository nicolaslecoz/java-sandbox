package patternSpecification.domaine;

import java.util.ArrayList;
import java.util.Collection;

public class Panier {
    private Client client;

    private Collection<Produit> produits;
    
    public boolean rattacherAUnClient() {
	return client != null;
    }
    
    public Panier() {
	this.produits = new ArrayList<Produit>();
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }
    
}
