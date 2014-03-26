package hibernate.violation_set.domain;

/**
 * Created with IntelliJ IDEA.
 * User: nicolas
 * Date: 07/08/13
 * Time: 18:59
 * To change this template use File | Settings | File Templates.
 */
public class Personne {
    private long id;
    private String prenom;
    private String nom;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne personne = (Personne) o;

        if (!email.equals(personne.email)) return false;
        if (!nom.equals(personne.nom)) return false;
        if (!prenom.equals(personne.prenom)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prenom.hashCode();
        result = 31 * result + nom.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
