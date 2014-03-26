package eu.nicolaslecoz.sandbox.jsoup.iatacodemanager.model;

import java.io.Serializable;

/**
 * 
 * @author nlecoz
 * @since 2010
 */
public class CompagnieAerienne implements Serializable {
	private String id;
	
	private String nom;
	
	private String pays;
	
	private String code3Digit;
	
	private String codeIATA;
	
	private String codeICAO;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		if (id == null) {
			throw new IllegalStateException();
		}
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getCode3Digit() {
		return code3Digit;
	}
	public void setCode3Digit(String code3Digit) {
		this.code3Digit = code3Digit;
	}
	public String getCodeIATA() {
		return codeIATA;
	}
	public void setCodeIATA(String codeIATA) {
		this.codeIATA = codeIATA;
	}
	public String getCodeICAO() {
		return codeICAO;
	}
	public void setCodeICAO(String CodeICAO) {
		this.codeICAO = CodeICAO;
	}
}
