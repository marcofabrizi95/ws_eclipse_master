package it.amazon.dao;

import java.util.List;

import it.amazon.model.Categoria;
import it.amazon.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine> {
	public List<Ordine> allForCategoria(Categoria input) ;
	public List<Categoria> tutteCategoriePerOrdine(Ordine input) ;
}
