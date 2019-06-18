package it.prova.ebay.model.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.prova.ebay.model.Annuncio;
import it.prova.ebay.model.Ruolo;
import it.prova.ebay.model.Utente;

public class UtenteDTO {
	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private Date dataRegistrazione;
	public double creditoResiduo;
	private Set<Annuncio> annunci = new HashSet<Annuncio>();
	private Set<Ruolo> ruoli = new HashSet<>(0);
	
	public static Utente buildUtenteInstance(UtenteDTO input) {
		Utente result = new Utente();
		
		result.setNome(input.getNome());
		result.setCognome(input.getCognome());
		result.setUsername(input.getUsername());
		result.setPassword(input.getPassword());
		result.setCreditoResiduo(input.getCreditoResiduo());
		result.setAnnunci(input.getAnnunci());
		result.setRuoli(input.getRuoli());
		result.setId(input.getId());
		result.setDataRegistrazione(input.getDataRegistrazione());
		//result.setDataRegistrazione(input.getDataRegistrazione());
		
		return result;
	}
	
	public UtenteDTO() {
		super();
	}

	public static UtenteDTO buildUtenteDTOInstance(Utente input) {
		UtenteDTO result = new UtenteDTO();
		result.setId(input.getId());
		result.setDataRegistrazione(input.getDataRegistrazione());

		result.setNome(input.getNome());
		result.setCognome(input.getCognome());
		result.setUsername(input.getUsername());
		result.setPassword(input.getPassword());
		result.setCreditoResiduo(input.getCreditoResiduo());
		result.setAnnunci(input.getAnnunci());
		result.setRuoli(input.getRuoli());
		//result.setDataRegistrazione(input.getDataRegistrazione());
		
		return result;
	}
	

	public Map<String,String> validate(){
		Map<String,String> temp = new HashMap<String,String>();
		if(this.nome.equals(""))
			temp.put("nome", "Riempire bene il campo nome");
		if(this.cognome.equals(""))
			temp.put("cognome", "Riempire bene il campo cognome");
		if(this.username.equals(""))
			temp.put("username", "Riempire bene il campo username");
		if(this.password.equals(""))
			temp.put("password", "Riempire bene il campo password");
		if(this.creditoResiduo<0)
			temp.put("creditoResiduo", "Riempire bene il campo creditoResiduo");
		
		return temp;
		
	}
	
	public UtenteDTO(String nome, String cognome, String username, String password, Date dataRegistrazione,
			double creditoResiduo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataRegistrazione = dataRegistrazione;
		this.creditoResiduo = creditoResiduo;
	}

	public UtenteDTO(String nome, String cognome, String username, String password, Date dataRegistrazione) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataRegistrazione = dataRegistrazione;
	}

	public Set<Annuncio> getAnnunci() {
		return annunci;
	}

	public void setAnnunci(Set<Annuncio> annunci) {
		this.annunci = annunci;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public double getCreditoResiduo() {
		return creditoResiduo;
	}

	public void setCreditoResiduo(double creditoResiduo) {
		this.creditoResiduo = creditoResiduo;
	}

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}
}
