package it.prova.service;

import java.util.List;

import it.prova.model.Concessionario;

public interface ConcessionarioService {

	public List<Concessionario> listAllConcessionari();

	public Concessionario caricaSingoloConcessionario(Long id);

	public Concessionario caricaSingoloConcessionarioEagerMotocicletta(Long idConcessionario);

	public void aggiorna(Concessionario concessionarioInstance);

	public void inserisciNuovo(Concessionario concessionarioInstance);

	public void rimuovi(Concessionario concessionarioInstance);

	public List<Concessionario> findByExample(Concessionario example);

	public void refresh(Concessionario concessionarioInstance);
}
