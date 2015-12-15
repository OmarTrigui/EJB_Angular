package tn.enis.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CompteBancaireEntity implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long rib;
	private float solde;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private ClientBanqueEntity client;

	public CompteBancaireEntity() {
	}

	public long getRib() {
		return rib;
	}

	public void setRib(long rib) {
		this.rib = rib;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public ClientBanqueEntity getClient() {
		return client;
	}

	public void setClient(ClientBanqueEntity client) {
		this.client = client;
	}

	public CompteBancaireEntity(float solde, ClientBanqueEntity client) {
		this.solde = solde;
		this.client = client;
		this.client.getComptes().add(this);

	}

	@Override
	public String toString() {
		return "CompteBancaireEntity [rib=" + rib + ", solde=" + solde
				+ ", client=" + client + "]";
	}

}
