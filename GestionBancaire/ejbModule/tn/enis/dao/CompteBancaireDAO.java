package tn.enis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.enis.model.CompteBancaireEntity;

/**
 * Session Bean implementation class CompteBancaireDAO
 */
@Stateless
public class CompteBancaireDAO implements CompteBancaireDAOLocal {

	@PersistenceContext
	private EntityManager em;

	public void save(CompteBancaireEntity compteBancaire) {
		em.persist(compteBancaire);
		em.flush();
	}

	public void delete(CompteBancaireEntity compteBancaire) {
		em.remove(em.find(CompteBancaireEntity.class, compteBancaire.getRib()));
		em.flush();
	}

	public List<CompteBancaireEntity> list() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from CompteBancaireEntity");
		return (List<CompteBancaireEntity>) query.getResultList();

	}

	public CompteBancaireEntity find(long rib) {
		CompteBancaireEntity client = em.find(CompteBancaireEntity.class, rib);
		return client;
	}

}
