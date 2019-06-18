package it.amazon.dao;

import it.amazon.model.Categoria;

public interface CategoriaDAO extends IBaseDAO<Categoria> {
	public int sommaPrezziPerCategoria(Categoria input);
	
}
