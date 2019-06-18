<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.prova.model.Persona"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%if(request.getAttribute("messaggioDiErrore") != null){ %>
		<%=request.getAttribute("messaggioDiErrore") %>
	<% }else{ %>
		
	<%} %>
	<% Persona temp = (Persona) request.getAttribute("personaDaModificare"); %>
 <div class="container">

   <%@ include file="header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Modifica</h3>
	</div>

      	<form class="form-horizontal" action="ModificaPersonaServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" name="nomeInput" value="<%=temp.getNome() %> ">
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId" name="cognomeInput" value="<%=temp.getCognome() %>">
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="etaInputId">Eta:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId" name="etaInput" value="<%=temp.getEta() %>">
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="cfInputId">CF:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cfInputId" name="cfInput" value="<%=temp.getCf()%>">
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="indirizzoInputId">Indirizzo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="indirizzoInputId" name="indirizzoInput" value="<%=temp.getIndirizzo() %>">
			 	</div>
  			</div>
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Modifica</button>
		      </div>
		    </div>
		    <input class="form-control" type="hidden" id="idInputId" name="idInput" value="<%=temp.getId()%>">
		</form>

    </div><!-- /.container -->

	

</body>

</html>