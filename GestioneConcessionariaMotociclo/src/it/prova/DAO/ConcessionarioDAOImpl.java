package it.prova.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

import it.prova.model.Concessionario;
@Component
public class ConcessionarioDAOImpl implements ConcessionarioDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Concessionario> list() {
		return entityManager.createQuery("from Concessionario").getResultList();

	}

	@Override
	public Concessionario get(Long id) {
		return entityManager.find(Concessionario.class, id);

	}

	@Override
	public void update(Concessionario o) {
		o = entityManager.merge(o);

	}

	@Override
	public void insert(Concessionario o) {
		entityManager.persist(o);

	}

	@Override
	public void delete(Concessionario o) {
		entityManager.remove(entityManager.merge(o));

	}
	@SuppressWarnings("unchecked")

	@Override
	public List<Concessionario> findByExample(Concessionario o) {
		Session session = (Session) entityManager.getDelegate();
		Example concessionarioExample = Example.create(o)
				.excludeZeroes();
		Criteria criteria = session.createCriteria(Concessionario.class).add(
				concessionarioExample);
		return criteria.list();
	}

	@Override
	public void refresh(Concessionario o) {
		entityManager.refresh(entityManager.merge(o));

	}

}
