package patternSpecification.domaine;

public class Radis implements Legume {
    private Mois[] moisDeSaison = new Mois[] {
	    Mois.FEVRIER,
	    Mois.MARS,
	    Mois.AVRIL,
	    Mois.MAI,
	    Mois.JUIN,
	    Mois.JUILLET,
	    Mois.AOUT,
	    Mois.SEPTEMBRE,
	    Mois.OCTOBRE,
	    Mois.NOVEMBRE,
	    Mois.DECEMBRE
    };

    public Mois[] getMoisDeSaison() {
        return moisDeSaison;
    }

    public void setMoisDeSaison(Mois[] moisDeSaison) {
        this.moisDeSaison = moisDeSaison;
    }
    
    
}
