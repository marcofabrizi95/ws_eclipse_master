package it.prova.ebay.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.prova.ebay.model.Annuncio;
@Component
public class AnnuncioDAOImpl implements AnnuncioDAO {
	@PersistenceContext
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")

	@Override
	public List<Annuncio> list() {
		return entityManager.createQuery("from Annuncio").getResultList();

	}

	@Override
	public Annuncio get(Long id) {
		 Annuncio result = (Annuncio) entityManager.find(Annuncio.class, id);
		 return result; 
	}

	@Override
	public void update(Annuncio o) {
		entityManager.merge(o);

		
	}

	@Override
	public void insert(Annuncio o) {
		entityManager.persist(o);
		
	}

	@Override
	public void delete(Annuncio o) {
		entityManager.remove(entityManager.merge(o));
		
	}
	@SuppressWarnings("unchecked")

	@Override
	public List<Annuncio> findByExample(Annuncio o) {
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

		Example utenteExample = Example.create(o).setPropertySelector(ps).enableLike(MatchMode.ANYWHERE);
		Criteria criteria = session.createCriteria(Annuncio.class).add(utenteExample);
		return criteria.list();

	}
	
}
