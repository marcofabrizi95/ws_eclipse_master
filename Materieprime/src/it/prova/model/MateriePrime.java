package it.prova.model;

public class MateriePrime {
	private Long id;
	private String descrizione;
	private StatoMateria stato;
	
	public MateriePrime() {};
	
	
	@Override
	public String toString() {
		return "MateriePrime [id=" + id + ", descrizione=" + descrizione + ", stato=" + stato + "]";
	}


	public MateriePrime(Long id, String descrizione, StatoMateria stato) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.stato = stato;
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
	public StatoMateria getStato() {
		return stato;
	}
	public void setStato(StatoMateria stato) {
		this.stato = stato;
	}
	
	
}
