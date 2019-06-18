package it.prova.ebay.web.servlet.annuncio;

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

import it.prova.ebay.service.annuncio.AnnuncioService;

/**
 * Servlet implementation class VisualizzaDettaglioAnnuncioServlet
 */
@WebServlet("/VisualizzaDettaglioAnnuncioServlet")
public class VisualizzaDettaglioAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     @Autowired
     private AnnuncioService annuncioService;
     public void init(ServletConfig config) throws ServletException {
 		super.init(config);
 		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
 	}
    public VisualizzaDettaglioAnnuncioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idTemp = Long.parseLong(request.getParameter("idAnnuncio"));
		
		request.setAttribute("annuncioInPagina", annuncioService.getEager(idTemp));
		RequestDispatcher rd = request.getRequestDispatcher("dettaglio.jsp");
		rd.forward(request, response);

	}

	
	

}
