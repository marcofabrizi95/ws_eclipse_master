<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca abitante</title>
</head>
<body>
	
		<h3 align="center">Inserire dati da ricercare</h3><br>
	
	<form action="SearchServlet" method="post" align="center">
	NOME:
	<input type="text" name="nomeInput" >
	<br>
	COGNOME:
	<input type="text" name="cognomeInput" >
	
	<input type="submit" value="CERCA">
	
	</form>

</body>
</html>