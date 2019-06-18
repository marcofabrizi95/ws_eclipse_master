package it.negozioarticolo.test;

import java.util.List;

import it.negozioarticolo.model.Negozio;
import it.negozioarticolo.service.ArticoloService;
import it.negozioarticolo.service.MyServiceFactory;
import it.negozioarticolo.service.NegozioService;


public class Test {

	public static void main(String[] args) {
		 try {
   
			 NegozioService negozioService = MyServiceFactory.getNegozioServiceInstance();
			 ArticoloService articoloService = MyServiceFactory.getArticoloServiceInstance();
			 negozioService.listAllNegozi();
			 
			 Negozio n = new Negozio("nikestore", "via mosca"	, null);
			 
			 negozioService.inserisciNuovo(n);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
