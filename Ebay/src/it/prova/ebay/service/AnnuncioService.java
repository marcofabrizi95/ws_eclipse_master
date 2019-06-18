package it.prova.ebay.service;

import java.util.List;

import it.prova.ebay.model.Annuncio;

public interface AnnuncioService {
	public List<Annuncio> listAll();

	public Annuncio carica(Long id);

	
	public void aggiorna(Annuncio o);

	public void inserisci(Annuncio o);

	public void rimuovi(Annuncio o);

	public List<Annuncio> findByExample(Annuncio example);

}
