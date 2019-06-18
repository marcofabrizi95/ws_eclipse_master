package it.prova.ebay.dao.categoria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.criterion.MatchMode;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.prova.ebay.model.Categoria;
@Component
public class CategoriaDAOImpl implements CategoriaDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Categoria> list() {
		return entityManager.createQuery("from Categoria").getResultList();
	}

	@Override
	public Categoria get(long id) {
		Categoria result = (Categoria) entityManager.find(Categoria.class, id);
		return result;
	}

	@Override
	public void update(Categoria o) {
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Categoria o) {
		entityManager.persist(o);
	}

	@Override
	public void delete(Categoria o) {
		entityManager.remove(entityManager.merge(o));
	}
	public Categoria getEager(Long id) {
		return (Categoria) entityManager.createQuery("SELECT c FROM Categoria c LEFT JOIN FETCH c.annunci WHERE c.id = " + Long.toString(id)).getSingleResult();
	}
	

	@Override
	public List<Categoria> findByExample(Categoria o) {
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

		Example categoriaExample = Example.create(o).setPropertySelector(ps).enableLike(MatchMode.ANYWHERE);
		Criteria criteria = session.createCriteria(Categoria.class).add(categoriaExample);
		return criteria.list();
	}
	@Override
	public boolean existDescrizione(String descrizione) {

		return !entityManager.createQuery("SELECT c FROM Categoria c WHERE c.descrizione = '" + descrizione + "'").getResultList().isEmpty();
				
	}

	@Override
	public boolean existCodice(String codice) {

		return !entityManager.createQuery("SELECT c FROM Categoria c WHERE c.descrizione = '" + codice + "'").getResultList().isEmpty();
		
	}

}
