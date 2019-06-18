package it.negozioarticolo.dao;


public class MyDaoFactory {
	
	public static ArticoloDAO getArticoloDAOInstance(){
		return new ArticoloDAOImpl();
	}
	
	public static NegozioDAO getNegozioDAOInstance(){
		return new NegozioDAOImpl();
	}

}
