package it.prova.gestionemunicipiospringdatamaven.web.servlet.abitante;

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

import it.prova.gestionemunicipiospringdatamaven.dto.AbitanteDTO;
import it.prova.gestionemunicipiospringdatamaven.service.abitante.AbitanteService;

/**
 * Servlet implementation class PrepareModificaAbitanteServlet
 */
@WebServlet("/PrepareModificaAbitanteServlet")
public class PrepareModificaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Autowired
	    private AbitanteService abitanteService;  
	    public void init(ServletConfig config) throws ServletException {
			super.init(config);
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		}    
    public PrepareModificaAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long temp = Long.parseLong(request.getParameter("idAbitante"));
		AbitanteDTO result = AbitanteDTO.buildAbitanteDTOInstance(abitanteService.getEager(temp));
		request.setAttribute("abitanteInPagina", result);
		RequestDispatcher rd = request.getRequestDispatcher("/abitante/modifica.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
