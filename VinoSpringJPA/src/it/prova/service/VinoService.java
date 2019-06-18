package it.prova.service;

import java.util.List;

import it.prova.model.Vino;


public interface VinoService {
	public List<Vino> cercaVinoByExample(Vino example);
	public Vino caricaVino(long idVinoInput);
	public void aggiorna(Vino VinoInstance);
	public void inserisciNuovo(Vino VinoInstance);
	public void rimuovi(Vino VinoInstance);
	public List<Vino> listAll();

}
