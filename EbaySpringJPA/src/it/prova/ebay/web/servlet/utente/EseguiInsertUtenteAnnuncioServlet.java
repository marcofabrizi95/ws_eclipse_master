package it.prova.ebay.web.servlet.utente;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.ebay.model.Annuncio;
import it.prova.ebay.model.Categoria;
import it.prova.ebay.model.dto.AnnuncioDTO;
import it.prova.ebay.service.annuncio.AnnuncioService;
import it.prova.ebay.service.categoria.CategoriaService;
import it.prova.ebay.service.utente.UtenteService;

/**
 * Servlet implementation class EseguiInsertUtenteAnnuncioServlet
 */
@WebServlet("/EseguiInsertUtenteAnnuncioServlet")
public class EseguiInsertUtenteAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Autowired   
	    private AnnuncioService annuncioService;
	    @Autowired
	    private CategoriaService categoriaService;
	    @Autowired
		private UtenteService utenteService;
	    public void init(ServletConfig config) throws ServletException {
			super.init(config);
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		}

    public EseguiInsertUtenteAnnuncioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double importoInput;
		try {
			 importoInput = Double.parseDouble(request.getParameter("prezzoInput"));
		} catch (Exception e) {
			 importoInput =-1;
				}
		
		Date data = new Date();
		
		Long idTemp = Long.parseLong(request.getParameter("utenteIdInput"));
		String testoAnnuncioInput = request.getParameter("testoAnnuncioInput");
		String[] categorie = request.getParameterValues("categorieId");
		Set<Categoria> listaCategorie = new HashSet<Categoria>();
		
		if(categorie!=null&&categorie.length>0) {
		for (int i = 0; i < categorie.length; i++) 
			listaCategorie.add(categoriaService.get(Long.parseLong(categorie[i])));
		
		}else listaCategorie= null;
		AnnuncioDTO temp = new AnnuncioDTO(testoAnnuncioInput, importoInput, true, data, listaCategorie,utenteService.caricaSingoloUtente(idTemp) );

		if (!temp.validate().isEmpty()) {
			request.setAttribute("messaggioDiErrore",temp.validate());
			request.setAttribute("listaCategorie", categoriaService.list());
			RequestDispatcher rd = request.getRequestDispatcher("/user/inserisci.jsp");
			rd.forward(request, response);
			
			return;
		} 
		
		Annuncio item = AnnuncioDTO.buildAnnuncioInstance(temp);
		annuncioService.insert(item);
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
