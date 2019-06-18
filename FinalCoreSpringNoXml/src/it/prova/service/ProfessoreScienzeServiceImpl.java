package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.Studente;

@Component
public class ProfessoreScienzeServiceImpl implements ProfessoreScienzeService {

	@Override
	public void esaminaInScienze(Studente input) {
		System.out.println("Interrogazioni di scienze allo studente "+input+ " effettuate...");
		
	}

}
