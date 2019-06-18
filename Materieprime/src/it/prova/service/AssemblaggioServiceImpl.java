package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriePrime;
import it.prova.model.StatoMateria;
@Component
public class AssemblaggioServiceImpl implements AssemblaggioService {

	@Override
	public void inAssemblaggio(MateriePrime input) {
		input.setStato(StatoMateria.IN_VERNICIATURA);
	}
	
}
