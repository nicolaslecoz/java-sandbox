package patternSpecification.domaine;

public class Orange implements Fruit {
    private Mois[] moisDeSaison = new Mois[] {
	    Mois.JANVIER,
	    Mois.FEVRIER,
	    Mois.MARS,
	    Mois.AVRIL,
	    Mois.MAI,
	    Mois.JUIN,
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
