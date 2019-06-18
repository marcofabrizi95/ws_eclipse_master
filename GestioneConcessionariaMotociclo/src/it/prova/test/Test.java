package it.prova.test;

import it.prova.service.BatteriaDiTestService;
import it.prova.service.MyServiceFactory;

public class Test {
	public static void main(String[] args) {
		String casoDaTestare = BatteriaDiTestService.INSERISCI_NUOVO_CONCESSIONARIO;
		
		System.out.println("################ START   #################");
		System.out.println("################ eseguo il test " + casoDaTestare
				+ "  #################");

		MyServiceFactory.getBatteriaDiTestServiceInstance()
				.eseguiBatteriaDiTest(casoDaTestare);

		System.out.println("################ FINE   #################");

	}
}
