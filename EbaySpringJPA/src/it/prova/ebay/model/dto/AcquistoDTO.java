package it.prova.ebay.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import it.prova.ebay.model.Acquisto;

public class AcquistoDTO {
	private Long id;
	private String descrizione;
	private Integer anno;
	private double prezzo;
	
	public AcquistoDTO() {}
	
	
	public static Acquisto buildAcquistoInstance(AcquistoDTO input) {
		Acquisto result = new Acquisto();
		
		result.setDescrizione(input.getDescrizione());
		result.setAnno(input.getAnno());
		result.setPrezzo(input.getPrezzo());
		
		return result;
	}
	
	public static AcquistoDTO buildAcquistoDTOInstance(Acquisto input) {
		AcquistoDTO result = new AcquistoDTO();
		
		result.setDescrizione(input.getDescrizione());
		result.setAnno(input.getAnno());
		result.setPrezzo(input.getPrezzo());
		
		return result;
		
	}
	
	
	public AcquistoDTO(String descrizione, Integer anno) {
		super();
		this.descrizione = descrizione;
		this.anno = anno;
	}


	public List<String> validate(){
		List<String> listaProblemi = new ArrayList<String>();
		
		if(StringUtils.isEmpty(this.descrizione))
			listaProblemi.add("Inserisci bene la descrizione");
		if(prezzo<0)
			listaProblemi.add("Inserisci bene il prezzo");
		
		return listaProblemi;
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



	public Integer getAnno() {
		return anno;
	}



	public void setAnno(Integer anno) {
		this.anno = anno;
	}



	public double getPrezzo() {
		return prezzo;
	}



	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
}
