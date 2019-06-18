package it.prova.test;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;

public class test {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		AbitanteService m = MyServiceFactory.getAbitanteServiceInstance();
		Abitante a = m.get(1L);
			System.out.println(a);
			
		}
	

}
