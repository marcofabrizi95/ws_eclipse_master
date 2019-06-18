<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%if(request.getAttribute("messaggioDiErrore") != null){ %>
		<%=request.getAttribute("messaggioDiErrore") %>
	<% }else{ %>
		Inserire dati da inserire<br>
	<%} %>

	<form action="PrepareInsertServlet" method="post">
	NOME:
	<input type="text" name="nomeInput" >
	<br>
	COGNOME:
	<input type="text" name="cognomeInput" >
	<br>
	CodiceFiscale:
	<input type="text" name="codicefiscaleInput" >
	<br>
	Età:
	<input type="text" name="etaInput" >
	<br>
	Motto DI Vita:
	<input type="text" name="mottodivitaInput" >
	<br>
	<input type="submit" value="Inserici">
	
	</form>
</body>
</html>