package it.prova.ebay.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "annuncio")
public class Annuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id")
	private Long id;
	private String testoAnnuncio;
	private double prezzo;
	@Override
	public String toString() {
		return "Annuncio [id=" + id + ", testoAnnuncio=" + testoAnnuncio + ", prezzo=" + prezzo + "]";
	}

	private boolean apertoChiuso;
	@Temporal(TemporalType.DATE)
	private Date dataAnnuncio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id", nullable = false)
	private Utente utente;
	
	@ManyToMany
	@JoinTable(name = "annuncio_categoria", joinColumns = @JoinColumn(name = "annuncio_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "ID"))
	private Set<Categoria> categorie = new HashSet<>(0);
	
	public Annuncio() {}

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

	
	
	
	
}
