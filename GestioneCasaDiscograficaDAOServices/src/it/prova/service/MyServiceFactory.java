package it.prova.service;


import it.prova.dao.AutoreDAOImpl;
import it.prova.dao.CasaDiscograficaDAOImpl;
import it.prova.dao.CdDAOImpl;
import it.prova.service.user.AutoreService;
import it.prova.service.user.AutoreServiceImpl;
import it.prova.service.user.CasaDiscograficaService;
import it.prova.service.user.CasaDiscograficaServiceImpl;
import it.prova.service.user.CdService;
import it.prova.service.user.CdServiceImpl;


public class MyServiceFactory {
	
	public static CasaDiscograficaService getCasaDiscograficaServiceImpl() {
		CasaDiscograficaService casaDiscograficaService = new CasaDiscograficaServiceImpl();
		casaDiscograficaService.setCasaDIscograficaDAO(new CasaDiscograficaDAOImpl());
		casaDiscograficaService.setAutoreDAO(new AutoreDAOImpl());
		casaDiscograficaService.setCdDao(new CdDAOImpl());
		return casaDiscograficaService;
	}
	public static AutoreService getAutoreServiceImpl() {
		AutoreService autoreService = new AutoreServiceImpl();
		autoreService.setAutoreDAO(new AutoreDAOImpl());
		autoreService.setCdDao(new CdDAOImpl());
		return autoreService;
	}
	public static CdService getCdServiceImpl() {
		CdService cdService = new CdServiceImpl();
		cdService.setCdDAO(new CdDAOImpl());
		return cdService;
	}


}
