<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Nuovo Municipio</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/jqueryUI/jquery-ui.min.css" />
<style>
.ui-autocomplete-loading {
	background: white url("img/anim_16x16.gif") right center no-repeat;
}
</style>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>
		

		<div class="page-header">
			<h3>Pagina di Dettaglio Municipio</h3>
		</div>

		<form class="form-horizontal" action="ExecuteEliminaMunicipioServlet"
			method="post">
			<input class="form-control" type="hidden" id="idInputId"
						name="idInput" value="${municipioInPagina.id }">
			<div class="form-group">
				<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
				<div class="col-sm-4">
					
				</div>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId"
						name="descrizioneInput" value="${municipioInPagina.descrizione }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
				<div class="col-sm-4">
					
				</div>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId"
						name="codiceInput" value="${municipioInPagina.codice }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="ubicazioneInputId">Ubicazione:</label>
				<div class="col-sm-4">
					
				</div>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="ubicazioneInputId"
						name="ubicazioneInputId" value="${municipioInPagina.ubicazione }">
				</div>
			</div>


						
			<%-- FUNZIONE JQUERY UI CON AJAX PER AUTOCOMPLETE --%>
		
			
			
		</form>

	</div>
	<!-- /.container -->



</body>


</html>