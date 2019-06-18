package it.prova.service;

import it.prova.model.MateriePrime;

public interface MateriaPrimaService {
	void lavorazioneCompleta(MateriePrime input);
	public MateriePrime get(Long id);
	public void addMateriePrime(MateriePrime input);
}
