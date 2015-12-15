package tn.enis.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class ClientBanqueEntity implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Id
	private String cin;
	private String nom;
	private String prenom;
	private String adresse;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	List<CompteBancaireEntity> comptes;

	public ClientBanqueEntity() {
	}

	public ClientBanqueEntity(String cin, String nom, String prenom,
			String adresse) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<CompteBancaireEntity> getComptes() {
		return comptes;
	}

	public void setComptes(List<CompteBancaireEntity> comptes) {
		this.comptes = comptes;
	}

	@Override
	public String toString() {
		return "ClientBanqueEntity [cin=" + cin + ", nom=" + nom + ", prenom="
				+ prenom + ", adresse=" + adresse + "]";
	}

}
