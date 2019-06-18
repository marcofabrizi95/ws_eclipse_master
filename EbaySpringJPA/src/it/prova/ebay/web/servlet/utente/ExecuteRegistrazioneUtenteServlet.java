package it.prova.ebay.web.servlet.utente;

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

import it.prova.ebay.model.Ruolo;
import it.prova.ebay.model.Utente;
import it.prova.ebay.model.dto.UtenteDTO;
import it.prova.ebay.service.ruolo.RuoloService;
import it.prova.ebay.service.utente.UtenteService;

/**
 * Servlet implementation class ExecuteRegistrazioneUtenteServlet
 */
@WebServlet("/ExecuteRegistrazioneUtenteServlet")
public class ExecuteRegistrazioneUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private RuoloService ruoloService;
	@Autowired
	private UtenteService utenteService;
	

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

    public ExecuteRegistrazioneUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String usernameInput = request.getParameter("usernameInput");
		String passwordInput = request.getParameter("passwordInput");
		Date date = new Date();
		UtenteDTO temp = new UtenteDTO(nomeInput, cognomeInput, usernameInput, passwordInput, date, 0);
		String giaPresente = null;
		for(Utente item:utenteService.listAllUtenti()) {
		
			if(item.getUsername().equals(usernameInput)) {
				  giaPresente = "Username gia in uso ";
				  return;
			}
		}
		if (!temp.validate().isEmpty()|| giaPresente!=null ) {
			request.setAttribute("messaggioDiErrore", temp.validate());
			request.setAttribute("messaggioDiErroreUsername", giaPresente);

			RequestDispatcher rd = request.getRequestDispatcher("registrazione.jsp");
			rd.forward(request, response);

			return;
		}
		
		Utente item = UtenteDTO.buildUtenteInstance(temp);
		Ruolo temp2 = ruoloService.findByExample(new Ruolo(Ruolo.CLASSIC_USER_ROLE)).get(0);
		item.getRuoli().add(temp2);
		utenteService.inserisciNuovo(item);
		
		response.sendRedirect("login.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
