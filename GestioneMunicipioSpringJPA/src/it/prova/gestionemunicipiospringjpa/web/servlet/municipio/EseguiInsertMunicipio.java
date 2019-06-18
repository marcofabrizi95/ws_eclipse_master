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
 * Servlet implementation class EseguiInsertMunicipio
 */
@WebServlet("/EseguiInsertMunicipio")
public class EseguiInsertMunicipio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MunicipioService municipioService;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public EseguiInsertMunicipio() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinazione = null;
		String descrizioneInput = request.getParameter("descrizioneInput");
		String codiceInput = request.getParameter("codiceInput");
		String ubicazioneInput = request.getParameter("ubicazioneInput");
		if (descrizioneInput.equals("") || codiceInput.equals("") || ubicazioneInput.equals("")) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			destinazione = "/municipio/insert.jsp";

		} else {
			try {
				Municipio temp = new Municipio(descrizioneInput, codiceInput, ubicazioneInput);

				municipioService.inserisciNuovo(temp);
				request.setAttribute("listaMunicipioAttributeName", municipioService.listAllMunicipi());
				destinazione = "/municipio/result.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);

	}

}
