package it.prova.gestionecartelleesattorialispringjpa.web.servlet.utente;

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

import it.prova.gestionecartelleesattorialispringjpa.service.utente.UtenteService;

/**
 * Servlet implementation class SendRedirectUtenteServlet
 */
@WebServlet("/admin/SendRedirectUtenteServlet")
public class SendRedirectUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	   private UtenteService utenteService;
    public SendRedirectUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaUtenteAttributeName", utenteService.listAll());

		RequestDispatcher rd = request.getRequestDispatcher("/admin/result.jsp");
		rd.forward(request, response);
	}

	
}
