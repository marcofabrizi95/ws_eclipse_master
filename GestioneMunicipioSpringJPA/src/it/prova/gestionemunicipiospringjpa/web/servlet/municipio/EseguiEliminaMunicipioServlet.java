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

import it.prova.gestionemunicipiospringjpa.model.Municipio;
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;

/**
 * Servlet implementation class EseguiEliminaMunicipioServlet
 */
@WebServlet("/EseguiEliminaMunicipioServlet")
public class EseguiEliminaMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private MunicipioService municipioService;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public EseguiEliminaMunicipioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idTemp = (long) 0;
		try {
			idTemp = Long.parseLong((String) request.getParameter("idInput"));
		} catch (NumberFormatException e) {

		}
		Municipio temp = municipioService.caricaSingoloMunicipio(idTemp);
		municipioService.rimuovi(temp);
		request.setAttribute("listaMunicipioAttributeName", municipioService.listAllMunicipi());
		RequestDispatcher rd = request.getRequestDispatcher("/municipio/result.jsp");
		rd.forward(request, response);
	}
}
