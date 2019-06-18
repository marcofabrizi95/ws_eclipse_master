package it.manytomanyjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;

import it.manytomanyjpa.model.Ruolo;


public class RuoloDAOImpl implements RuoloDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Ruolo> list() throws Exception {
		return entityManager.createQuery("from Ruolo").getResultList();
	}

	@Override
	public Ruolo get(long id) throws Exception {
		return entityManager.find(Ruolo.class, id);
	}

	@Override
	public void update(Ruolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		input = entityManager.merge(input);
	}

	@Override
	public void insert(Ruolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(input);

	}

	@Override
	public void delete(Ruolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(input));
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Ruolo> findByExample(Ruolo input) throws Exception {
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

		Criteria abitanteCriteria = session.createCriteria(Ruolo.class);
		Example abitanteExample = Example.create(input).setPropertySelector(ps);
		

		abitanteCriteria.add(abitanteExample);
		return abitanteCriteria.list();

	}
	
	

}
