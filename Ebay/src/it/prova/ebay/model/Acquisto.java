package it.prova.ebay.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "acquisto")

public class Acquisto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String testoAcquisto;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id", nullable = false)
	private Utente utente;
	private double prezzo;
	private int anno;
	
	
	
	
	public Acquisto() {
		super();
	}
	public Acquisto(String testoAcquisto, Utente userAcquisto, double prezzo, int anno) {
		super();
		this.testoAcquisto = testoAcquisto;
		this.utente = userAcquisto;
		this.prezzo = prezzo;
		this.anno = anno;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTestoAcquisto() {
		return testoAcquisto;
	}
	public void setTestoAcquisto(String testoAcquisto) {
		this.testoAcquisto = testoAcquisto;
	}
	public Utente getUserAcquisto() {
		return utente;
	}
	public void setUserAcquisto(Utente userAcquisto) {
		this.utente = userAcquisto;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	
	
	
}
