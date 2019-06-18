package it.prova.ebay.dao.annuncio;

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

import it.prova.ebay.model.Annuncio;
@Component
public class AnnuncioDAOImpl implements AnnuncioDAO {
	@PersistenceContext
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")

	@Override
	public List<Annuncio> list() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Annuncio").getResultList();
	}

	@Override
	public Annuncio get(long id) {
		// TODO Auto-generated method stub
		Annuncio result = (Annuncio) entityManager.find(Annuncio.class, id);
		return result;
	}

	@Override
	public void update(Annuncio o) {
		o = entityManager.merge(o);
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

		Example annuncioExample = Example.create(o).setPropertySelector(ps).enableLike(MatchMode.ANYWHERE);
		Criteria criteria = session.createCriteria(Annuncio.class).add(annuncioExample);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> findByNomeECategoria(Annuncio input) {
		Query q = entityManager.createQuery(
				"Select DISTINCT  a from Annuncio a left join fetch a.categorie c where a.testoAnnuncio like :testoAnnuncio and c in (:listaParam) and a.prezzo<= :prezzoInput and a.apertoChiuso=1 ");
		q.setParameter("testoAnnuncio", "%" + input.getTestoAnnuncio() + "%");
		q.setParameter("listaParam", input.getCategorie());
		q.setParameter("prezzoInput", input.getPrezzo());
		return q.getResultList();
	}
	public Annuncio getEager(Long id ) {
		Query query = entityManager
				.createQuery("SELECT u FROM Annuncio u LEFT JOIN FETCH u.utente left join fetch u.categorie  where u.id = :id");
		query.setParameter("id", id);

		return query.getResultList().isEmpty() ? null : (Annuncio) query.getSingleResult();
	}


}
