package it.amazon.service;

import java.util.List;

import it.amazon.dao.ArticoloDAO;
import it.amazon.model.Articolo;

public interface ArticoloService {
	public List<Articolo> listAllArticoli() throws Exception;

	public Articolo caricaSingoloArticolo(long id) throws Exception;

	public void aggiorna(Articolo articoloInstance) throws Exception;

	public void inserisciNuovo(Articolo articoloInstance) throws Exception;

	public void rimuovi(Articolo narticoloInstance) throws Exception;

	public List<Articolo> findByExample(Articolo example) throws Exception;

	//per injection
	public void setArticoloDAO(ArticoloDAO articoloDAO);
}
