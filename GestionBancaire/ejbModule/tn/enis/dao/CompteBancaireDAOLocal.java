package tn.enis.dao;

import java.util.List;

import javax.ejb.Local;

import tn.enis.model.CompteBancaireEntity;

@Local
public interface CompteBancaireDAOLocal {

	void save(CompteBancaireEntity compteBancaire);

	void delete(CompteBancaireEntity compteBancaire);

	List<CompteBancaireEntity> list();

	CompteBancaireEntity find(long rib);


}
