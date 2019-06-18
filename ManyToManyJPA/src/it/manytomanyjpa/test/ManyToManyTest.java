package it.manytomanyjpa.test;

import java.util.Date;

import it.manytomanyjpa.model.Ruolo;
import it.manytomanyjpa.model.Utente;
import it.manytomanyjpa.service.MyServiceFactory;
import it.manytomanyjpa.service.RuoloService;
import it.manytomanyjpa.service.UtenteService;

public class ManyToManyTest {

	public static void main(String[] args) {
		UtenteService utenteServiceInstance = MyServiceFactory.getUtenteServiceInstance();
		RuoloService ruoloServiceInstance = MyServiceFactory.getRuoloServiceInstance();

		// ora passo alle operazioni CRUD
		try {

			System.out.println("Elenca utenti: ");
			/*for (Utente utenteItem : utenteServiceInstance.listAll()) {
				System.out.println(utenteItem);
			}*/

			Utente utenteNuovo = new Utente("dennis", "bella", "faggianone", "mandile", new Date());
			utenteServiceInstance.inserisciNuovo(utenteNuovo);

			/*Ruolo ruoloNuovo = new Ruolo("Administrator","ROLE_ADMIN");
			ruoloServiceInstance.inserisciNuovo(ruoloNuovo);
			Ruolo ruoloNuovo2 = new Ruolo("Classic User","ROLE_CLASSIC_USER");
			ruoloServiceInstance.inserisciNuovo(ruoloNuovo2);*/

			Ruolo ruoloDaDb = ruoloServiceInstance.caricaSingoloElemento(2L);

			System.out.println(utenteServiceInstance.findAllByRuolo(ruoloDaDb));;
		/*	if (utenteDaDb != null) {
				utenteDaDb.getRuoli().add(ruoloDaDb);
			}
			
			utenteServiceInstance.aggiorna(utenteDaDb);*/

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
