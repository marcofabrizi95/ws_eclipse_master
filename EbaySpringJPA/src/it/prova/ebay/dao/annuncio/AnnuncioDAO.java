package it.prova.ebay.dao.annuncio;

import java.util.List;
import java.util.Set;

import it.prova.ebay.dao.IBaseDAO;
import it.prova.ebay.model.Annuncio;
import it.prova.ebay.model.Categoria;

public interface AnnuncioDAO extends IBaseDAO<Annuncio>{
	
	public List<Annuncio> findByNomeECategoria(Annuncio input);
	public Annuncio getEager(Long id );
}
