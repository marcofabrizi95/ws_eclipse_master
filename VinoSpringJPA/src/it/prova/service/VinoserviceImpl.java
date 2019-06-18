package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.dao.VinoDAO;
import it.prova.model.Vino;
@Component
public class VinoserviceImpl implements VinoService{

	@Autowired
	private VinoDAO vinoDAO;

	@Transactional(readOnly = true)
	public List<Vino> cercaVinoByExample(Vino example) {
		return vinoDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public Vino caricaVino(long idVinoInput) {
		return vinoDAO.get(idVinoInput);
	}

	@Transactional
	public void aggiorna(Vino vinoInstance) {
		vinoDAO.update(vinoInstance);
	}

	@Transactional
	public void inserisciNuovo(Vino vinoInstance) {
		vinoDAO.insert(vinoInstance);
		
	}

	@Transactional
	public void rimuovi(Vino vinoInstance) {
		vinoDAO.delete(vinoInstance);
	}

	@Transactional(readOnly = true)
	public List<Vino> listAll() {
		return vinoDAO.list();
	}
}
