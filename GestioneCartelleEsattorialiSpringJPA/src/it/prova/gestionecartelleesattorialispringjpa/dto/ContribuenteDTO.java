package it.prova.gestionecartelleesattorialispringjpa.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale;
import it.prova.gestionecartelleesattorialispringjpa.model.Contribuente;

public class ContribuenteDTO {
	private Long id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String indirizzo;
	private Set<CartellaEsattoriale> cartelleEsattoriali = new HashSet<>();

	public ContribuenteDTO(Long id, String nome, String cognome, String codiceFiscale, String indirizzo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
	}

	public ContribuenteDTO(String nome, String cognome, String codiceFiscale, String indirizzo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
	}

	
	public ContribuenteDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Set<CartellaEsattoriale> getCartelleEsattoriali() {
		return cartelleEsattoriali;
	}

	public void setCartelleEsattoriali(Set<CartellaEsattoriale> cartelleEsattoriali) {
		this.cartelleEsattoriali = cartelleEsattoriali;
	}

	public Map<String,String> validate(){
		Map<String,String> temp = new HashMap<String,String>();
		if(this.nome.equals(""))
			temp.put("nome", "Riempire bene il campo nome");
		if(this.cognome.equals(""))
			temp.put("cognome", "Riempire bene il campo cognome");
		if(this.indirizzo.equals(""))
			temp.put("indirizzo", "Riempire bene il campo indirizzo");
		if(this.codiceFiscale.equals("")|| this.codiceFiscale.length()>16)
			temp.put("codiceFiscale","Riempire bene il campo codice fiscale");
		return temp;
		
	}
	
	public static ContribuenteDTO buildContribuenteDTOInstance(Contribuente input) {
		ContribuenteDTO temp = new ContribuenteDTO();
		temp.setId(input.getId());
		temp.setNome(input.getNome());
		temp.setCognome(input.getCognome());
		temp.setCodiceFiscale(input.getCodiceFiscale());
		temp.setIndirizzo(input.getIndirizzo());
		temp.setCartelleEsattoriali(input.getCartelleEsattoriali());
		return temp;
		
	}
	
	public static Contribuente buildContribuenteInstance(ContribuenteDTO input) {
		Contribuente temp = new Contribuente();
		temp.setId(input.getId());
		temp.setNome(input.getNome());
		temp.setCognome(input.getCognome());
		temp.setCodiceFiscale(input.getCodiceFiscale());
		temp.setIndirizzo(input.getIndirizzo());
		temp.setCartelleEsattoriali(input.getCartelleEsattoriali());
		return temp;
	}
}
