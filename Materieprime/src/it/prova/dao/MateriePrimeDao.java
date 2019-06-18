package it.prova.dao;

import it.prova.model.MateriePrime;

public interface MateriePrimeDao {
	public MateriePrime get(Long id);
	public void addMateriePrime(MateriePrime input);

}
