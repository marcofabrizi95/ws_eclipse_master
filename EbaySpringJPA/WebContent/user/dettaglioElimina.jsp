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
			<h3>Pagina di Dettaglio di: ${annuncioInPagina.testoAnnuncio } </h3>
		</div>
		
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9">${annuncioInPagina.testoAnnuncio }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Prezzo</dt>
				<dd class="col-sm-9">${annuncioInPagina.prezzo }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Utente</dt>
				<dd class="col-sm-9">${annuncioInPagina.utente.nome } ${annuncioInPagina.utente.cognome }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Data Inserimento</dt>
				<dd class="col-sm-9">${annuncioInPagina.dataAnnuncio }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Categorie</dt>
				
			<c:forEach items="${annuncioInPagina.categorie}" var="temp"><dd class="col-sm-9">${temp.descrizione }</dd> </c:forEach>
				
			</dl>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<a href="EseguiEliminaUtenteAnnuncioServlet?idAnnuncio=${annuncioInPagina.id}"class="btn btn-info">Elimina</a>	
				</div>
			</div>
			
		</div>
		</div>
<%-- 		<a href="<%= request.getContextPath()%>/home.jsp" class="btn btn-primary btn-md" >Nuova ricerca</a> --%>

</body>
</html>