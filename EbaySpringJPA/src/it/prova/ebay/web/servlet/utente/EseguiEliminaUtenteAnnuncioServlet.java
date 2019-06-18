package it.prova.ebay.web.servlet.utente;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.ebay.service.annuncio.AnnuncioService;

/**
 * Servlet implementation class EseguiEliminaUtenteAnnuncioServlet
 */
@WebServlet("/EseguiEliminaUtenteAnnuncioServlet")
public class EseguiEliminaUtenteAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired   
    private AnnuncioService annuncioService;
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public EseguiEliminaUtenteAnnuncioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idTemp = Long.parseLong(request.getParameter("idAnnuncio"));
		annuncioService.delete(annuncioService.get(idTemp));
		response.sendRedirect("SendRedirectServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
