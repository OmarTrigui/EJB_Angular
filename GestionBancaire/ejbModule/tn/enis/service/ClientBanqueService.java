package tn.enis.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.enis.dao.ClientBanqueDAOLocal;
import tn.enis.model.ClientBanqueEntity;

import com.enis.dto.ClientBanqueDTO;
import common.helper.ClientHelper;

/**
 * Session Bean implementation class CompteBancaireService
 */
@Stateless
public class ClientBanqueService implements ClientBanqueServiceLocal {

	@EJB
	ClientBanqueDAOLocal clientBanqueDAOLocal;

	public void ajoutClientBanque(ClientBanqueDTO clientBanqueDTO) {
		clientBanqueDAOLocal.save(ClientHelper.dtoToModel(clientBanqueDTO));
	}

	public void supprimerClientBanque(ClientBanqueDTO clientBanqueDTO) {
		// TODO Auto-generated method stub

		ClientBanqueEntity clientBanque = new ClientBanqueEntity();
		clientBanque.setCin(clientBanqueDTO.getCin());
		clientBanqueDAOLocal.delete(clientBanque);
	}

	public List<ClientBanqueDTO> getAllClientBanque() {
		// TODO Auto-generated method stub
		return ClientHelper.modelListToDTOList(clientBanqueDAOLocal.list());

	}

	public ClientBanqueDTO getClientByCin(String cin) {
		return ClientHelper.modelToDTO(clientBanqueDAOLocal.find(cin));
	}

}
