package patternSpecification.domaine;

public class Citrouille implements Legume {
    private Mois[] moisDeSaison = new Mois[] {
	    Mois.JANVIER,
	    Mois.FEVRIER,
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
