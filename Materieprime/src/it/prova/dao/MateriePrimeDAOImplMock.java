package it.prova.dao;

import org.springframework.stereotype.Component;

import it.prova.model.MateriePrime;
@Component
public class MateriePrimeDAOImplMock implements MateriePrimeDao {

	@Override
	public MateriePrime get(Long id) {
		if (id < 1)
			return null;
		for (MateriePrime item : DbMock.MATERIE) {
			if (item.getId() == id)
				return item;

		}
		return null;

	}

	@Override
	public void addMateriePrime(MateriePrime input) {
		if((input!=null)&&(input instanceof MateriePrime))
			DbMock.MATERIE.add(input);
		else System.out.println("Input non valido");
	}

}
