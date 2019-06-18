package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriePrime;
import it.prova.model.StatoMateria;
@Component
public class LavorazioneServiceImpl implements LavorazioneService {

	@Override
	public void lavoraMateria(MateriePrime input) {
		 input.setStato(StatoMateria.IN_ASSEMBLAGGIO);
	}
	
}
