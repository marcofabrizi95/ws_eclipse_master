package it.prova.gestionecartellaesattoriale.dao.utente;

import it.prova.gestionecartellaesattoriale.dao.IBaseDAO;
import it.prova.gestionecartellaesattoriale.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente> {

	public Utente executeLogin(String username,String password);
}
