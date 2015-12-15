package com.enis.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CompteBancaireDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long rib;
	private float solde;
	private ClientBanqueDTO client;

	public CompteBancaireDTO() {
		super();
	}

	public CompteBancaireDTO(long rib,float solde, ClientBanqueDTO client) {
		super();
		this.solde = solde;
		this.client = client;
		this.rib = rib;
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

	public ClientBanqueDTO getClient() {
		return client;
	}

	public void setClient(ClientBanqueDTO client) {
		this.client = client;
	}
}
