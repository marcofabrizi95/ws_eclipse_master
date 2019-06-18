package it.prova.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.prova.model.Vino;
@Component
public class VinoDAOImpl implements VinoDAO{
	@PersistenceContext
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<Vino> list() {
		return entityManager.createQuery("from Vino").getResultList();

	}

	@Override
	public Vino get(Long id) {
		return entityManager.find(Vino.class, id);

	}

	@Override
	public void update(Vino o) {
		o = entityManager.merge(o);

	}

	@Override
	public void insert(Vino o) {
		entityManager.persist(o);

	}

	@Override
	public void delete(Vino o) {
		entityManager.remove(entityManager.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vino> findByExample(Vino input) {
		Session session = (Session) entityManager.getDelegate();
		
		@SuppressWarnings("serial")
		PropertySelector ps = new PropertySelector() {
			@Override
			public boolean include(Object object, String propertyName, Type type) {
				if (object == null)
					return false;
				// String
				if (object instanceof String)
					return StringUtils.isNotBlank((String) object);
				// Number
				if (object instanceof Integer)
					return ((Integer) object) != 0;
				return true;
			}
		};
		
		Example personaExample = Example.create(input).setPropertySelector(ps);
		Criteria criteria = session.createCriteria(Vino.class).add(personaExample);
		return criteria.list();
	}




}
