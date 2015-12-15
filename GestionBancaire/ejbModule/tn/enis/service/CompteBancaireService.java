package tn.enis.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.enis.dao.ClientBanqueDAOLocal;
import tn.enis.dao.CompteBancaireDAOLocal;
import tn.enis.model.CompteBancaireEntity;

import com.enis.dto.ClientBanqueDTO;
import com.enis.dto.CompteBancaireDTO;

import common.helper.AccountHelper;
import common.helper.ClientHelper;

/**
 * Session Bean implementation class CompteBancaireService
 */
@Stateless
public class CompteBancaireService implements CompteBancaireServiceLocal {

	@EJB
	CompteBancaireDAOLocal compteBancaireDAOLocal;

	@EJB
	ClientBanqueDAOLocal clientBanqueDAOLocal;

	public void ajoutCompteBancaire(CompteBancaireDTO compteBancaireDTO) {
		CompteBancaireEntity compteBancaire = new CompteBancaireEntity();
		compteBancaire.setClient(ClientHelper.dtoToModel(compteBancaireDTO
				.getClient()));
		compteBancaire.setSolde(compteBancaireDTO.getSolde());
		compteBancaireDAOLocal.save(compteBancaire);

	}

	public void supprimerCompteBancaire(CompteBancaireDTO compteBancaireDTO) {
		CompteBancaireEntity compteBancaire = new CompteBancaireEntity();
		compteBancaire.setRib(compteBancaireDTO.getRib());
		compteBancaireDAOLocal.delete(compteBancaire);

	}

	public List<CompteBancaireDTO> getAllCompteBancaire() {
		List<CompteBancaireEntity> comptes = compteBancaireDAOLocal.list();
		return AccountHelper.modelListToDTOList(comptes);

	}

	public CompteBancaireDTO getAccountByRib(long rib) {
		return AccountHelper.modelToDTO(compteBancaireDAOLocal.find(rib));
	}

	public ClientBanqueDTO getClientByCin(String cin) {
		// TODO Auto-generated method stub
		return ClientHelper.modelToDTO(clientBanqueDAOLocal.find(cin));
	}

}
