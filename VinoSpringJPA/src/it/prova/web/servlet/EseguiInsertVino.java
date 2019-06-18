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
 * Servlet implementation class EseguiInsertVino
 */
@WebServlet("/EseguiInsertVino")
public class EseguiInsertVino extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private VinoService vinoService;
    public EseguiInsertVino() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinazione = null;
		int annataTemp = 0;
		try {
			annataTemp = Integer.parseInt((String) request.getParameter("annataInput"));
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
			destinazione = "inserisci.jsp";

		} else {
			try {
				Vino temp = new Vino(nomeTemp, cantinaTemp, uvaTemp, localitaTemp, annataTemp);

				vinoService.inserisciNuovo(temp);
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
