package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public interface AbitanteService {
	public void setAbitanteDAO(AbitanteDAO abitanteDAO);
	public List<Abitante> cercaPerNomeECognome(String nome, String cognome) ;
	public List<Abitante> listAllAbitante() throws Exception;
	public Abitante get(Long id) throws Exception;
	public int insert(Abitante utenteInput) throws Exception;
	public int update(Abitante utenteInput) throws Exception;
	public List<Abitante> findByExample(Abitante input) throws Exception;
	public int delete(Abitante utenteInput) throws Exception;
	
}
