package it.prova.ebay.dao.utente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.criterion.MatchMode;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.prova.ebay.model.Utente;

@Component
public class UtenteDAOImpl implements UtenteDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Utente> list() {
		return entityManager.createQuery("from Utente").getResultList();
	}

	@Override
	public Utente get(long id) {
		Utente result = (Utente) entityManager.find(Utente.class, id);
		return result;
	}

	@Override
	public void update(Utente o) {
		o = entityManager.merge(o);

	}

	@Override
	public void insert(Utente o) {
		entityManager.persist(o);
	}

	@Override
	public void delete(Utente o) {
		entityManager.remove(entityManager.merge(o));

	}

	@Override
	public List<Utente> findByExample(Utente o) {
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
				if (object instanceof Double)
					return ((Double) object) != 0;
				return true;
			}
		};

		Example utenteExample = Example.create(o).setPropertySelector(ps).enableLike(MatchMode.ANYWHERE);
		Criteria criteria = session.createCriteria(Utente.class).add(utenteExample);
		return criteria.list();
	}
	
	
	@Override
	public Utente getEager(long id) {
		Query query = entityManager.createQuery("SELECT a from Utente a JOIN FETCH a.ruoli WHERE a.id= :id");
		query.setParameter("id", id);
		return query.getResultList().isEmpty() ? null : (Utente) query.getSingleResult();
	}
	public Utente getEagerAnnunciEAcquisti(long id) {
		Query q = entityManager.createQuery("SELECT a from Utente a Left JOIN FETCH a.annunci Left JOIN FETCH a.acquisti WHERE a.id= :id");
		q.setParameter("id", id);
		return (Utente) q.getSingleResult();
	}
	

	@Override
	public Utente executeLogin(String username, String password) {
		Query query = entityManager
				.createQuery("select u FROM Utente u where u.username = :usernameParam and u.password= :passwordParam");
		query.setParameter("usernameParam", username);
		query.setParameter("passwordParam", password);

		return query.getResultList().isEmpty() ? null : (Utente) query.getSingleResult();
	}
	
	@Override
	public Utente executeLoginEager(String username, String password) {
		Query query = entityManager
				.createQuery("SELECT u FROM Utente u LEFT JOIN FETCH u.ruoli r LEFT JOIN FETCH u.annunci LEFT JOIN FETCH u.acquisti where u.username = :usernameParam and u.password= :passwordParam");
		query.setParameter("usernameParam", username);
		query.setParameter("passwordParam", password);

		return query.getResultList().isEmpty() ? null : (Utente) query.getSingleResult();
	}

}
