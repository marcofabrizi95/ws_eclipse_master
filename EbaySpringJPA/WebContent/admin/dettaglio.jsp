<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div class="container">
		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio di: ${utenteInPagina.username } </h3>
		</div>
		
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${utenteInPagina.nome }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${utenteInPagina.cognome }</dd>
			</dl>
			
			<dl class="row">
				<dt class="col-sm-3 text-right">Username</dt>
				<dd class="col-sm-9">${utenteInPagina.username } </dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Password</dt>
				<dd class="col-sm-9">${utenteInPagina.password } </dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Data Inserimento</dt>
				<dd class="col-sm-9">${utenteInPagina.dataRegistrazione }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Credito</dt>
				<dd class="col-sm-9">${utenteInPagina.creditoResiduo } </dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Ruoli</dt>
				
			<c:forEach items="${utenteInPagina.ruoli}" var="temp"><dd class="col-sm-9">${temp.descrizione }</dd> </c:forEach>
				
			</dl>
			
			
		</div>
		</div>
<%-- 		<a href="<%= request.getContextPath()%>/home.jsp" class="btn btn-primary btn-md" >Nuova ricerca</a> --%>

</body>
</html>