package it.prova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vino {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String localita;
	private String cantina;
	private String uva;
	private Integer annata;
	
	
	
	
	
	public Vino(String nome, String cantina, String uva, String localita) {
		super();
		this.nome = nome;
		this.localita = localita;
		this.cantina = cantina;
		this.uva = uva;
	}
	public Vino() {
		super();
	}
	public Vino(String nome, String cantina, String uva, String localita, Integer annata) {
		super();
		this.nome = nome;
		this.localita = localita;
		this.cantina = cantina;
		this.uva = uva;
		this.annata = annata;
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
	public String getLocalita() {
		return localita;
	}
	public void setLocalita(String localita) {
		this.localita = localita;
	}
	public String getCantina() {
		return cantina;
	}
	public void setCantina(String cantina) {
		this.cantina = cantina;
	}
	public String getUva() {
		return uva;
	}
	public void setUva(String uva) {
		this.uva = uva;
	}
	public Integer getAnnata() {
		return annata;
	}
	public void setAnnata(Integer annata) {
		this.annata = annata;
	}

}
