package tn.enis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.enis.model.ClientBanqueEntity;

/**
 * Session Bean implementation class CompteBancaireEntityDAO
 */
@Stateless
public class ClientBanqueDAO implements ClientBanqueDAOLocal {

	@PersistenceContext
	private EntityManager em;

	public void save(ClientBanqueEntity clientBanqueEntity) {
		em.persist(clientBanqueEntity);
		em.flush();
	}

	public void delete(ClientBanqueEntity clientBanqueEntity) {
		em.remove(em.find(ClientBanqueEntity.class, clientBanqueEntity.getCin()));
		em.flush();
	}

	public List<ClientBanqueEntity> list() {
		// TODO Auto-generated method stub

		Query query = em.createQuery("from ClientBanqueEntity");
		em.flush();
		return (List<ClientBanqueEntity>) query.getResultList();

	}

	public ClientBanqueEntity find(String cin) {
		ClientBanqueEntity client = em.find(ClientBanqueEntity.class, cin);
		return client;
	}

}
