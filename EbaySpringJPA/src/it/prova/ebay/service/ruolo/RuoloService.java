package it.prova.ebay.service.ruolo;

import java.util.List;

import it.prova.ebay.dao.ruolo.RuoloDAO;
import it.prova.ebay.model.Ruolo;

public interface RuoloService {
	public List<Ruolo> listAll() ;

	public Ruolo caricaSingoloElemento(Long id) ;

	public void aggiorna(Ruolo ruoloInstance) ;

	public void inserisciNuovo(Ruolo ruoloInstance) ;

	public void rimuovi(Ruolo ruoloInstance) ;

	public List<Ruolo> findByExample(Ruolo example) ;

	// per injection
	public void setRuoloDAO(RuoloDAO ruoloDAO);
}
