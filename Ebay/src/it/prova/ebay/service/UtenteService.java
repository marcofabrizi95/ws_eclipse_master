package it.prova.ebay.service;

import java.util.List;

import it.prova.ebay.model.Utente;

public interface UtenteService {
	
	public List<Utente> listAll() ;

	public Utente carica(Long id);

	public void aggiorna(Utente utenteInstance);

	public void inserisci(Utente utenteInstance);

	public void rimuovi(Utente utenteInstance);

	public List<Utente> findByExample(Utente example);
	
	public Utente eseguiAccesso(String username, String password);
	public Utente caricaEager(Long id);

}
