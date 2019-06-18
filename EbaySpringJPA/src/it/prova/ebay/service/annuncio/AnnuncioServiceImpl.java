package it.prova.ebay.service.annuncio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebay.dao.annuncio.AnnuncioDAO;
import it.prova.ebay.model.Annuncio;
@Component
public class AnnuncioServiceImpl implements AnnuncioService {

	@Autowired
	private AnnuncioDAO annuncioDAO;
	
	@Transactional(readOnly = true)
	public List<Annuncio> list() {
		// TODO Auto-generated method stub
		return annuncioDAO.list();
	}

	@Transactional(readOnly = true)
	public Annuncio get(long id) {
		return annuncioDAO.get(id);
	}

	@Transactional
	public void update(Annuncio o) {
		annuncioDAO.update(o);
	}

	@Transactional
	public void insert(Annuncio o) {
		annuncioDAO.insert(o);
	}

	@Transactional
	public void delete(Annuncio o) {
		annuncioDAO.delete(o);
	}

	@Transactional
	public List<Annuncio> findByExample(Annuncio o) {
		return annuncioDAO.findByExample(o);
	}

	@Transactional
	public List<Annuncio> findByNomeECategoria(Annuncio input) {
		return annuncioDAO.findByNomeECategoria(input);
	}
	@Transactional
	public Annuncio getEager(long id) {
		return annuncioDAO.getEager(id);
	}


}
