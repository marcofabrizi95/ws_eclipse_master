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

  	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>La ricerca ha prodotto ${listaContribuentiAttributeName.size()} risultati: </h3>
	</div>
  	
<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Action</th>
			</tr>
		</thead>
		
			<c:forEach items="${listaContribuentiAttributeName}" var="item">
			<tr>
				<td>${item.nome}</td>
				<td>${item.cognome}</td>
				<td>
					<a href="VisualizzaDettaglioContribuenteServlet?idContribuente=${item.id }" class="btn btn-info">Dettaglio</a>
					<a href="PrepareModificaContribuenteServlet?idContribuente=${item.id }" class="btn btn-info">Modifica</a>
					<a href="PrepareEliminaContribuenteServlet?idContribuente=${item.id }" class="btn btn-info">Elimina</a>
				</td>
			</tr> 
			</c:forEach>
	
	
				
		
	</table>

</body>
</html>



