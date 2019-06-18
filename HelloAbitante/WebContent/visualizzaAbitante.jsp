<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="it.helloabitante.model.Abitante"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Abitante temp = (Abitante)request.getAttribute("abitanteDettaglio");
%>
	<h3>Nome </h3><%=temp.getNome() %>
	<h3>Cognome </h3><%=temp.getCognome() %>
	<h3>Codifiscale </h3><%=temp.getCodiceFiscale() %>
	<h3>Eta </h3><%=temp.getEta() %>
	<h3>Motto </h3><%=temp.getMottoDiVita() %><br>
	<a href="searchForm.jsp">Torna alla ricerca</a>
</body>
</html>