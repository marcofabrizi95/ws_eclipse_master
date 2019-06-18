package it.prova.dao;

import java.util.List;

import it.prova.model.CasaDiscografica;

public interface CasaDiscograficaDAO extends IBaseDAO<CasaDiscografica>{
	public void populateAutore(CasaDiscografica input) throws Exception;
	public List<CasaDiscografica> findAllByAutoreWhereCognomeIniziaCon(String iniziale) throws Exception;
	public List <CasaDiscografica> findAllByCdWhereGenereEqual(String genere) throws Exception;
}
