package it.prova.gestionecartelleesattorialispringjpa.web.servlet.contribuente;

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

import it.prova.gestionecartelleesattorialispringjpa.dto.ContribuenteDTO;
import it.prova.gestionecartelleesattorialispringjpa.service.contribuente.ContribuenteService;

@WebServlet("/PrepareModificaContribuenteServlet")
public class PrepareModificaContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public PrepareModificaContribuenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String idContribuenteDaPagina = request.getParameter("idContribuente");
		ContribuenteDTO temp = ContribuenteDTO.buildContribuenteDTOInstance(contribuenteService.carica(Long.parseLong(idContribuenteDaPagina)));
		request.setAttribute("contribuenteDaModificareAttributeName",temp);
		RequestDispatcher rd = request.getRequestDispatcher("/contribuente/modifica.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
