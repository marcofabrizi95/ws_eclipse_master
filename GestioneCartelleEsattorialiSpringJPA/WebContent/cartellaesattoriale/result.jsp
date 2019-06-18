<%@page import="it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale"%>
<%@page import="it.prova.gestionecartelleesattorialispringjpa.model.Contribuente"%>
<%@page import="java.util.List"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">

  	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>La ricerca ha prodotto ${listaCartelleEsattorialiAttributeName.size() } risultati: </h3>
	</div>
  	
<table class="table table-striped">
		<thead>
			<tr>
				<th>Denominazione</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${listaCartelleEsattorialiAttributeName }" var="item">
			<tr>
				<td>${item.denominazione }</td>
				<td>
					<a href="VisualizzaDettaglioCartellaEsattorialeServlet?idCartellaEsattoriale=${item.id }" class="btn btn-info">Dettaglio</a>
					<a href="PrepareModificaCartellaEsattorialeServlet?idCartellaEsattoriale=${item.id }" class="btn btn-info">Modifica</a>
					<a href="PrepareEliminaCartellaEsattorialeServlet?idCartellaEsattoriale=${item.id }" class="btn btn-info">Elimina</a>
				</td>
			</tr>
				
		</c:forEach>
	
	</table>

</body>
</html>



