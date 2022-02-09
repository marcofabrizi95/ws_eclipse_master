<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Annuncio</title>
<script>
function validateForm() {
  var testoAnnuncioInput = document.inserisciAnnuncio.testoAnnuncioInput.value;
  var prezzoInput = document.inserisciAnnuncio.prezzoInput.value;
  var categorieId = document.inserisciAnnuncio.categorieId.value;
  var check = true;	
  if (testoAnnuncioInput == "") {
    alert("Riempi il campo Testo annuncio");
    check = false;
  }
  if ((prezzoInput == "")||(isNaN(prezzoInput))) {
	   alert("Riempi il campo prezzo");
	    check = false;
	  }
  if ((categorieId == "")||(categorieId==null)) {
	    alert("Scegli almeno una categoria");
	    check = false;
	  }
  
  return check;
}
</script>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Inserisci annuncio</h3>
	</div>

      	<form name="inserisciAnnuncio" class=" form-horizontal" action="EseguiInsertUtenteAnnuncioServlet" method="post" onsubmit="return validateForm()">
      	<input type="hidden" name="utenteIdInput" value="${ userInfo.id}">
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="testoAnnuncioInputId">Testo Annuncio:</label>
      			<div class="col-sm-4">
					<c:if test="${messaggioDiErrore.containsKey('testoAnnuncio')}">
						<div class="alert alert-danger" role="alert">
							${messaggioDiErrore.get("testoAnnuncio")}</div>
					</c:if>
				</div>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="testoAnnuncioInputId" 
					name="testoAnnuncioInput" value="">
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="prezzoInputId">Prezzo:</label>
      			<div class="col-sm-4">
					<c:if test="${messaggioDiErrore.containsKey('prezzo')}">
						<div class="alert alert-danger" role="alert">
							${messaggioDiErrore.get("prezzo")}</div>
					</c:if>
				</div>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="prezzoInputId" 
					name="prezzoInput" value="">
			 	</div>
  			</div>
		
			
		<div class="form-group">
				<label class="control-label col-sm-2" for="categorieId">Categorie:</label>
				<div class="col-sm-4">
				<div class="col-sm-4">
					<c:if test="${messaggioDiErrore.containsKey('categorie')}">
						<div class="alert alert-danger" role="alert">
							${messaggioDiErrore.get("categorie")}</div>
					</c:if>
				</div>
					<c:forEach items="${listaCategorie}" var="item">
						<input type="checkbox" name="categorieId" value="${item.id}" />
			 			${item.descrizione } <br>
					</c:forEach>
				</div>
			</div>
			


			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">inserisci</button>
		      </div>
		    </div>
		    
		</form>
		
    </div><!-- /.container -->



</body>
</html>