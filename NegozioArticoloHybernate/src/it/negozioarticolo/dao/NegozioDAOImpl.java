package it.negozioarticolo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import it.negozioarticolo.model.Negozio;

public class NegozioDAOImpl implements NegozioDAO{
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Negozio> list() throws Exception {
		return entityManager.createQuery("from Negozio").getResultList();
	}

	@Override
	public Negozio get(long id) throws Exception {
		return entityManager.find(Negozio.class, id);
	}

	@Override
	public void update(Negozio input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		input = entityManager.merge(input);
	}
	

	@Override
	public void insert(Negozio input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(input);
	}


	@Override
	public void delete(Negozio input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(input));
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Negozio> findByExample(Negozio input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		Session session = (Session) entityManager.getDelegate();
		Example municipioExample = Example.create(input).excludeZeroes();
		Criteria criteria = session.createCriteria(Negozio.class).add(municipioExample);
		return criteria.list();
	}
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager=entityManager;
	}


}
