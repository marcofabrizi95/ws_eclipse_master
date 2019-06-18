package it.prova.gestionemunicipiospringjpa.web.servlet.municipio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrepareInsertMunicipioServlet
 */
@WebServlet("/PrepareInsertMunicipioServlet")
public class PrepareInsertMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareInsertMunicipioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//controllo utente in sessione (va fatto in tutte le servlet)
		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/municipio/insert.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
