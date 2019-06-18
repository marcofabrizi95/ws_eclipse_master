package it.prova.ebay.service.utente;

import java.util.List;

import it.prova.ebay.model.Utente;

public interface UtenteService {
	public Utente getEagerAnnunci(long id);

	public List<Utente> listAllUtenti() ;

	public Utente caricaSingoloUtente(Long id);

	public void aggiorna(Utente utenteInstance);

	public void inserisciNuovo(Utente utenteInstance);

	public void rimuovi(Utente utenteInstance);

	public List<Utente> findByExample(Utente example);
	
	public Utente eseguiAccesso(String username, String password);
	
	public Utente getEager(long id);
	public Utente eseguiAccessoEager(String username, String password);

}