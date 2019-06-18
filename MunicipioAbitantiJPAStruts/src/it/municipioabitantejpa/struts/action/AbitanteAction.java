package it.municipioabitantejpa.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import it.municipioabitantejpa.model.Abitante;
import it.municipioabitantejpa.service.MyServiceFactory;
import it.municipioabitantejpa.struts.form.AbitanteForm;

public class AbitanteAction extends DispatchAction{
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String idAbitanteParam = request.getParameter("idAbitante");
		long idAbitante = Long.parseLong(idAbitanteParam);
		Abitante abitanteInstance = MyServiceFactory.getAbitanteServiceInstance().caricaSingoloAbitante(idAbitante);
		request.setAttribute("AbitanteForm", abitanteInstance);

		return mapping.findForward("show");
	}
	
	public ActionForward showAll(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setAttribute("AbitanteForm", MyServiceFactory.getAbitanteServiceInstance().listAllAbitanti());

		return mapping.findForward("showAll");
	}
	
	public ActionForward change(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String idAbitanteParam = request.getParameter("idAbitante");
		long idAbitante = Long.parseLong(idAbitanteParam);
		Abitante abitanteInstance = MyServiceFactory.getAbitanteServiceInstance().caricaSingoloAbitante(idAbitante);
		request.setAttribute("AbitanteForm", abitanteInstance);

		return mapping.findForward("show");
	}
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		AbitanteForm abitanteForm = (AbitanteForm) form;
			
			
		try {
			Abitante abitanteDaInserire = new Abitante();
			BeanUtils.copyProperties(abitanteDaInserire, abitanteForm);
			abitanteDaInserire.setId(null);
			abitanteDaInserire.setMunicipio(MyServiceFactory.getMunicipioServiceInstance().caricaSingoloMunicipio(abitanteForm.getMunicipioId()));
			MyServiceFactory.getAbitanteServiceInstance().inserisciNuovo(abitanteDaInserire);

		} catch (Exception e) {
			throw e;
		}

		return mapping.findForward("home");
	}
	public ActionForward create(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("listaMunicipi", MyServiceFactory.getMunicipioServiceInstance().listAllMunicipi());
		return mapping.findForward("create");
	}
}
