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

import it.prova.model.Persona;
import it.prova.service.PersonaService;

/**
 * Servlet implementation class PreparaModificaPersonaServlet
 */
@WebServlet("/PreparaModificaPersonaServlet")
public class PreparaModificaPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Autowired
	private PersonaService service;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreparaModificaPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong((String)request.getParameter("idPersona"));
		Persona temp = service.caricaSingolaPersona(id);
		request.setAttribute("personaDaModificare",temp);
		RequestDispatcher rs = request.getRequestDispatcher("modificaform.jsp");
		rs.forward(request, response);
			
		//RequestDispatcher rd = request.getRequestDispatcher();
		//rd.forward(request, response);//

	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
