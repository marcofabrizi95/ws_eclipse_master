package it.prova.ebay.web.servlet.utente;

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
import it.prova.ebay.service.acquisto.AcquistoService;
import it.prova.ebay.service.annuncio.AnnuncioService;

/**
 * Servlet implementation class EseguiCompraUtenteServlet
 */
@WebServlet("/EseguiCompraUtenteServlet")
public class EseguiCompraUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
    private AcquistoService acquistoService;  
	@Autowired
	private AnnuncioService	annuncioService;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

    public EseguiCompraUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Utente utente = (Utente)httpRequest.getSession().getAttribute("userInfo");
		Long idAnnuncioTemp = Long.parseLong(request.getParameter("idAnnuncio"));
		if(acquistoService.eseguiAcquisto(idAnnuncioTemp, utente.getId())) {
			response.sendRedirect("SendRedirectServlet");
			return;
		}
		request.setAttribute("messaggioDiErrore", "Credito non sufficente");
		request.setAttribute("annuncioInPagina", annuncioService.getEager(idAnnuncioTemp));
		RequestDispatcher rd = request.getRequestDispatcher("user/dettaglioCompra.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
