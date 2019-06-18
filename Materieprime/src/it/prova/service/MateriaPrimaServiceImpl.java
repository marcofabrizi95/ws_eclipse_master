package it.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.dao.MateriePrimeDao;
import it.prova.model.MateriePrime;
@Component
public class MateriaPrimaServiceImpl implements MateriaPrimaService {
	@Autowired
	private AssemblaggioService assemblaggioService;
	@Autowired
	private LavorazioneService lavorazioneService;
	@Autowired
	private VerniciaturaService verniciaturaService;
	@Autowired
	private MessaInOperaService messaInOperaService;
	@Autowired
	private MateriePrimeDao materiePrimeDao;
	@Override
	public void lavorazioneCompleta(MateriePrime input) {
		System.out.println("inizio lavorazione");
		lavorazioneService.lavoraMateria(input);
		assemblaggioService.inAssemblaggio(input);
		verniciaturaService.inVerniciatura(input);
		messaInOperaService.inOpera(input);
		System.out.println("fine lavorazione");
		
	}
	public AssemblaggioService getAssemblaggioService() {
		return assemblaggioService;
	}
	public void setAssemblaggioService(AssemblaggioService assemblaggioService) {
		this.assemblaggioService = assemblaggioService;
	}
	public LavorazioneService getLavorazioneService() {
		return lavorazioneService;
	}
	public void setLavorazioneService(LavorazioneService lavorazioneService) {
		this.lavorazioneService = lavorazioneService;
	}
	public VerniciaturaService getVerniciaturaService() {
		return verniciaturaService;
	}
	public void setVerniciaturaService(VerniciaturaService verniciaturaService) {
		this.verniciaturaService = verniciaturaService;
	}
	public MessaInOperaService getMessaInOperaService() {
		return messaInOperaService;
	}
	public void setMessaInOperaService(MessaInOperaService messaInOperaService) {
		this.messaInOperaService = messaInOperaService;
	}
	public MateriePrimeDao getMateriePrimeDao() {
		return materiePrimeDao;
	}
	public void setMateriePrimeDao(MateriePrimeDao materiePrimeDao) {
		this.materiePrimeDao = materiePrimeDao;
	}
	@Override
	public MateriePrime get(Long id) {
		return materiePrimeDao.get(id);
	}
	@Override
	public void addMateriePrime(MateriePrime input) {
		materiePrimeDao.addMateriePrime(input);
		
	}
	

}
