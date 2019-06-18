package it.prova.ebay.web.servlet.annuncio;

import java.io.IOException;
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
import it.prova.ebay.service.annuncio.AnnuncioService;
import it.prova.ebay.service.categoria.CategoriaService;

/**
 * Servlet implementation class PrepareSearchAnnuncioServlet
 */
@WebServlet("/PrepareSearchAnnuncioServlet")
public class PrepareSearchAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       @Autowired
       private CategoriaService categoriaService;
       @Autowired
       private AnnuncioService annuncioService;
       
       public void init(ServletConfig config) throws ServletException {
   		super.init(config);
   		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareSearchAnnuncioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Annuncio annuncioDaCercare = new Annuncio();
		String testoAnnuncio = request.getParameter("annuncioInputId");	
		String[]categorie = request.getParameterValues("categorieId");
		double prezzoTemp;
		try {
			prezzoTemp = Double.parseDouble(request.getParameter("prezzoInputId"));
		} catch (Exception e) {
			prezzoTemp = 9999999;
		}
		Set<Categoria> listaCategorie = new HashSet<Categoria>();

		if(categorie == null )
			listaCategorie.addAll(categoriaService.list());

		else {
		for (int i=0; i<categorie.length; i++) {
			listaCategorie.add(categoriaService.get(Long.parseLong(categorie[i])));
		}
		}
		annuncioDaCercare.setTestoAnnuncio(testoAnnuncio);
		annuncioDaCercare.setCategorie(listaCategorie);
		annuncioDaCercare.setPrezzo(prezzoTemp);
		request.setAttribute("listaAnnuncio", annuncioService.findByNomeECategoria(annuncioDaCercare));
		System.out.println(annuncioService.list());
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
		annuncioDaCercare.setCategorie(listaCategorie);
	 
	}

}
