<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualizza Municipio</title>
</head>
<body>

ID:${MunicipioForm.id }<br>
DESCRIZIONE:${MunicipioForm.descrizione }<br>
CODICE:${MunicipioForm.codice }<br>
UBICAZIONE:${MunicipioForm.ubicazione }<br>
<br><br>
<table border="2">
	<thead>
		<th>NOME</th>
		<th>COGNOME</th>
		<th>AZIONI</th>
	</thead>
	<c:forEach var="abitanteItem" items="${MunicipioForm.abitanti }">
		<tbody>
			<tr>
				<td>${abitanteItem.nome }</td>
				<td>${abitanteItem.cognome }</td>
				<td><a href="${pageContext.request.contextPath }/municipio.do?id=${municipioItem.id}&codop=show">visualizza</a></td>
			</tr>
		</tbody>
	</c:forEach>
</table>
<a href="${pageContext.request.contextPath }/municipio.do?codop=create">Nuovo Municipio</a>
<form action="${pageContext.request.contextPath }/municipio.do">
	<input type="hidden" name="codop" value="delete">
	<input type="hidden" name="idMunicipio" value="${MunicipioForm.id }">
	<input type="submit" value="RIMUOVI">
</form>
</body>
</html>