package it.prova.gestionemunicipiospringjpa.web.servlet.municipio;

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

import it.prova.gestionemunicipiospringjpa.model.Abitante;
import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;

/**
 * Servlet implementation class PreparaModificaMunicipioServlet
 */
@WebServlet("/PreparaModificaMunicipioServlet")
public class PreparaModificaMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AbitanteService abitanteService;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public PreparaModificaMunicipioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//controllo utente in sessione (va fatto in tutte le servlet)
				if(request.getSession().getAttribute("userInfo") == null) {
					response.sendRedirect(request.getContextPath());
					return;
				}
				
				Long id = Long.parseLong((String)request.getParameter("idAbitante"));
				Abitante temp = abitanteService.caricaSingoloAbitante(id);
				request.setAttribute("abitanteDaModificare",temp);
				RequestDispatcher rd = request.getRequestDispatcher("/municipio/modifica.jsp");
				rd.forward(request, response);

	}
	 
	

}
