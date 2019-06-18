package it.prova.gestionemunicipiospringdatamaven.web.servlet.municipio;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionemunicipiospringdatamaven.dto.MunicipioDTO;
import it.prova.gestionemunicipiospringdatamaven.model.Municipio;
import it.prova.gestionemunicipiospringdatamaven.service.municipio.MunicipioService;

/**
 * Servlet implementation class ExecuteEliminaMunicipioServlet
 */
@WebServlet("/ExecuteEliminaMunicipioServlet")
public class ExecuteEliminaMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Autowired
	    private MunicipioService municipioService;    
	public void init(ServletConfig config) throws ServletException {
			super.init(config);
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		}     
    public ExecuteEliminaMunicipioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idInput = Long.parseLong(request.getParameter("idInput"));
		String descrizioneInput = request.getParameter("descrizioneInput");
		String codiceInput = request.getParameter("codiceInput");
		String ubicazioneInputId = request.getParameter("ubicazioneInputId");
		MunicipioDTO temp = new MunicipioDTO(descrizioneInput, codiceInput, ubicazioneInputId);
		temp.setId(idInput);
		Municipio result = MunicipioDTO.buildMunicipioInstance(temp);
		municipioService.rimuovi(result);
		response.sendRedirect("SendRedirectServlet");
	}

}
