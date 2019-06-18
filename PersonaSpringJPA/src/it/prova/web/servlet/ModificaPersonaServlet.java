package it.prova.web.servlet;

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

import it.prova.model.Persona;
import it.prova.service.PersonaService;

/**
 * Servlet implementation class ModificaPersonaServlet
 */
@WebServlet("/ModificaPersonaServlet")
public class ModificaPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private PersonaService personaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ModificaPersonaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;
		int etaTemp = 0;
		Long idTemp = (long) 0;
		try {
			etaTemp = Integer.parseInt((String) request.getParameter("etaInput"));
			idTemp = Long.parseLong((String) request.getParameter("idInput"));
		} catch (NumberFormatException e) {
			etaTemp = -1;

		}

		String nomeTemp = (String) request.getParameter("nomeInput");
		String cognomeTemp = (String) request.getParameter("cognomeInput");
		String codiceFiscaleTemp = (String) request.getParameter("cfInput");
		String indirizzoTemp = (String) request.getParameter("indirizzoInput");

		if (nomeTemp.equals("") || cognomeTemp.equals("") || codiceFiscaleTemp.equals("") || etaTemp <= 0) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			Persona temp = personaService.caricaSingolaPersona(idTemp);
			request.setAttribute("personaDaModificare",temp);
			destinazione = "modificaform.jsp";

		} else {
			try {
				Persona temp = new Persona(nomeTemp, cognomeTemp, codiceFiscaleTemp, indirizzoTemp, etaTemp);
				temp.setId(idTemp);

				personaService.aggiorna(temp);
				request.setAttribute("listaPersoneAttributeName", personaService.listAll());
				destinazione = "result.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);

	}

}
