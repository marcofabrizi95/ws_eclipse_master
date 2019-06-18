<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Utenti</title>
<script>
function validateForm() {
  var nome = document.ricercaUtente.nomeInput.value;
  var cognome = document.ricercaUtente.cognomeInput.value;
  var username = document.ricercaUtente.usernameInput.value;
 
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
  

  
  return check;
}
</script>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Ricerca Utente</h3>
		</div>
		<div>
			<form name="ricercaUtente" class="form-horizontal"
				action="${pageContext.request.contextPath}/admin/ExecuteRicercaUtenteServlet"
				method="post"  onsubmit="return validateForm()">
				<div class="form-group">
					<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
					<div class="col-sm-4">
						<input class="form-control" type="text" id="nomeInputId"
							name="nomeInput">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
					<div class="col-sm-4">
						<input class="form-control" type="text" id="cognomeInputId"
							name="cognomeInput">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="usernameInputId">Username:</label>
					<div class="col-sm-4">
						<input class="form-control" type="text" id="usernameInputId"
							name="usernameInput">
					</div>
				</div>
				<div class="form-group">

					<button type="submit" class="btn btn-primary btn-md">Effettua
						Ricerca</button>
					<a href="PrepareInserisciUtenteServlet"
						class="btn btn-primary btn-md">Inserisci Nuovo Utente</a>
				</div>

			</form>
		</div>
	</div>
	<!-- /.container -->



</body>
</html>