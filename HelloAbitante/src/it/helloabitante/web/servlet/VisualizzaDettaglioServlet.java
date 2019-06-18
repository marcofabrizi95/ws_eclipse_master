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

@WebServlet("/VisualizzaDettaglioServlet")
public class VisualizzaDettaglioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VisualizzaDettaglioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametroIdDellAbitanteDiCuiVoglioIlDettaglio = request.getParameter("idDaInviareComeParametro");
		Long tempId = Long.parseLong(parametroIdDellAbitanteDiCuiVoglioIlDettaglio);
	    try {
			Abitante a =MyServiceFactory.getAbitanteServiceInstance().get(tempId);
			request.setAttribute("abitanteDettaglio", a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    RequestDispatcher rd = request.getRequestDispatcher("visualizzaAbitante.jsp");
	    rd.forward(request, response);
//		AbitanteService a 
//		
//		Abitante result = a.get(Integer.parseInt(parametroIdDellAbitanteDiCuiVoglioIlDettaglio);
//		
//		request.setAttribute("abitanteDaInviareAPaginaDettalio", result);
		
		
		
		
		//response.getWriter().append("Volevi visualizzare abitante con id: "+parametroIdDellAbitanteDiCuiVoglioIlDettaglio).append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
