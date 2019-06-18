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

import it.prova.ebay.model.dto.AnnuncioDTO;
import it.prova.ebay.service.annuncio.AnnuncioService;
import it.prova.ebay.service.categoria.CategoriaService;


/**
 * Servlet implementation class PreparaModificaAnnunciUtenteServlet
 */
@WebServlet("/PreparaModificaAnnunciUtenteServlet")
public class PreparaModificaAnnunciUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Autowired   
    private AnnuncioService annuncioService;
    @Autowired
    private CategoriaService categoriaService;
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

    public PreparaModificaAnnunciUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idTemp = Long.parseLong(request.getParameter("idAnnuncio"));
		
		AnnuncioDTO temp = AnnuncioDTO.buildAnnuncioDTOInstance(annuncioService.getEager(idTemp));
		
		request.setAttribute("annuncioDaModificare", temp);
		request.setAttribute("listaCategorie", categoriaService.list());
		RequestDispatcher rs = request.getRequestDispatcher("/user/modifica.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
