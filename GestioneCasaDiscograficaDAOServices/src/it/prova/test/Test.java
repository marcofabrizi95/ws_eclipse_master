package it.prova.test;

import it.prova.model.Autore;
import it.prova.model.CasaDiscografica;
import it.prova.model.Cd;
import it.prova.service.MyServiceFactory;
import it.prova.service.user.AutoreService;
import it.prova.service.user.CasaDiscograficaService;
import it.prova.service.user.CasaDiscograficaServiceImpl;
import it.prova.service.user.CdService;
import it.prova.service.user.CdServiceImpl;

public class Test {
	public static void main(String[] args) {

		CdService cd1 = MyServiceFactory.getCdServiceImpl();
		AutoreService a1= MyServiceFactory.getAutoreServiceImpl();
		try {
			
//			Cd cd = MyServiceFactory.getCdServiceImpl().findCdById(8L);
			Cd cd = cd1.findCdById(10L);
			System.out.println(cd.getAutore().getId());
			Autore a = a1.findAutoreById(cd.getAutore().getId());
			System.out.println(cd);
			System.out.println(a);
			cd.setTitolo("belladue");
			cd1.aggiornaCd(cd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
