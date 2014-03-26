package patternSpecification.domaine;

import org.joda.time.DateTime;

public enum Mois {
    JANVIER(1),
    FEVRIER(2),
    MARS(3),
    AVRIL(4),
    MAI(5),
    JUIN(6),
    JUILLET(7),
    AOUT(8),
    SEPTEMBRE(9),
    OCTOBRE(10),
    NOVEMBRE(11),
    DECEMBRE(12);
    
    int mois;
    
    private Mois(int mois) {
	this.mois = mois;
    }
    
    public static boolean estDeSaison(Mois[] mois) {
	DateTime dateCourante = new DateTime();
	
	for (Mois m : mois) {
	    if (m.mois == dateCourante.getMonthOfYear()) {
		return true;
	    }
	}
	return false;
    }
}
