package it.prova.service;

import java.util.List;

import it.prova.model.Motocicletta;

public interface MotociclettaService {
	public List<Motocicletta> listAllMoto();

	public Motocicletta caricaSingolaMoto(Long id);

	public void aggiorna(Motocicletta motoInstance);

	public void inserisciNuova(Motocicletta motoInstance);

	public void rimuovi(Motocicletta motoInstance);

	public List<Motocicletta> findByExample(Motocicletta example);
	
	public void refresh(Motocicletta motoInstance);
	
	
}
