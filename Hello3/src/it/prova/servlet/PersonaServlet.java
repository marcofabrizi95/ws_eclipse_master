package it.prova.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.model.Persona;

/**
 * Servlet implementation class PersonaServlet
 */
@WebServlet("/PersonaServlet")
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeTemp = (String)request.getParameter("mioNomeInput");
		String cognomeTemp = (String)request.getParameter("mioCognomeInput");
		Persona temp = new Persona(nomeTemp,cognomeTemp);
		request.setAttribute("miaPersona", temp);
		RequestDispatcher rs = request.getRequestDispatcher("home.jsp");
		rs.forward(request, response);
				
	}

}
