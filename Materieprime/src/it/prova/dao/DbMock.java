package it.prova.dao;

import java.util.ArrayList;
import java.util.List;

import it.prova.model.MateriePrime;
import it.prova.model.StatoMateria;

public class DbMock {
	
	public static final List<MateriePrime> MATERIE = new ArrayList<MateriePrime>();
	
	static {
		MateriePrime m1 = new MateriePrime(1L,"ferro",StatoMateria.IN_INSERIMENTO);
		MateriePrime m2 = new MateriePrime(2L,"legno",StatoMateria.IN_INSERIMENTO);
		MateriePrime m3 = new MateriePrime(3L,"rame",StatoMateria.IN_INSERIMENTO);
		MATERIE.add(m1);
		MATERIE.add(m2);
		MATERIE.add(m3);




		
		
	}

}
