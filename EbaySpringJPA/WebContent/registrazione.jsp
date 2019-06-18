<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Contribuente</title>
<script>
function validateForm() {
  var nome = document.registrazione.nomeInput.value;
  var cognome = document.registrazione.cognomeInput.value;
  var username = document.registrazione.usernameInput.value;
  var password = document.registrazione.passwordInput.value;
  var check = true;	
  if (nome == "") {
    alert("Riempi il campo nome");
    check = false;
  }
  if (cognome == "") {
	   alert("Riempi il campo cognome");
	    check = false;
	  }
  if (username == "") {
	    alert("Riempi il campo username");
	    check = false;
	  }
  if (password == "") {
	    alert("Riempi il campo password");
	    check = false;
	  }
  return check;
}
</script>
</head>
<body>


	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Inserisci nuovo Utente</h3>
		</div>

		<form name="registrazione" class="form-horizontal" action="ExecuteRegistrazioneUtenteServlet"
			method="post"  onsubmit="return validateForm()">
			<!--       	<form class="form-horizontal" action="ExecuteInserisciContribuenteServlet" method="post"> -->
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>

				<div class="col-sm-4">
					<c:if test="${messaggioDiErrore.containsKey('nome')}">
						<div class="alert alert-danger" role="alert">
							${messaggioDiErrore.get("nome")}</div>
					</c:if>
				</div>
				<div class="col-sm-4">
				<input class="form-control" type="text" id="nomeInputId"
					name="nomeInput" >
				</div>	
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>

				<div class="col-sm-4">
					<c:if test="${messaggioDiErrore.containsKey('cognome')}">
						<div class="alert alert-danger" role="alert">
							${messaggioDiErrore.get("cognome")}</div>

					</c:if>
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="usernameInputId">Username:</label>

				<div class="col-sm-4">
					<c:if test="${messaggioDiErrore.containsKey('username')}">
						<div class="alert alert-danger" role="alert">
							${messaggioDiErrore.get("username")}</div>

					</c:if>
					<c:if test="${messaggioDiErroreUsername!=null}">
						<div class="alert alert-danger" role="alert">
							${messaggioDiErroreUsername}</div>

					</c:if>
					<input class="form-control" type="text" id="usernameInputId"
						name="usernameInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="passwordInputId">Password:</label>

				<div class="col-sm-4">
					<c:if test="${messaggioDiErrore.containsKey('password')}">
						<div class="alert alert-danger" role="alert">
							${messaggioDiErrore.get("password")}</div>

					</c:if>
					<input class="form-control" type="text" id="passwordInputId"
						name="passwordInput">
				</div>
			</div>
			
		
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Inserisci</button>
				</div>
			</div>
		</form>

	</div>
	<!-- /.container -->



</body>
</html>