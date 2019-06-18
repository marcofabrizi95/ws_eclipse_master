package it.municipioabitantejpa.service.municipio;

import java.util.List;

import it.municipioabitantejpa.dao.municipio.MunicipioDAO;
import it.municipioabitantejpa.model.Municipio;

public interface MunicipioService {
	
	public List<Municipio> listAllMunicipi() throws Exception;

	public Municipio caricaSingoloMunicipio(long id) throws Exception;

	public void aggiorna(Municipio municipioInstance) throws Exception;

	public void inserisciNuovo(Municipio municipioInstance) throws Exception;

	public void rimuovi(Municipio municipioInstance) throws Exception;

	public List<Municipio> findByExample(Municipio example) throws Exception;

	//per injection
	public void setMunicipioDAO(MunicipioDAO municipioDAO);
	public List <Municipio> findAlAbitantiMinorenni()throws Exception;
	public List <Municipio> findAllIniziaCon(String input)throws Exception;

}
