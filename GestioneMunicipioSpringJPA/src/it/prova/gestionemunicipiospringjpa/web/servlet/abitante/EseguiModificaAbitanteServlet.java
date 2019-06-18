package it.prova.gestionemunicipiospringjpa.web.servlet.abitante;

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
import it.prova.gestionemunicipiospringjpa.model.Municipio;
import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;

/**
 * Servlet implementation class EseguiModificaAbitanteServlet
 */
@WebServlet("/EseguiModificaAbitanteServlet")
public class EseguiModificaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AbitanteService abitanteService;
	@Autowired
	private MunicipioService municipioService;
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public EseguiModificaAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinazione = null;
		int etaTemp = 0;
		Long idTemp = Long.parseLong((String)request.getParameter("idInput"));
		try {
			etaTemp = Integer.parseInt((String) request.getParameter("etaInput"));
		} catch (NumberFormatException e) {
			etaTemp = -1;
			
		}

		String nomeTemp = (String) request.getParameter("nomeInput");
		String cognomeTemp = (String) request.getParameter("cognomeInput");
	    String indirizzoTemp = (String) request.getParameter("residenzaInput");
	
		if (nomeTemp.equals("") || cognomeTemp.equals("") || indirizzoTemp.equals("") || etaTemp <= 0|| idTemp<0L) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			request.setAttribute("listaMunicipi", municipioService.listAllMunicipi());
			request.setAttribute("abitanteDaModificare", abitanteService.caricaSingoloAbitante(idTemp));	
			destinazione = "/abitante/modifica.jsp";

		} else {
			try {
				Municipio item = new Municipio();
				item.setId(idTemp);
				Abitante temp = new Abitante(nomeTemp, cognomeTemp, etaTemp, indirizzoTemp);
				temp.setMunicipio(item);
				abitanteService.aggiorna(temp);
				request.setAttribute("listaAbitanteAttributeName",
						abitanteService.listAllAbitanti());
				destinazione = "/abitante/result.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);

	}


}
