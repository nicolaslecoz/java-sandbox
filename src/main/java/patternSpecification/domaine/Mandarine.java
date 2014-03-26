package patternSpecification.domaine;

public class Mandarine implements Fruit {
    private Mois[] moisDeSaison = new Mois[] {
	    Mois.JANVIER,
	    Mois.FEVRIER,
	    Mois.MARS,
	    Mois.AVRIL,
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
