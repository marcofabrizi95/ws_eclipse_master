package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriePrime;
import it.prova.model.StatoMateria;
@Component
public class VerniciaturaServiceImpl implements VerniciaturaService {

	@Override
	public void inVerniciatura(MateriePrime input) {
		input.setStato(StatoMateria.MESSA_IN_OPERA);
	}

}
