package it.prova.ebay.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	private String descrizione;
	private String codice;
	@ManyToMany
	@JoinTable(name = "annuncio_categoria", joinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "annuncio_id", referencedColumnName = "ID"))
	private Set<Annuncio> annuncio = new HashSet<>(0);
	
	
	public Categoria() {}


	public Categoria(Long id, String descrizione, String codice) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
	}


	public Categoria(String descrizione, String codice, Set<Annuncio> annuncio) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.annuncio = annuncio;
	}
	public Categoria(Annuncio annuncio) {
		this.annuncio.add(annuncio);
	}

	public Set<Annuncio> getAnnuncio() {
		return annuncio;
	}


	public void setAnnuncio(Set<Annuncio> annuncio) {
		this.annuncio = annuncio;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public String getCodice() {
		return codice;
	}


	public void setCodice(String codice) {
		this.codice = codice;
	}

}
