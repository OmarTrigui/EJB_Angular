package tn.enis.dao;

import java.util.List;

import javax.ejb.Local;

import tn.enis.model.ClientBanqueEntity;

@Local
public interface ClientBanqueDAOLocal {

	void save(ClientBanqueEntity clientBanqueEntity);

	void delete(ClientBanqueEntity clientBanqueEntity);

	List<ClientBanqueEntity> list();

	ClientBanqueEntity find(String cin);

}
