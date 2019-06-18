<%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Vino</title>
</head>
<body>

	<%
		Abitante abitanteInPagina = (Abitante) request.getAttribute("abitanteSingoloAttributeName");
	%>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getId()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getNome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Eta</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getEta()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Residenza</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getResidenza()%></dd>
			</dl>
			 <dl class="row">
				<dt class="col-sm-3 text-right">Residenza</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getMunicipio().getDescrizione()%></dd>
			</dl>
        <p><a class="btn btn-primary btn-lg" href="home.jsp"  role="button">Vai alla Home &raquo;</a></p>
      
	 </div>
	</div>

</body>
</html>