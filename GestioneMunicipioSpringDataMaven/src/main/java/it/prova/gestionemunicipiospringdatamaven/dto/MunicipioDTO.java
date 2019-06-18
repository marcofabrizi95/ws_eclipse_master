package it.prova.gestionemunicipiospringdatamaven.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.prova.gestionemunicipiospringdatamaven.model.Abitante;
import it.prova.gestionemunicipiospringdatamaven.model.Municipio;

public class MunicipioDTO {
	private Long id;
	private String descrizione;
	private String codice;
	private String ubicazione;
	private Set<Abitante> abitanti = new HashSet<Abitante>();

	public MunicipioDTO() {
	}

	public MunicipioDTO(String descrizione, String codice, String ubicazione) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.ubicazione = ubicazione;
	}
	public static MunicipioDTO buildMunicipioDTOInstance(Municipio input) {
		MunicipioDTO result = new MunicipioDTO();
		result.setCodice(input.getCodice());
		result.setDescrizione(input.getDescrizione());
		result.setUbicazione(input.getUbicazione());
		result.setAbitanti(input.getAbitanti());
		result.setId(input.getId());
		return result;
	}
	public static Municipio buildMunicipioInstance(MunicipioDTO input) {
		Municipio result = new Municipio();
		result.setCodice(input.getCodice());
		result.setDescrizione(input.getDescrizione());
		result.setUbicazione(input.getUbicazione());
		result.setAbitanti(input.getAbitanti());
		result.setId(input.getId());
		return result;
	}
	public Map<String,String> validate(){
		Map<String,String> temp = new HashMap<String,String>();
		if(this.descrizione.equals(""))
			temp.put("descrizione", "Riempire bene il campo descrizione");
		if(this.codice.equals(""))
			temp.put("codice", "Riempire bene il campo codice");
		if(this.ubicazione.equals(""))
			temp.put("ubicazione","scegli almeno una ubicazione");
		return temp;
		
	}
	public Set<Abitante> getAbitanti() {
		return abitanti;
	}

	public void setAbitanti(Set<Abitante> abitanti) {
		this.abitanti = abitanti;
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

	public String getUbicazione() {
		return ubicazione;
	}

	public void setUbicazione(String ubicazione) {
		this.ubicazione = ubicazione;
	}

}
