package it.prova.test;

import it.prova.dao.*;
import it.prova.model.*;

public class TestDB {
	public static void main(String[] args) {
		CdDAO cdDao= new CdDAO();
		AutoreDAO autoreDao = new AutoreDAO();
		CasaDiscograficaDAO casaDiscoGraficaDao = new CasaDiscograficaDAO();
		CasaDiscografica empire = new CasaDiscografica("Empire","hfoshfog");
		Autore autore1 = new Autore("toto","cotugno",casaDiscoGraficaDao.selectById(2L));
		Autore autore = autoreDao.selectById(2L);
		Cd cdToto = new Cd("best of ",autore,"modiale",14);
		
		//casaDiscoGraficaDao.insert(empire);
		
		//autoreDao.insert(autore1);
		System.out.println(cdDao.insert(cdToto));
				
	}
}
