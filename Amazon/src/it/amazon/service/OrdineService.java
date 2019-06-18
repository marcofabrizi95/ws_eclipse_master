package it.amazon.service;

import java.util.List;

import it.amazon.dao.OrdineDAO;
import it.amazon.model.Categoria;
import it.amazon.model.Ordine;

public interface OrdineService {
	public List<Ordine> listAllOrdine() throws Exception;

	public Ordine caricaSingoloOrdine(long id) throws Exception;

	public void aggiorna(Ordine ordineInstance) throws Exception;

	public void inserisciNuovo(Ordine ordineInstance) throws Exception;

	public void rimuovi(Ordine ordineInstance) throws Exception;

	public List<Ordine> findByExample(Ordine example) throws Exception;

	//per injection
	public void setOrdineDAO(OrdineDAO ordineDAO);
	public List<Ordine> allForCategoria(Categoria input) ;
	public List<Categoria> tutteCategoriePerOrdine(Ordine input);

}
