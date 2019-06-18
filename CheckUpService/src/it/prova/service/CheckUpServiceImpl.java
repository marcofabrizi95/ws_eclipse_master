package it.prova.service;

public class CheckUpServiceImpl implements CheckUpService{
	private CardiologoService cardiologo;
	private EmatologoService ematologo;
	private OrtopedicoService ortopedico;
	private MedicoDiBaseService medico;
	@Override
	public void verficaSalute() {
		cardiologo.stampaDiagnosiCardiologo();
		ematologo.stampaDiagnosiEmatologo();
		ortopedico.verficaFratture();
		medico.stampaReferto();
		
	}
	public CardiologoService getCardiologo() {
		return cardiologo;
	}
	public void setCardiologo(CardiologoService cardiologo) {
		this.cardiologo = cardiologo;
	}
	public EmatologoService getEmatologo() {
		return ematologo;
	}
	public void setEmatologo(EmatologoService ematologo) {
		this.ematologo = ematologo;
	}
	public OrtopedicoService getOrtopedico() {
		return ortopedico;
	}
	public void setOrtopedico(OrtopedicoService ortopedico) {
		this.ortopedico = ortopedico;
	}
	public MedicoDiBaseService getMedico() {
		return medico;
	}
	public void setMedico(MedicoDiBaseService medico) {
		this.medico = medico;
	}
	
}
