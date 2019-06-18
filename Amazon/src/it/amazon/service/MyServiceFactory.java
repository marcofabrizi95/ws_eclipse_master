package it.amazon.service;

import it.amazon.dao.ArticoloDAOImpl;
import it.amazon.dao.CategoriaDAOImpl;
import it.amazon.dao.OrdineDAOImpl;

public class MyServiceFactory {

	public static ArticoloService getArticoloServiceInstance() {
		ArticoloService articoloService = new ArticoloServiceImpl();
		articoloService.setArticoloDAO(new ArticoloDAOImpl());
		return articoloService;
	}

	public static OrdineService getOrdineServiceInstance() {
		OrdineService ordineService = new OrdineServiceImpl();
		ordineService.setOrdineDAO(new OrdineDAOImpl());
		return ordineService;
	}
	
	public static CategoriaService getCategoriaServiceInstance() {
		CategoriaService categoriaService = new CategoriaServiceImpl();
		categoriaService.setCategoriaDAO(new CategoriaDAOImpl());
		return categoriaService;
	}

}
