package it.prova.web.servlet;

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

import it.prova.model.Vino;
import it.prova.service.VinoService;

/**
 * Servlet implementation class EseguiModificaServlet
 */
@WebServlet("/EseguiModificaServlet")
public class EseguiModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private VinoService vinoService;
    public EseguiModificaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinazione = null;
		int annataTemp = 0;
		Long idTemp = (long) 0;
		try {
			annataTemp = Integer.parseInt((String) request.getParameter("annataInput"));
			idTemp = Long.parseLong((String) request.getParameter("idInput"));
		} catch (NumberFormatException e) {
			annataTemp = -1;

		}

		String nomeTemp = (String) request.getParameter("nomeInput");
		String cantinaTemp = (String) request.getParameter("cantinaInput");
		String uvaTemp = (String) request.getParameter("uvaInput");
		String localitaTemp = (String) request.getParameter("localitaInput");

		if (nomeTemp.equals("") || cantinaTemp.equals("") || uvaTemp.equals("") || annataTemp <= 0) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			Vino temp = vinoService.caricaVino(idTemp);
			request.setAttribute("vinoDaModificare",temp);
			destinazione = "modificaform.jsp";

		} else {
			try {
				Vino temp = new Vino(nomeTemp, cantinaTemp, uvaTemp, localitaTemp, annataTemp);
				temp.setId(idTemp);

				vinoService.aggiorna(temp);
				request.setAttribute("listaVinoAttributeName", vinoService.listAll());
				destinazione = "result.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);

	}

}
