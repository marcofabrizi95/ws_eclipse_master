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
import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;

/**
 * Servlet implementation class SearchAbitanteServlet
 */
@WebServlet("/SearchAbitanteServlet")
public class SearchAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AbitanteService abitanteService;
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public SearchAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeDaPagina = request.getParameter("nomeInput");
		String cognomeDaPagina = request.getParameter("cognomeInput");
		String residenzaDaPagina = request.getParameter("residenzaInputId");
		
		Abitante example = new Abitante(nomeDaPagina, cognomeDaPagina,residenzaDaPagina);
		
		try {
			example.setEta(Integer.parseInt((String) request.getParameter("etaInput")));

		} catch (NumberFormatException e) {
		}
		request.setAttribute("listaAbitanteAttributeName", abitanteService.findByExample(example));

		RequestDispatcher rd = request.getRequestDispatcher("/abitante/result.jsp");
		rd.forward(request, response);
	}
}
