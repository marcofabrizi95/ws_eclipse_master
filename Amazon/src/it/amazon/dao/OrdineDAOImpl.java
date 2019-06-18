package it.amazon.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;

import it.amazon.model.Categoria;
import it.amazon.model.Ordine;

public class OrdineDAOImpl implements OrdineDAO{
private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ordine> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Ordine").getResultList();
	}



	@Override
	public Ordine get(long id) throws Exception {
		return entityManager.find(Ordine.class, id);
		}

	@Override
	public void update(Ordine input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		input = entityManager.merge(input);
	}
	@Override
	public void insert(Ordine input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(input);
	}
	@Override
	public void delete(Ordine input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(input));
	}
	@SuppressWarnings("unchecked")
	
	@Override
	public List<Ordine> findByExample(Ordine input) throws Exception {
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

		Criteria abitanteCriteria = session.createCriteria(Ordine.class);
		Example abitanteExample = Example.create(input).setPropertySelector(ps);
		

		abitanteCriteria.add(abitanteExample);
		return abitanteCriteria.list();
	}
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ordine> allForCategoria(Categoria input) {
		if(input==null)
		    return null;
		return entityManager.createQuery("SELECT o FROM Ordine o JOIN FETCH o.articoli a JOIN FETCH a.categorie categ WHERE categ.id="+input.getId() +"GROUP BY O").getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> tutteCategoriePerOrdine(Ordine input) {
		if(input==null)
		    return null;
		return entityManager.createQuery("SELECT o FROM Categoria o JOIN FETCH o.articoli art JOIN FETCH art.ordine ord WHERE ord.id="+input.getId()+"GROUP BY o\"").getResultList();
	}
	


}
