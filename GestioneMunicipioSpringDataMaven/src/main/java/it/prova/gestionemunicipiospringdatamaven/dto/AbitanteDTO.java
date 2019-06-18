package it.prova.gestionemunicipiospringdatamaven.dto;

import java.util.HashMap;
import java.util.Map;

import it.prova.gestionemunicipiospringdatamaven.model.Abitante;
import it.prova.gestionemunicipiospringdatamaven.model.Municipio;

public class AbitanteDTO {
	private Long id;
	private String nome;
	private String cognome;
	private Integer eta;
	private String residenza;
	private Municipio municipio;

	public AbitanteDTO() {

	}

	public AbitanteDTO(String nome, String cognome, Integer eta, String residenza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.residenza = residenza;
	}
	
	public AbitanteDTO(String nome, String cognome, Integer eta, String residenza, Municipio municipio) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.residenza = residenza;
		this.municipio = municipio;
	}

	public static AbitanteDTO buildAbitanteDTOInstance(Abitante input) {
		AbitanteDTO result = new AbitanteDTO();
		result.setCognome(input.getCognome());
		result.setNome(input.getNome());
		result.setEta(input.getEta());
		result.setResidenza(input.getResidenza());
		result.setMunicipio(input.getMunicipio());
		result.setId(input.getId());
		return result;
	}
	public static Abitante buildAbitanteInstance(AbitanteDTO input) {
		Abitante result = new Abitante();
		result.setCognome(input.getCognome());
		result.setNome(input.getNome());
		result.setEta(input.getEta());
		result.setResidenza(input.getResidenza());
		result.setMunicipio(input.getMunicipio());
		result.setId(input.getId());

		return result;
	}
	
	public Map<String,String> validate(){
		Map<String,String> temp = new HashMap<String,String>();
		if(this.nome.equals(""))
			temp.put("nome", "Riempire bene il campo nome");
		if(this.cognome.equals(""))
			temp.put("cognome", "Riempire bene il campo cognome");
		if(this.eta<=0)
			temp.put("eta", "Riempire bene il campo eta");
		if(this.residenza.equals(""))
			temp.put("residenza","scegli almeno una residenza");
		if(this.municipio == null)
			temp.put("municipio","scegli almeno una municipio");
		
		return temp;
		
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

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	@Override
	public String toString() {
		return "Abitante [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", residenza="
				+ residenza + "]";
	}
	
}
