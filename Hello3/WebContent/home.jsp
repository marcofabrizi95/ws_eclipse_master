<%@page import="it.prova.model.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Persona temp = (Persona)request.getAttribute("miaPersona"); %>
<h3>il tuo nome è <%=temp.getNome()+" "+temp.getCognome() %></h3>
<a href="registrazione.jsp">GO BACK</a>

</body>
</html>