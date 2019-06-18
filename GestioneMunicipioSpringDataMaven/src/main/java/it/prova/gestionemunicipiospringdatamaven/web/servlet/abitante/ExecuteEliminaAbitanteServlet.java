package it.prova.gestionemunicipiospringdatamaven.web.servlet.abitante;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionemunicipiospringdatamaven.service.abitante.AbitanteService;

/**
 * Servlet implementation class ExecuteEliminaAbitanteServlet
 */
@WebServlet("/ExecuteEliminaAbitanteServlet")
public class ExecuteEliminaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Autowired
	    private AbitanteService abitanteService;  
	 public void init(ServletConfig config) throws ServletException {
			super.init(config);
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		} 
    public ExecuteEliminaAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idInput = Long.parseLong( request.getParameter("idInput"));
		abitanteService.rimuovi(abitanteService.caricaSingoloAbitante(idInput));
		response.sendRedirect("SendRedirectServlet");

	}

}
