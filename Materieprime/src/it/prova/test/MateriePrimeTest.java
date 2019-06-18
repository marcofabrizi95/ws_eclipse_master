package it.prova.test;


import it.prova.model.MateriePrime;
import it.prova.model.StatoMateria;
import it.prova.service.MateriaPrimaService;
import it.prova.service.MateriaPrimaServiceImpl;
import it.prova.spring.MyServiceFactory;

public class MateriePrimeTest {
	public static void main(String[] args) {
		MateriaPrimaService materiaService = MyServiceFactory.getMateriaPrimaService(); 
		
		
		MateriePrime materia1 = materiaService.get(1L);
		
		System.out.println(materia1);
	}
}
