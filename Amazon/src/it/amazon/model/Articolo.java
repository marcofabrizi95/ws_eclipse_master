package it.amazon.model;

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


@Entity
public class Articolo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descrizione;
	private Integer prezzo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	private Ordine ordine;
	@ManyToMany
	@JoinTable(name = "articolo_categoria", joinColumns = @JoinColumn(name = "articolo_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "id"))
	private Set<Categoria> categorie = new HashSet<>(0);
	
	public Articolo() {
		super();
	}
	
	public Articolo(String descrizione, Integer prezzo) {
		super();
		this.descrizione = descrizione;
		this.prezzo = prezzo;
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


	public Integer getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}


	public Ordine getOrdine() {
		return ordine;
	}


	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}


	public Set<Categoria> getCategorie() {
		return categorie;
	}


	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}


	

	


	@Override
	public String toString() {
		return "Articolo [id=" + id + ", descrizione=" + descrizione + ", prezzo=" + prezzo + "]";
	}
	

}
