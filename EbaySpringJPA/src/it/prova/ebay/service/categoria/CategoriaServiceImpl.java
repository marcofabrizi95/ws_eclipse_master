package it.prova.ebay.service.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebay.dao.categoria.CategoriaDAO;
import it.prova.ebay.model.Categoria;

@Component
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDAO categoriaDAO;

	@Transactional(readOnly = true)
	public List<Categoria> list() {
		return categoriaDAO.list();
	}

	@Transactional(readOnly = true)
	public Categoria get(long id) {
		return categoriaDAO.get(id);
	}

	@Transactional
	public void update(Categoria o) {
		categoriaDAO.update(o);
	}

	@Transactional
	public void insert(Categoria o) {
		categoriaDAO.insert(o);
	}

	@Transactional
	public void delete(Categoria o) {
		categoriaDAO.delete(o);
	}

	@Transactional
	public List<Categoria> findByExample(Categoria o) {
		return categoriaDAO.findByExample(o);
	}
	@Transactional(readOnly = true)
	public Categoria caricaEager(Long id) {
		return categoriaDAO.getEager(id);
	}
	@Transactional(readOnly = true)
	public boolean existDescrizione(String descrizione) {
		return categoriaDAO.existDescrizione(descrizione);
	}

	@Transactional(readOnly = true)
	public boolean existCodice(String codice) {
		return categoriaDAO.existDescrizione(codice);
	}
}
