package it.prova.ebay.service.annuncio;

import java.util.List;
import java.util.Set;

import it.prova.ebay.model.Annuncio;
import it.prova.ebay.model.Categoria;

public interface AnnuncioService {
	public List<Annuncio> list();

	public Annuncio get(long id);

	public void update(Annuncio o);

	public void insert(Annuncio o);

	public void delete(Annuncio o);

	public List<Annuncio> findByExample(Annuncio o);
	
	public List<Annuncio> findByNomeECategoria(Annuncio o);
	public Annuncio getEager(long id);

}
