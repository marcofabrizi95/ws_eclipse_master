package it.prova.test;

import it.prova.model.Esame;
import it.prova.model.Studente;
import it.prova.service.EsameService;
import it.prova.spring.MyServiceFactory;

public class EsameTest {

	public static void main(String[] args) {
		EsameService esameService = MyServiceFactory.getEsameService();

		Esame esame = esameService.caricaEsame(1);
		Esame esame2= new Esame(2,"maturita");
		esameService.addEsame(esame2);

		// aggiungo uno studente
		Studente studente = new Studente("Antonio", "Mollo");
		
		// aggiungo lo studente all'esame caricato in tabella
		esameService.aggiungiStudenteAdEsame(studente, esame2);

		// avvio
		esameService.avviaEsame(esame2);
	}

}
