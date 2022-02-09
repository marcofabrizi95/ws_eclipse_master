package it.prova.gestionecartelleesattorialispringjpa.web.servlet.utente;

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

import it.prova.gestionecartelleesattorialispringjpa.dto.UtenteDTO;
import it.prova.gestionecartelleesattorialispringjpa.model.Utente;
import it.prova.gestionecartelleesattorialispringjpa.service.ruolo.RuoloService;
import it.prova.gestionecartelleesattorialispringjpa.service.utente.UtenteService;

/**
 * Servlet implementation class PrepareModificaUtenteServlet
 */
@WebServlet("/admin/PrepareModificaUtenteServlet")
public class PrepareModificaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UtenteService utenteService;  
    @Autowired
   private RuoloService ruoloService; 
    public PrepareModificaUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idUtente = Long.parseLong(request.getParameter("idUtente"));
		Utente item = utenteService.caricaEager(idUtente);
		UtenteDTO temp = UtenteDTO.buildUtenteDTOInstance(item);
		request.setAttribute("utenteDaModificareAttributeName",item);	
		request.setAttribute("listaRuoliAttributeName", ruoloService.listAll());		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/modifica.jsp");
		rd.forward(request, response);
	}

	

}