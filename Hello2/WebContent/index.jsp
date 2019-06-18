<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Benvenuto caro utente</title>
</head>
<body>
	<h3>Buongiorno</h3>
	<form action="MottoDelGiornoServlet" method="post">
	<input type="text" name="messaggioDelGiornInput" >
	<input type="submit" value="Avanti">
	</form>
</body>
</html>