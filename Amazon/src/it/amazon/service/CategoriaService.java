package it.amazon.service;

import java.util.List;

import it.amazon.dao.CategoriaDAO;
import it.amazon.model.Categoria;

public interface CategoriaService {
	public List<Categoria> listAllCategoria() throws Exception;

	public Categoria caricaSingoloCategoria(long id) throws Exception;

	public void aggiorna(Categoria categoriaInstance) throws Exception;

	public void inserisciNuovo(Categoria categoriaInstance) throws Exception;

	public void rimuovi(Categoria categoriaInstance) throws Exception;

	public List<Categoria> findByExample(Categoria example) throws Exception;

	//per injection
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
	public int sommaPrezziPerCategoria(Categoria input);

}
