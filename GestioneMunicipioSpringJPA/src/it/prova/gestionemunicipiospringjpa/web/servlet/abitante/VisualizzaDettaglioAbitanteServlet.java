package it.prova.gestionemunicipiospringjpa.web.servlet.abitante;

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

import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;

/**
 * Servlet implementation class VisualizzaDettaglioAbitanteServlet
 */
@WebServlet("/VisualizzaDettaglioAbitanteServlet")
public class VisualizzaDettaglioAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Autowired  
		private AbitanteService abitanteService;
		@Override
		public void init(ServletConfig config) throws ServletException {
			super.init(config);
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		}
    public VisualizzaDettaglioAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAbitanteDaPagina = request.getParameter("idAbitante");

		request.setAttribute("abitanteSingoloAttributeName", abitanteService.caricaSingoloAbitante(Long.parseLong(idAbitanteDaPagina)));

		RequestDispatcher rd = request.getRequestDispatcher("/abitante/dettaglioAbitante.jsp");
		rd.forward(request, response);
	}

	

}
