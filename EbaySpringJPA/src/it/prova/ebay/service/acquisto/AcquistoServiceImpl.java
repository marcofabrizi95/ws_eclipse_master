package it.prova.ebay.service.acquisto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebay.dao.acquisto.AcquistoDAO;
import it.prova.ebay.model.Acquisto;
import it.prova.ebay.model.Annuncio;
import it.prova.ebay.model.Utente;
import it.prova.ebay.service.annuncio.AnnuncioService;
import it.prova.ebay.service.utente.UtenteService;
@Component
public class AcquistoServiceImpl implements AcquistoService {
	
	@Autowired
	private AcquistoDAO acquistoDAO;
	@Autowired
	private AnnuncioService annuncioService;
	@Autowired
	private UtenteService utenteService;

	@Transactional(readOnly = true)
	public List<Acquisto> list() {
		return acquistoDAO.list();
	}

	@Transactional(readOnly = true)
	public Acquisto get(long id) {
		return acquistoDAO.get(id);
	}

	@Transactional
	public void update(Acquisto o) {
		acquistoDAO.update(o);
	}

	@Transactional
	public void insert(Acquisto o) {
		acquistoDAO.insert(o);
	}

	@Transactional
	public void delete(Acquisto o) {
		acquistoDAO.delete(o);
	}

	@Transactional
	public List<Acquisto> findByExample(Acquisto o) {
		return acquistoDAO.findByExample(o);
	}
	@Transactional
	public boolean eseguiAcquisto(long annuncioId,long userId) {
		Annuncio annuncioTemp = annuncioService.getEager(annuncioId);
		Utente utenteTemp = utenteService.getEager(userId);
		if(utenteTemp.getCreditoResiduo()<annuncioTemp.getPrezzo())
			return false;
		
		utenteTemp.setCreditoResiduo(utenteTemp.getCreditoResiduo()-annuncioTemp.getPrezzo());
		annuncioTemp.setApertoChiuso(false);
		
		Acquisto acquistoTemp = new Acquisto(annuncioTemp.getTestoAnnuncio(), 2019, annuncioTemp.getPrezzo(), utenteTemp);
		utenteTemp.getAcquisti().add(acquistoTemp);
		acquistoDAO.insert(acquistoTemp);
		utenteService.aggiorna(utenteTemp);
		annuncioService.update(annuncioTemp);
		return true;
	}
}
