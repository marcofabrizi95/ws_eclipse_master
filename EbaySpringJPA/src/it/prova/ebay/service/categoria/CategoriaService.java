package it.prova.ebay.service.categoria;

import java.util.List;

import it.prova.ebay.model.Categoria;

public interface CategoriaService {
	public List<Categoria> list();

	public Categoria get(long id);

	public void update(Categoria o);

	public void insert(Categoria o);

	public void delete(Categoria o);

	public List<Categoria> findByExample(Categoria o);
	public Categoria caricaEager(Long id);
	public boolean existDescrizione(String descrizione);
	public boolean existCodice(String codice) ;
}
