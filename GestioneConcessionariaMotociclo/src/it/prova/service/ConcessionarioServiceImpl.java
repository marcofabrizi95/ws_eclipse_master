package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.DAO.ConcessionarioDAO;
import it.prova.model.Concessionario;

@Component
public class ConcessionarioServiceImpl implements ConcessionarioService {
	
	@Autowired
	private ConcessionarioDAO concessionarioDAO;
	@Transactional(readOnly = true)
	public List<Concessionario> listAllConcessionari() {
		return concessionarioDAO.list();
	}

	@Transactional(readOnly = true)
	public Concessionario caricaSingoloConcessionario(Long id) {
		return concessionarioDAO.get(id);
	}

	@Transactional(readOnly = true)
	public Concessionario caricaSingoloConcessionarioEagerMotocicletta(Long idConcessionario) {
		return concessionarioDAO.get(idConcessionario);
	}

	@Transactional
	public void aggiorna(Concessionario concessionarioInstance) {
		concessionarioDAO.update(concessionarioInstance);

	}

	@Transactional
	public void inserisciNuovo(Concessionario concessionarioInstance) {
		concessionarioDAO.insert(concessionarioInstance);

	}

	@Transactional
	public void rimuovi(Concessionario concessionarioInstance) {
		concessionarioDAO.delete(concessionarioInstance);
	}

	@Transactional
	public List<Concessionario> findByExample(Concessionario example) {
		return concessionarioDAO.findByExample(example);
	}

	@Transactional
	public void refresh(Concessionario concessionarioInstance) {
		concessionarioDAO.refresh(concessionarioInstance);
	}

}
