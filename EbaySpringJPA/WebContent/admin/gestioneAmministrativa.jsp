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

			<h1 class="display-4">AreaRiservata Agli Admin</h1>
			<p>
				<a class="btn btn-primary btn-lg"
					href="PrepareRicercaUtenteServlet"
					role="button">Vai alla Gestione Utenti&raquo;</a>
			</p>

			
			
		</div>
<!-- admin/PrepareRicercaUtenteServlet -->

			<div class="jumbotron">

				<h1 class="display-4">Vai alla Gestione Categoria</h1>
				<p>
					<a class="btn btn-primary btn-lg"
						href="<%= request.getContextPath() +"/admin/PrepareRicercaCategoriaServlet" %>"
						role="button">Vai alla Gestione &raquo;</a>
				</p>


			</div>

	</div>

	<%@ include file="../footer.jsp"%>

</body>
</html>