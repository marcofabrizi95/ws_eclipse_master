package it.prova.service;

public class OrtopedicoServiceImpl implements OrtopedicoService {
	private RadiologoService radiologo;

	@Override
	public void verficaFratture() {
		radiologo.effettuaLastra();
		System.out.println("niente di rotto");
	}

	public RadiologoService getRadiologo() {
		return radiologo;
	}

	public void setRadiologo(RadiologoService radiologo) {
		this.radiologo = radiologo;
	}
	
}
