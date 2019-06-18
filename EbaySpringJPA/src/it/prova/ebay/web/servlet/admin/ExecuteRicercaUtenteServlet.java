package it.prova.ebay.web.servlet.admin;

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

import it.prova.ebay.model.Utente;
import it.prova.ebay.service.utente.UtenteService;

/**
 * Servlet implementation class ExecuteRicercaUtenteServlet
 */
@WebServlet("/admin/ExecuteRicercaUtenteServlet")
public class ExecuteRicercaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   @Autowired
   private UtenteService utenteService;
   @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public ExecuteRicercaUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String usernameInput = request.getParameter("usernameInput");
		Utente example = new Utente();
		example.setNome(nomeInput);
		example.setCognome(cognomeInput);
		example.setUsername(usernameInput);
		request.setAttribute("listaUtenteAttributeName", utenteService.findByExample(example));

		RequestDispatcher rd = request.getRequestDispatcher("/admin/result.jsp");
		rd.forward(request, response);
	}

}
