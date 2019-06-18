package it.prova.ebay.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

@Entity
@Table(name = "annuncio")

public class Annuncio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean flag;
	private String testoAnnuncio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id", nullable = false)
	private Utente utente;
	private double prezzo;
	private Date anno;
	@ManyToMany
	@JoinTable(name = "annuncio_categoria", joinColumns = @JoinColumn(name = "annuncio_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "ID"))
	private Set<Categoria> categorie = new HashSet<Categoria>();
	
	
	
	
	public Annuncio() {
		super();
	}
	
	public Annuncio(boolean flag, String testoAnnuncio, Utente userInserimento, double prezzo, Date anno) {
		super();
		this.flag = flag;
		this.testoAnnuncio = testoAnnuncio;
		this.utente = userInserimento;
		this.prezzo = prezzo;
		this.anno = anno;
	}

	public Date getAnno() {
		return anno;
	}

	public void setAnno(Date anno) {
		this.anno = anno;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getTestoAnnuncio() {
		return testoAnnuncio;
	}
	public void setTestoAnnuncio(String testoAnnuncio) {
		this.testoAnnuncio = testoAnnuncio;
	}
	public Utente getUserInserimento() {
		return utente;
	}
	public void setUserInserimento(Utente userInserimento) {
		this.utente = userInserimento;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
	
}
