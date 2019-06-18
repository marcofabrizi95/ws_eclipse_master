<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
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
		<% List<Municipio> listamunicipi = (List<Municipio>)request.getAttribute("listaMunicipioAttributeName"); 
			for(Municipio municipioItem:listamunicipi){ %>
			<tr>
				<td><%=municipioItem.getDescrizione() %></td>
				<td><%=municipioItem.getUbicazione() %></td>
				<td>
					<a href="VisualizzaDettaglioMunicipioServlet?idMunicipio=<%=municipioItem.getId() %>" class="btn btn-info">Dettaglio</a>
					<a href="PreparaModificaMunicipioServlet?idMunicipio=<%=municipioItem.getId() %>" class="btn btn-info">Modifica</a>
					<a href="PreparaEliminaMunicipioServlet?idMunicipio=<%=municipioItem.getId() %>" class="btn btn-info">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>

	</div>
</body>
</html>