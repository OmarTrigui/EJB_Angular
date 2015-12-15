package com.enis.dto;

import java.io.Serializable;

public class ClientBanqueDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cin;
	private String nomClient;
	private String prenomClient;
	private String adresse;

	public ClientBanqueDTO() {
		super();
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public ClientBanqueDTO(String cin, String nomClient, String prenomClient,
			String adresse) {
		super();
		this.cin = cin;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresse = adresse;

	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	@Override
	public String toString() {
		return "ClientBanqueDTO [cin=" + cin + ", nomClient=" + nomClient
				+ ", prenomClient=" + prenomClient + ", adresse=" + adresse
				+ "]";
	}

}
