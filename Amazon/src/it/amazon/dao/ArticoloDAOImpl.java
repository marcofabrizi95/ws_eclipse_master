package it.amazon.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;

import it.amazon.model.Articolo;

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
		Session session = (Session) entityManager.getDelegate();

		@SuppressWarnings("serial")
		PropertySelector ps = new PropertySelector() {
			@Override
			public boolean include(Object object, String propertyName, Type type) {
				if(object == null)
					return false;
				//String
				if(object instanceof String) 
					return StringUtils.isNotBlank((String) object);
				//Number
				if(object instanceof Integer)
					return ((Integer)object) != 0;
				return true;
			}
		};

		Criteria abitanteCriteria = session.createCriteria(Articolo.class);
		Example abitanteExample = Example.create(input).setPropertySelector(ps);
		

		abitanteCriteria.add(abitanteExample);
		return abitanteCriteria.list();
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
