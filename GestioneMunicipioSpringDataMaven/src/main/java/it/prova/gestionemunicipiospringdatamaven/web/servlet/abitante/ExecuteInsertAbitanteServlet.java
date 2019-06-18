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
import it.prova.gestionemunicipiospringdatamaven.model.Abitante;
import it.prova.gestionemunicipiospringdatamaven.model.Municipio;
import it.prova.gestionemunicipiospringdatamaven.service.abitante.AbitanteService;
import it.prova.gestionemunicipiospringdatamaven.service.municipio.MunicipioService;

@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Autowired
	    private MunicipioService municipioService;  
	 @Autowired
	    private AbitanteService abitanteService;  
	 public void init(ServletConfig config) throws ServletException {
			super.init(config);
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		}    
	public ExecuteInsertAbitanteServlet() {
		super();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer etaInput;
		Municipio municipioInput = new Municipio();
		Long municipioId=-1L;
		try {
			etaInput = Integer.parseInt(request.getParameter("etaInput"));
			municipioId = Long.parseLong(request.getParameter("municipioId"));
		} catch (Exception e) {
			etaInput=0;
			municipioInput=null;
		}
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String residenzaInput = request.getParameter("residenzaInput");
		if(municipioId>0)
		municipioInput = municipioService.caricaSingoloMunicipio(municipioId);
		AbitanteDTO temp = new AbitanteDTO(nomeInput, cognomeInput, etaInput, residenzaInput, municipioInput);
		if(!temp.validate().isEmpty()) {
			request.setAttribute("messaggioDiErrore",temp.validate());
			RequestDispatcher rd = request.getRequestDispatcher("/abitante/inserisciNuovo.jsp");
			rd.forward(request, response);
			
			return;

		}
		Abitante result = AbitanteDTO.buildAbitanteInstance(temp);
		abitanteService.inserisciNuovo(result);
		response.sendRedirect("SendRedirectServlet");

		
	}

}
