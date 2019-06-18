package it.prova.ebay.model.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.prova.ebay.model.Annuncio;
import it.prova.ebay.model.Categoria;
import it.prova.ebay.model.Utente;

public class AnnuncioDTO {
	private Long id;
	private String testoAnnuncio;
	private double prezzo;
	private boolean apertoChiuso;
	private Date dataAnnuncio;
	private Set<Categoria> categorie = new HashSet<Categoria>();
	private Utente utente;
	public AnnuncioDTO() {}
	
	public AnnuncioDTO(Long id, String testoAnnuncio, double prezzo, boolean apertoChiuso, Date dataAnnuncio,
			Set<Categoria> categorie, Utente utente) {
		super();
		this.id = id;
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
		this.apertoChiuso = apertoChiuso;
		this.dataAnnuncio = dataAnnuncio;
		this.categorie = categorie;
		this.utente = utente;
	}

	public AnnuncioDTO(String testoAnnuncio, double prezzo, boolean apertoChiuso, Date dataAnnuncio,
			Set<Categoria> categorie, Utente utente) {
		super();
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
		this.apertoChiuso = apertoChiuso;
		this.dataAnnuncio = dataAnnuncio;
		this.categorie = categorie;
		this.utente = utente;
	}
	
	
	public AnnuncioDTO(String testoAnnuncio, double prezzo) {
		super();
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
	}

	public static Annuncio buildAnnuncioInstance(AnnuncioDTO input) {
		Annuncio result = new Annuncio();
		
		result.setTestoAnnuncio(input.getTestoAnnuncio());
		result.setPrezzo(input.getPrezzo());
		result.setApertoChiuso(input.isApertoChiuso());
		result.setDataAnnuncio(input.getDataAnnuncio());
		result.setCategorie(input.getCategorie());
		result.setUtente(input.getUtente());
		result.setId(input.getId());

		return result;
		
	}
	
	public static AnnuncioDTO buildAnnuncioDTOInstance(Annuncio input) {
		AnnuncioDTO result = new AnnuncioDTO();
		
		result.setTestoAnnuncio(input.getTestoAnnuncio());
		result.setPrezzo(input.getPrezzo());
		result.setApertoChiuso(input.isApertoChiuso());
		result.setDataAnnuncio(input.getDataAnnuncio());
		result.setCategorie(input.getCategorie());
		result.setUtente(input.getUtente());
		result.setId(input.getId());

		return result;
		
	}
	
	
	public Map<String,String> validate(){
		Map<String,String> temp = new HashMap<String,String>();
		if(this.testoAnnuncio.equals(""))
			temp.put("testoAnnuncio", "Riempire bene il campo nome");
		if(this.prezzo<0)
			temp.put("prezzo", "Riempire bene il campo prezzo");
		if(this.categorie==null)
			temp.put("categorie","scegli almeno una categoria");
		return temp;
		
	}
	

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTestoAnnuncio() {
		return testoAnnuncio;
	}

	public void setTestoAnnuncio(String testoAnnuncio) {
		this.testoAnnuncio = testoAnnuncio;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public boolean isApertoChiuso() {
		return apertoChiuso;
	}

	public void setApertoChiuso(boolean apertoChiuso) {
		this.apertoChiuso = apertoChiuso;
	}

	public Date getDataAnnuncio() {
		return dataAnnuncio;
	}

	public void setDataAnnuncio(Date dataAnnuncio) {
		this.dataAnnuncio = dataAnnuncio;
	}
}
