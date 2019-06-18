package it.prova.test;

import it.prova.spring.MyServiceFactory;

public class Test {
	public static void main(String[] args) {
		MyServiceFactory.getCheckUpService().verficaSalute();
	}
}
