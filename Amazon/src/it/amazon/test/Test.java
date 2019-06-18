package it.amazon.test;

import it.amazon.model.Articolo;
import it.amazon.model.Ordine;
import it.amazon.service.ArticoloService;
import it.amazon.service.MyServiceFactory;
import it.amazon.service.OrdineService;



public class Test {
	public static void main(String[] args) {
		ArticoloService art1 = MyServiceFactory.getArticoloServiceInstance();
		OrdineService ord = MyServiceFactory.getOrdineServiceInstance();
		Articolo art = new Articolo("pendrive" , 16);
		Ordine ord1 = new Ordine("marco","roma");
		ord1.getArticoli().add(art);
		try {
			ord.inserisciNuovo(ord1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
