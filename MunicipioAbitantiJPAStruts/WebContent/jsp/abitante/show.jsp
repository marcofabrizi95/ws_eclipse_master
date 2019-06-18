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
		<%@ include file="/header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio di: ${AbitanteForm.nome } </h3>
		</div>
		
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${AbitanteForm.nome }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${AbitanteForm.cognome }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Eta</dt>
				<dd class="col-sm-9">${AbitanteForm.eta}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Residenza</dt>
				<dd class="col-sm-9">${AbitanteForm.residenza }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Municipio</dt>
				<dd class="col-sm-9">${AbitanteForm.municipio.descrizione }</dd>
			</dl>
		</div>
		</div>
<%-- 		<a href="<%= request.getContextPath()%>/home.jsp" class="btn btn-primary btn-md" >Nuova ricerca</a> --%>

</body>
</html>