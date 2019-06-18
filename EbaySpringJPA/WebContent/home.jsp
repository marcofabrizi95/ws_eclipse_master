<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accedi</title>
</head>
<body>
<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Ricerca annuncio</h3>
		</div>

		<form name= "ricercaAnnuncio"class="form-horizontal"
			action="${pageContext.request.contextPath}/PrepareSearchAnnuncioServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="annuncioInputId">Ricerca annuncio:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="annuncioInputId"
						name="annuncioInputId">
				</div>
			</div>
		<div class="form-group">
				<label class="control-label col-sm-2" for="prezzoInputId">Prezzo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="prezzoInputId"
						name="prezzoInputId">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="categorieId">Categorie:</label>
				<div class="col-sm-4">

					<c:forEach items="${listaCategorie}" var="item">
						<input type="checkbox" name="categorieId" value="${item.id}" />
			 			${item.descrizione } <br>
					</c:forEach>
				</div>
			</div>



			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">EffettuaRicerca</button>
					
				</div>
			</div>
		</form>

	</div>
	<!-- /.container -->



</body>
</html>