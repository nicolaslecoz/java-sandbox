package patternSpecification.domaine;

public class Fraise implements Fruit {
    private Mois[] moisDeSaison = new Mois[] {
	    Mois.JUIN,
	    Mois.JUILLET,
	    Mois.AOUT,
	    Mois.SEPTEMBRE,
	    Mois.OCTOBRE
    };

    public Mois[] getMoisDeSaison() {
        return moisDeSaison;
    }

    public void setMoisDeSaison(Mois[] moisDeSaison) {
        this.moisDeSaison = moisDeSaison;
    }
}
