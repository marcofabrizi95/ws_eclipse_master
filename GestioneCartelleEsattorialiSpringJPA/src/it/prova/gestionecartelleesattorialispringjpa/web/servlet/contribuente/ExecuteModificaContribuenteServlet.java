package it.prova.gestionecartelleesattorialispringjpa.web.servlet.contribuente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionecartelleesattorialispringjpa.dto.ContribuenteDTO;
import it.prova.gestionecartelleesattorialispringjpa.model.Contribuente;
import it.prova.gestionecartelleesattorialispringjpa.service.contribuente.ContribuenteService;

@WebServlet("/ExecuteModificaContribuenteServlet")
public class ExecuteModificaContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteModificaContribuenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		

		Long idInput = Long.parseLong(request.getParameter("idInput"));
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String codiceFiscaleInput = request.getParameter("codiceFiscaleInput");
		String indirizzoInput = request.getParameter("indirizzoInput");
		ContribuenteDTO temp = new ContribuenteDTO(idInput, nomeInput, cognomeInput, codiceFiscaleInput, indirizzoInput);
		if (!temp.validate().isEmpty()) {
			request.setAttribute("messaggioDiErrore",temp.validate());
			request.setAttribute("contribuenteDaModificareAttributeName", temp);
			RequestDispatcher rd = request.getRequestDispatcher("/contribuente/modifica.jsp");
			rd.forward(request, response);
			
			return;
		} 
		

		Contribuente contribuenteDaAggiornare = ContribuenteDTO.buildContribuenteInstance(temp);
		contribuenteService.aggiorna(contribuenteDaAggiornare);

		response.sendRedirect("SendRedirectContribuenteServlet");

	}

}
