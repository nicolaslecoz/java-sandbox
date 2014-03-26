package patternSpecification.domaine;

public class Abricot implements Fruit {
    private Mois[] moisDeSaison = new Mois[] {
	    Mois.JUILLET,
	    Mois.AOUT
    };

    public Mois[] getMoisDeSaison() {
        return moisDeSaison;
    }

    public void setMoisDeSaison(Mois[] moisDeSaison) {
        this.moisDeSaison = moisDeSaison;
    }

}
