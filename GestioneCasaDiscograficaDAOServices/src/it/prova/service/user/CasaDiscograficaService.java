package it.prova.service.user;

import java.util.List;

import it.prova.dao.AutoreDAO;
import it.prova.dao.CasaDiscograficaDAO;
import it.prova.dao.CdDAO;
import it.prova.model.CasaDiscografica;


public interface CasaDiscograficaService {
	public CasaDiscografica findCasadiscograficaById(Long idInput) throws Exception;
	public void setCasaDIscograficaDAO(CasaDiscograficaDAO casaDiscograficaDAO);
	public void setAutoreDAO(AutoreDAO autoreDAO);
	public void setCdDao(CdDAO cdDao);
	public int rimuoviCasaDiscografica(CasaDiscografica input) throws Exception;
	public int aggiornaUser(CasaDiscografica input) throws Exception;
	public int inserisciNuovoCasaDicografica(CasaDiscografica input) throws Exception;
	public List<CasaDiscografica> listAllCasaDiscografica() throws Exception;
	public List<CasaDiscografica> findByExample(CasaDiscografica input) throws Exception;
	public void aggiungiAutori(CasaDiscografica input) throws Exception;
	public void deleteCascade(CasaDiscografica input) throws Exception;
	public List<CasaDiscografica> findAllByAutoreWhereCognomeIniziaCon(String iniziale) throws Exception;
	public List <CasaDiscografica> findAllByCdWhereGenereEqual(String genere) throws Exception;
	
}
