<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>risultati</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina dei Risultati</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome annuncio</th>
					<th>Prezzo</th>
					<th>Action</th>
				</tr>
			</thead>
		<c:forEach items="${listaAnnuncio}" var="item">
			<tr>
				<td>${item.testoAnnuncio }</td>
				<td>${item.prezzo }</td>
				<td><a
					href="<%= request.getContextPath()%>/VisualizzaDettaglioAnnuncioUtenteServlet?idAnnuncio=${item.id }"
					class="btn btn-info">Dettaglio</a> <a
					href="<%= request.getContextPath()%>/PreparaModificaAnnunciUtenteServlet?idAnnuncio=${item.id }"
					class="btn btn-info">Modifica</a> <a
					href="<%= request.getContextPath()%>/PreparaEliminaAnnunciUtenteServlet?idAnnuncio=${item.id }"
					class="btn btn-info">Elimina</a></td>
				</tr>
		</c:forEach>

		</table>
		<a href="PassaggioInserisciUtenteAnnuncioServlet" class="btn btn-info">Inserisci
			Nuovo Elemento</a>

	</div>
</body>
</html>