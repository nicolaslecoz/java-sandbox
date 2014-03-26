package patternSpecification.domaine;

import org.apache.commons.lang.StringUtils;

public class Adresse {
    private static final String CODE_POSTAL_DOM_TOM = "97";
    
    private Long id;
    
    /**
     * (ligne 1 particulier, ligne 2 pro) : Identité du destinataire = Monsieur Louis Chanceux
     */
    private String destinataire;
    
    private String societe;
    
    /**
     * (ligne 2 particulier) : Complément d'identification, d'identité ou de lieu = Batiment 3
     */
    private String lieu;
    
    /**
     * (ligne 3 pro & particulier) : Complément d'identification du point géographique = Résidence de la Roseraie
     */
    private String pointGeographiqur;
    
    /**
     * (ligne 4 pro & particulier) : Numéro et libellé de la voie (volet distribution) = 10 rue de la Martingale
     */
    private String numeroEtLibelleVoie;

    private String codePostal;
    
    private String ville; 
    
    private String pays;
    
    private String codeInsee;
    
    private boolean normalisee;
    
    /**
     * Calcule du numéro de département en fonction du code postal
     */
    public String calculeCodePostal() {
        if (StringUtils.isEmpty(this.codePostal) || this.codePostal.length() < 5) {
            return "";
        }
        if (this.codePostal.startsWith(CODE_POSTAL_DOM_TOM)) {
            return this.codePostal.substring(0, 3);
        }
        return this.codePostal.substring(0, 2);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getPointGeographiqur() {
        return pointGeographiqur;
    }

    public void setPointGeographiqur(String pointGeographiqur) {
        this.pointGeographiqur = pointGeographiqur;
    }

    public String getNumeroEtLibelleVoie() {
        return numeroEtLibelleVoie;
    }

    public void setNumeroEtLibelleVoie(String numeroEtLibelleVoie) {
        this.numeroEtLibelleVoie = numeroEtLibelleVoie;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodeInsee() {
        return codeInsee;
    }

    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }

    public boolean isNormalisee() {
        return normalisee;
    }

    public void setNormalisee(boolean normalisee) {
        this.normalisee = normalisee;
    }
    
}
