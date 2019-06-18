package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriePrime;
import it.prova.model.StatoMateria;
@Component
public class MessaInOperaServiceImpl implements MessaInOperaService{

	@Override
	public void inOpera(MateriePrime input) {
		input.setStato(StatoMateria.PRONTA);

		
	}

	

}
