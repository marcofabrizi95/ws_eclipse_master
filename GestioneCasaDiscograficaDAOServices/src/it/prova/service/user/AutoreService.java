package it.prova.service.user;

import java.util.List;

import it.prova.dao.AutoreDAO;
import it.prova.dao.CdDAO;
import it.prova.model.Autore;
import it.prova.model.CasaDiscografica;

public interface AutoreService {
	public Autore findAutoreById(Long idInput) throws Exception;
	public void setAutoreDAO(AutoreDAO autoreDao);
	public int rimuoviAutore(Autore input) throws Exception;
	public int aggiornaAutore(Autore input) throws Exception;
	public int inserisciNuovoAutore(Autore input) throws Exception;
	public List<Autore> listAllAutore() throws Exception;
	public List<Autore> findByExample(Autore input) throws Exception;
	public void aggiungiCd(Autore input) throws Exception;
	public void deleteCascade(Autore input) throws Exception;
	public void setCdDao(CdDAO cdDao);
	public List <Autore> findAllByCasaDiscografica(CasaDiscografica input) throws Exception;
	public List<Autore> findBbyCdWhereNTracceGreaterThan(int nTracceInput) throws Exception;
}
