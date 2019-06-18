package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;

/**
 * Servlet implementation class PrepareInsertServlet
 */
@WebServlet("/PrepareInsertServlet")
public class PrepareInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrepareInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;
		int etaTemp = 0;
		try {
			etaTemp = Integer.parseInt((String) request.getParameter("etaInput"));

		} catch (NumberFormatException e) {
			etaTemp = -1;
		}

		String nomeTemp = (String) request.getParameter("nomeInput");
		String cognomeTemp = (String) request.getParameter("cognomeInput");
		String codiceFiscaleTemp = (String) request.getParameter("codicefiscaleInput");
		String mottoDiVitaTemp = (String) request.getParameter("mottodivitaInput");

		if (nomeTemp.equals("") || cognomeTemp.equals("") || codiceFiscaleTemp.equals("") || etaTemp <= 0) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			destinazione = "nuovoAbitante.jsp";

		} else {
			try {
				Abitante temp = new Abitante(nomeTemp, cognomeTemp, codiceFiscaleTemp, etaTemp, mottoDiVitaTemp);

				MyServiceFactory.getAbitanteServiceInstance().insert(temp);
				request.setAttribute("listAbitantiAttributeName",
						MyServiceFactory.getAbitanteServiceInstance().listAllAbitante());
				destinazione = "results.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);

	}

}
