<%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
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

  	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Pagina dei Risultati</h3>
	</div>
  	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cantina</th>
				<th>Action</th>
			</tr>
		</thead>
		<% List<Abitante> listaAbitanti = (List<Abitante>)request.getAttribute("listaAbitanteAttributeName"); 
			for(Abitante abitanteItem:listaAbitanti){ %>
			<tr>
				<td><%=abitanteItem.getNome() %></td>
				<td><%=abitanteItem.getCognome() %></td>
				<td>
					<a href="VisualizzaDettaglioAbitanteServlet?idAbitante=<%=abitanteItem.getId() %>" class="btn btn-info">Dettaglio</a>
					<a href="PreparaModificaAbitanteServlet?idAbitante=<%=abitanteItem.getId() %>" class="btn btn-info">Modifica</a>
					<a href="PreparaEliminaAbitanteServlet?idAbitante=<%=abitanteItem.getId() %>" class="btn btn-info">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>

	</div>
</body>
</html>