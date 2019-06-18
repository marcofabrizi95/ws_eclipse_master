package it.negozioarticolo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import it.negozioarticolo.model.Articolo;

public class ArticoloDAOImpl implements ArticoloDAO {
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Articolo> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Articolo").getResultList();
	}



	@Override
	public Articolo get(long id) throws Exception {
		return entityManager.find(Articolo.class, id);
		}

	@Override
	public void update(Articolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		input = entityManager.merge(input);
	}
	@Override
	public void insert(Articolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(input);
	}
	@Override
	public void delete(Articolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(input));
	}
	@SuppressWarnings("unchecked")
	
	@Override
	public List<Articolo> findByExample(Articolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		Session session = (Session) entityManager.getDelegate();
		Example municipioExample = Example.create(input).excludeZeroes();
		Criteria criteria = session.createCriteria(Articolo.class).add(municipioExample);
		return criteria.list();
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
