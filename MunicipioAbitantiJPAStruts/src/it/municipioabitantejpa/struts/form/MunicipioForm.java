package it.municipioabitantejpa.struts.form;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts.action.ActionForm;

public class MunicipioForm extends ActionForm {

	private static final long serialVersionUID = -5829818823998598284L;

	private Long id;
	private String descrizione;
	private String codice;
	private String ubicazione;
	private Set<AbitanteForm> abitanti = new HashSet<AbitanteForm>();
	

	public Long getId() {
		return id;
	}

	public Set<AbitanteForm> getAbitanti() {
		return abitanti;
	}

	public void setAbitanti(Set<AbitanteForm> abitanti) {
		this.abitanti = abitanti;
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
