package it.prova.gestionecartelleesattorialispringjpa.dto;

import java.util.HashMap;
import java.util.Map;

import it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale;
import it.prova.gestionecartelleesattorialispringjpa.model.Contribuente;

public class CartellaEsattorialeDTO {
	private Long id;
	private String denominazione;
	private String descrizione;
	private int importo;
	private Long idContribuente;
	
	
	public CartellaEsattorialeDTO() {
	}

	public CartellaEsattorialeDTO(Long id, String denominazione, String descrizione, int importo,
			Long contribuente) {
		super();
		this.id = id;
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
		this.idContribuente = contribuente;
	}

	public CartellaEsattorialeDTO(String denominazione, String descrizione, int importo, Long contribuente) {
		super();
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
		this.idContribuente = contribuente;
	}

	public CartellaEsattorialeDTO(String denominazione, String descrizione) {
		super();
		this.denominazione = denominazione;
		this.descrizione = descrizione;
	}
	
	public CartellaEsattorialeDTO(String denominazione, String descrizione, int importo) {
		super();
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getImporto() {
		return importo;
	}

	public void setImporto(int importo) {
		this.importo = importo;
	}

	public Long getContribuente() {
		return idContribuente;
	}

	public void setContribuente(Long contribuente) {
		this.idContribuente = contribuente;
	}
	public Map<String,String> validate(){
		Map<String,String> temp = new HashMap<String,String>();
		if(this.denominazione.equals("")||this.denominazione == null)
			temp.put("denominazione", "Riempi bene il campo denominazione");
		if(this.descrizione.equals("")||this.descrizione== null)
			temp.put("descrizione", "Riempi bene il campo descrizione");
		if(this.idContribuente<1)
			temp.put("idCont","scegli un Contribuente");
		if(this.importo<0)
			temp.put("importo", "Riempi bene il campo importo");
		return temp;
		}
	public static CartellaEsattorialeDTO buildCartellaEsattorialeDTOInstance(CartellaEsattoriale input) {
		CartellaEsattorialeDTO temp = new CartellaEsattorialeDTO();
		temp.setDenominazione(input.getDenominazione());
		temp.setDescrizione(input.getDescrizione());
		temp.setImporto(input.getImporto());
		temp.setId(input.getId());
		temp.setContribuente(input.getContribuente().getId());
		return temp;
		
	}
	public static CartellaEsattoriale buildCartellaEsattorialeInstance(CartellaEsattorialeDTO input) {
		CartellaEsattoriale temp = new CartellaEsattoriale();
		temp.setDenominazione(input.getDenominazione());
		temp.setDescrizione(input.getDescrizione());
		temp.setImporto(input.getImporto());
		temp.setId(input.getId());
		return temp;
		
	}
}
