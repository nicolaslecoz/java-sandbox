package patternSpecification.domaine;

import java.math.BigDecimal;

public class Payment {
    private BigDecimal montant;
    private MoyenDePaiement moyenDePaiement;
    
    public BigDecimal getMontant() {
        return montant;
    }
    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
    public MoyenDePaiement getMoyenDePaiement() {
        return moyenDePaiement;
    }
    public void setMoyenDePaiement(MoyenDePaiement moyenDePaiement) {
        this.moyenDePaiement = moyenDePaiement;
    }
}
