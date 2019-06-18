<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Abitanti</title>
</head>
<body>

	<div class="container">

		<%@ include file="/header.jsp"%>

		<div class="page-header">
			<h3>Lista Abitanti</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Cognome</th>
				</tr>
			</thead>
			<c:forEach items="${AbitanteForm}" var="item">
				<tr>
					<td>${item.nome }</td>
					<td>${item.cognome }</td>
					<td><a
						href="${pageContext.request.contextPath }/abitante.do?idAbitante=${item.id}&codop=show"
						class="btn btn-info">Dettaglio</a> <a
						href="${pageContext.request.contextPath }/abitante.do?idAbitante=${item.id}&codop=change"
						class="btn btn-info">Modifica</a></td>
				</tr>
			</c:forEach>

		</table>
		<a
			href="${pageContext.request.contextPath }/abitante.do?codop=create"
			class="btn btn-info">Inserisci Nuovo</a>

	</div>
</body>
</html>