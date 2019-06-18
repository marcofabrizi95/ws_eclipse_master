<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accedi</title>
</head>
<body>

	<div class="container">
		<%@ include file="../header.jsp"%>

		<div class="jumbotron">

			<h1 class="display-4">AreaRiservata di : ${userInfo.nome}
				${userInfo.cognome}</h1>
			<p>
				<a class="btn btn-primary btn-lg"
					href="PrepareAnnunciUtenteServlet?idUser=${userInfo.id}"
					role="button">Vai alla Gestione Annunci&raquo;</a>
			</p>

			<p>
				<a class="btn btn-primary btn-lg"
					href="<%= request.getContextPath() +"/Home" %>" role="button">Ricerca
						&raquo;</a>
			</p>
			<p>
				<a class="btn btn-primary btn-lg"
					href="<%= request.getContextPath() +"/VisualizzaAcquistiUtenteServlet" %>" role="button">Storico Acquisti
						&raquo;</a>
			</p>
		</div>
<!-- admin/PrepareRicercaUtenteServlet -->

		<c:if test="${userInfo.isAdmin()}">
			<div class="jumbotron">

				<h1 class="display-4">Gestione Amministrativa</h1>
				<p>
					<a class="btn btn-primary btn-lg"
						href="<%= request.getContextPath() +"/admin/gestioneAmministrativa.jsp" %>"
						role="button">Vai alla Gestione &raquo;</a>
				</p>


			</div>

		</c:if>
	</div>

	<%@ include file="../footer.jsp"%>

</body>
</html>