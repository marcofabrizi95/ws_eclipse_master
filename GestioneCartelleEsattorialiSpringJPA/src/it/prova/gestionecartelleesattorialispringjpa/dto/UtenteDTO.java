package it.prova.gestionecartelleesattorialispringjpa.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.prova.gestionecartelleesattorialispringjpa.model.Ruolo;
import it.prova.gestionecartelleesattorialispringjpa.model.Utente;

public class UtenteDTO {
	
	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private Date dataRegistrazione;
	private Set<Ruolo> ruoli = new HashSet<>(0);

	public UtenteDTO() {
	}

	public UtenteDTO(String nome, String cognome, String username, String password, Date dataRegistrazione) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataRegistrazione = dataRegistrazione;
	}

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
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
	public static Utente buildUtenteInstance(UtenteDTO input) {
		 
		Utente temp = new Utente();
		temp.setNome(input.getNome());
		temp.setCognome(input.getCognome());
		temp.setId(input.getId());
		temp.setDataRegistrazione(input.getDataRegistrazione());
		temp.setUsername(input.getUsername());
		temp.setPassword(input.getPassword());
		temp.setRuoli(input.getRuoli());
		return temp;
	}
	public static UtenteDTO buildUtenteDTOInstance(Utente input) {
		 
		UtenteDTO temp = new UtenteDTO();
		temp.setNome(input.getNome());
		temp.setCognome(input.getCognome());
		temp.setId(input.getId());
		temp.setDataRegistrazione(input.getDataRegistrazione());
		temp.setUsername(input.getUsername());
		temp.setPassword(input.getPassword());
		temp.setRuoli(input.getRuoli());
		return temp;
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
			temp.put("password","Riempire bene la password");
		return temp;
		
	}
}


