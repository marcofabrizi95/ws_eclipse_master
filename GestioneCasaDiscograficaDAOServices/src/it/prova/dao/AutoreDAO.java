package it.prova.dao;


import java.util.List;

import it.prova.model.Autore;
import it.prova.model.CasaDiscografica;

public interface AutoreDAO extends IBaseDAO<Autore> {
	
	public void populateCd(Autore input) throws Exception;
	public List <Autore> findAllByCasaDiscografica(CasaDiscografica input) throws Exception;
	public List <Autore> findBbyCdWhereNTracceGreaterThan(int nTracceInput) throws Exception;

}
