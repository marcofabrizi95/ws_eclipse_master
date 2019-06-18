package it.prova.service.user;

import java.util.List;

import it.prova.dao.CdDAO;
import it.prova.model.Autore;
import it.prova.model.Cd;

public interface CdService {
	public Cd findCdById(Long idInput) throws Exception;
	public void setCdDAO(CdDAO CdDao);
	public int rimuoviCd(Cd input) throws Exception;
	public int aggiornaCd(Cd input) throws Exception;
	public int inserisciNuovoCd(Cd input) throws Exception;
	public List<Cd> listAllAutore() throws Exception;
	public List<Cd> findByExample(Cd input) throws Exception;
	public List<Cd> findAllByGenere(String genere) throws Exception ;
	public List<Cd> findAllByAutoreWhereTitoloIniziaCon(Autore autoreInput, String iniziale) throws Exception ;






}
