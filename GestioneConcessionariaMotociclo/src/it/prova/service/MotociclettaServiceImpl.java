package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.DAO.MotociclettaDAO;
import it.prova.model.Motocicletta;
@Component
public class MotociclettaServiceImpl implements MotociclettaService {
	@Autowired
	private MotociclettaDAO motociclettaDAO;
	
	@Transactional(readOnly = true)
	public List<Motocicletta> listAllMoto() {
		return motociclettaDAO.list();
	}

	@Transactional(readOnly = true)
	public Motocicletta caricaSingolaMoto(Long id) {
		return motociclettaDAO.get(id);
	}

	@Transactional
	public void aggiorna(Motocicletta motoInstance) {
		motociclettaDAO.update(motoInstance);
	}

	@Transactional
	public void inserisciNuova(Motocicletta motoInstance) {
		motociclettaDAO.insert(motoInstance);

	}

	@Transactional
	public void rimuovi(Motocicletta motoInstance) {
		motociclettaDAO.delete(motoInstance);
	}

	@Transactional
	public List<Motocicletta> findByExample(Motocicletta example) {
		return motociclettaDAO.findByExample(example);
	}

	@Transactional
	public void refresh(Motocicletta motoInstance) {
		motociclettaDAO.refresh(motoInstance);
	}

}
