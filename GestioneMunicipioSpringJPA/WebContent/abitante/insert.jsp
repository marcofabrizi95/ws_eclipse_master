<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%if(request.getAttribute("messaggioDiErrore") != null){ %>
	<%=request.getAttribute("messaggioDiErrore") %>
	<% }else{ %>

	<%} %>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Inserimeto</h3>
		</div>

		<form class="form-horizontal" action="EseguiInsertAbitanteServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="etaInputId">Eta:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId"
						name="etaInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId"
						name="residenzaInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="municipioInputId">Municipio:</label>
				<div class="col-sm-4">
					<select name="municipioId">
						<option value=0>Seleziona un'opzione</option>
						<% List<Municipio> listamunicipi = (List<Municipio>)request.getAttribute("listaMunicipi"); 
			            for(Municipio municipioItem:listamunicipi){ %>
						<option value="<%=municipioItem.getId()%>"><%=municipioItem.getDescrizione()%></option>
						<%} %>

					</select>
				</div>
			</div>
			<br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Inserisci</button>
				</div>
			</div>
		</form>

	</div>
	<!-- /.container -->



</body>

</html>