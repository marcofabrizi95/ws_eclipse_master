package it.prova.gestionemunicipiospringdatamaven.web.servlet.municipio;

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

import it.prova.gestionemunicipiospringdatamaven.dto.MunicipioDTO;
import it.prova.gestionemunicipiospringdatamaven.service.municipio.MunicipioService;

/**
 * Servlet implementation class ExecuteDettaglioMunicipioServlet
 */
@WebServlet("/ExecuteDettaglioMunicipioServlet")
public class ExecuteDettaglioMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MunicipioService municipioService;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public ExecuteDettaglioMunicipioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long temp = Long.parseLong(request.getParameter("idMunicipio"));
		MunicipioDTO result = MunicipioDTO.buildMunicipioDTOInstance(municipioService.caricaSingoloMunicipio(temp));
		request.setAttribute("municipioInPagina", result);
		RequestDispatcher rd = request.getRequestDispatcher("/municipio/dettaglio.jsp");
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
