package it.amazon.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descrizione;
	@ManyToMany(mappedBy = "categorie")//nome della proprieta set 
	private Set<Articolo> articoli = new HashSet<>();
	
	
		
	public Categoria() {
		super();
	}
	public Categoria(String descrizione) {
		super();
		this.descrizione = descrizione;
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
	public Set<Articolo> getArticoli() {
		return articoli;
	}
	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}
	public void addArticolo(Articolo input) {
		this.articoli.add(input);
		input.getCategorie().add(this);
	}
	public void removeArticolo(Articolo input) {
		this.articoli.remove(input);
		input.getCategorie().remove(this);
	}
	
	
}
