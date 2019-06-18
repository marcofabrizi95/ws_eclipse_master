package it.prova.ebay.dao;

import it.prova.ebay.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente> {

	public Utente executeLogin(String username,String password);
	public Utente getEager(Long id) ;
}
