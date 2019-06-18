package it.prova.gestionecartelleesattorialispringjpa.web.servlet.utente;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionecartelleesattorialispringjpa.dto.UtenteDTO;
import it.prova.gestionecartelleesattorialispringjpa.model.Utente;
import it.prova.gestionecartelleesattorialispringjpa.service.ruolo.RuoloService;
import it.prova.gestionecartelleesattorialispringjpa.service.utente.UtenteService;

/**
 * Servlet implementation class ExecuteInserisciUtenteServlet
 */
@WebServlet("/admin/ExecuteInserisciUtenteServlet")
public class ExecuteInserisciUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private RuoloService ruoloService;
	@Autowired
	private UtenteService utenteService;

	public ExecuteInserisciUtenteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String usernameInput = request.getParameter("usernameInput");
		String passwordInput = request.getParameter("passwordInput");
		String[] ruoli = request.getParameterValues("ruoli");
		Date date = new Date();
		UtenteDTO temp = new UtenteDTO(nomeInput, cognomeInput, usernameInput, passwordInput, date);
		if (!temp.validate().isEmpty()) {
			request.setAttribute("messaggioDiErrore", temp.validate());
			request.setAttribute("listaRuoliAttributeName", ruoloService.listAll());

			RequestDispatcher rd = request.getRequestDispatcher("/admin/insert.jsp");
			rd.forward(request, response);

			return;
		}
		for (int i = 0; i < ruoli.length; i++) {
			temp.getRuoli().add(ruoloService.carica(Long.parseLong(ruoli[i])));
		}
		Utente item = UtenteDTO.buildUtenteInstance(temp);
		utenteService.inserisci(item);
		response.sendRedirect("SendRedirectUtenteServlet");
	}

}
