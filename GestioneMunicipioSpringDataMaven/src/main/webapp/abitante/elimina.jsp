<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Nuovo Abitante</title>
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
			<h3>Pagina di Inserimento Abitante</h3>
		</div>

		<form class="form-horizontal" action="ExecuteEliminaAbitanteServlet"
			method="post">
			<input class="form-control" type="hidden" id="idInputId"
						name="idInput" value="${abitanteInPagina.id }">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput" value="${abitanteInPagina.nome }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput" value="${abitanteInPagina.cognome }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="etaInputId">Eta:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId"
						name="etaInput" value="${abitanteInPagina.eta }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId"
						name="residenzaInput" value="${abitanteInPagina.residenza }">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="municipioInputId">Municipio:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="municipioInputId"
						name="municipioInput" value="${abitanteInPagina.municipio.descrizione }">
				</div>
			</div>
             <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Elimina
						</button>
				</div>
			</div>
			
		</form>

	</div>
	<!-- /.container -->



</body>


</html>