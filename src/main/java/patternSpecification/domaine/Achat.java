package patternSpecification.domaine;

import java.math.BigDecimal;

public class Achat {
    private Adresse adresseDeLivraison;

    private BigDecimal price;
    
    public Adresse getAdresseDeLivraison() {
        return adresseDeLivraison;
    }

    public void setAdresseDeLivraison(Adresse adresseDeLivraison) {
        this.adresseDeLivraison = adresseDeLivraison;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
