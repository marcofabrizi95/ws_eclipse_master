package it.prova.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

import it.prova.model.Motocicletta;

@Component
public class MotociclettaDAOImpl implements MotociclettaDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Motocicletta> list() {
		return entityManager.createQuery("from Motocicletta").getResultList();

	}

	@Override
	public Motocicletta get(Long id) {
		return entityManager.find(Motocicletta.class, id);

	}

	@Override
	public void update(Motocicletta o) {
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Motocicletta o) {
		entityManager.persist(o);
	}

	@Override
	public void delete(Motocicletta o) {
		entityManager.remove(entityManager.merge(o));

	}
	@SuppressWarnings("unchecked")

	@Override
	public List<Motocicletta> findByExample(Motocicletta o) {
		Session session = (Session) entityManager.getDelegate();
		Example motociclettaExample = Example.create(o)
				.excludeZeroes();
		Criteria criteria = session.createCriteria(Motocicletta.class).add(
				motociclettaExample);
		return criteria.list();
	}

	@Override
	public void refresh(Motocicletta o) {
		entityManager.refresh(entityManager.merge(o));

	}

}
