package tn.enis.service;

import java.util.List;

import javax.ejb.Local;

import com.enis.dto.ClientBanqueDTO;
import com.enis.dto.CompteBancaireDTO;

@Local
public interface CompteBancaireServiceLocal {

	public void ajoutCompteBancaire(CompteBancaireDTO compteBancaireDTO);

	public void supprimerCompteBancaire(CompteBancaireDTO compteBancaireDTO);
	
	public List<CompteBancaireDTO> getAllCompteBancaire();

	public ClientBanqueDTO getClientByCin(String cin);

	public CompteBancaireDTO getAccountByRib(long rib);
	

}
