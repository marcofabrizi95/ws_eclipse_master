package it.prova.gestionecartelleesattorialispringjpa.web.servlet.cartellaesattoriale;

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

import it.prova.gestionecartelleesattorialispringjpa.dto.CartellaEsattorialeDTO;
import it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale;
import it.prova.gestionecartelleesattorialispringjpa.service.cartellaesattoriale.CartellaEsattorialeService;
import it.prova.gestionecartelleesattorialispringjpa.service.contribuente.ContribuenteService;

@WebServlet("/ExecuteInserisciCartellaEsattorialeServlet")
public class ExecuteInserisciCartellaEsattorialeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CartellaEsattorialeService cartellaEsattorialeService;

	@Autowired
	private ContribuenteService contribuenteService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteInserisciCartellaEsattorialeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		int importoInput;
		try {
			 importoInput = Integer.parseInt(request.getParameter("importoInput"));
		} catch (Exception e) {
			 importoInput =-1;
					}

		String denominazioneInput = request.getParameter("denominazioneInput");
		String descrizioneInput = request.getParameter("descrizioneInput");

		CartellaEsattorialeDTO temp= new CartellaEsattorialeDTO(denominazioneInput, descrizioneInput, importoInput,Long.parseLong(request.getParameter("contribuenteInput")));
		if (!temp.validate().isEmpty()) {
			request.setAttribute("messaggioDiErrore",temp.validate());

			RequestDispatcher rd = request.getRequestDispatcher("/cartellaesattoriale/insert.jsp");
			rd.forward(request, response);
			
			return;
		} 
		CartellaEsattoriale cartellaEsattorialeDaInserire = CartellaEsattorialeDTO.buildCartellaEsattorialeInstance(temp);
		cartellaEsattorialeDaInserire.setContribuente(contribuenteService.carica(temp.getContribuente()));
		cartellaEsattorialeService.inserisci(cartellaEsattorialeDaInserire);

		response.sendRedirect("SendRedirectCartellaEsattorialeServlet");

	}

}
