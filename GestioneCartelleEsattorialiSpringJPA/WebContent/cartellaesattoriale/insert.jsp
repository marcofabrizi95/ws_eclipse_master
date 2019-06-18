<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento Cartella Esattoriale</title>
</head>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Nuova Cartella Esattoriale</h3>
	</div>

      	<form class="form-horizontal" action="ExecuteInserisciCartellaEsattorialeServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="denominazioneInputId">Denominazione:</label>
      			<div class="col-sm-4">
					<c:if test="${messaggioDiErrore.containsKey('denominazione')}">
						<div class="alert alert-danger" role="alert">
							${messaggioDiErrore.get("denominazione")}</div>
					</c:if>
				</div>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="denominazioneInputId" name="denominazioneInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
      			<div class="col-sm-4">
					<c:if test="${messaggioDiErrore.containsKey('descrizione')}">
						<div class="alert alert-danger" role="alert">
							${messaggioDiErrore.get("descrizione")}</div>
					</c:if>
				</div>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="importoInputId">Importo:</label>
      			<div class="col-sm-4">
					<c:if test="${messaggioDiErrore.containsKey('importo')}">
						<div class="alert alert-danger" role="alert">
							${messaggioDiErrore.get("importo")}</div>
					</c:if>
				</div>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="importoInputId" name="importoInput" >
			 	</div>
  			</div>

			
			<div class="form-group">
				<label class="control-label col-sm-6" for="contribuenteInputId">Contribuente:</label>
				<div class="col-sm-4">
					<c:if test="${messaggioDiErrore.containsKey('idCont')}">
						<div class="alert alert-danger" role="alert">
							${messaggioDiErrore.get("idCont")}</div>
					</c:if>
				</div>
				<div class="col-sm-6">
					<select name="contribuenteInput" class="control-label col-sm-6"
						id="contribuenteInputId">
						<option value="-1">Seleziona un Contribuente</option>

						<c:forEach items="${listaContribuentiAttributeName}" var="item">
						
						<option value="${item.id}">
							${item.nome}
							${item.cognome}
							</option>
					</c:forEach>
					</select>
				</div>
			</div>


			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Inserisci nuova Cartella Esattoriale</button>
		      </div>
		    </div>
		    
		</form>
		
    </div><!-- /.container -->



</body>
</html>