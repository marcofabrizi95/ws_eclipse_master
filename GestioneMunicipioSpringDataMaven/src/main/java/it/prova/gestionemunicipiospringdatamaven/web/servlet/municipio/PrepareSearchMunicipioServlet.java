package it.prova.gestionemunicipiospringdatamaven.web.servlet.municipio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrepareSearchMunicipioServlet")
public class PrepareSearchMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrepareSearchMunicipioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//controllo utente in sessione (va fatto in tutte le servlet)
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/municipio/search.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
