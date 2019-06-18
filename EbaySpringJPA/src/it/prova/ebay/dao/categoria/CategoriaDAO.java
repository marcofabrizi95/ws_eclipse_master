package it.prova.ebay.dao.categoria;

import it.prova.ebay.dao.IBaseDAO;
import it.prova.ebay.model.Categoria;

public interface CategoriaDAO extends IBaseDAO<Categoria>{
	public Categoria getEager(Long id) ;
	public boolean existDescrizione(String descrizione);
	public boolean existCodice(String codice);
}
