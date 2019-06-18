<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.prova.model.Vino"%>
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
	<% Vino temp = (Vino) request.getAttribute("vinoDaModificare"); %>
 <div class="container">

   <%@ include file="header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Modifica</h3>
	</div>

      	<form class="form-horizontal" action="EseguiModificaServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" name="nomeInput" value="<%=temp.getNome()%>">
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cantinaInputId">Cantina:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cantinaInputId" name="cantinaInput" value="<%=temp.getCantina() %>">
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="annataInputId">Annata:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="annataInputId" name="annataInput" value="<%=temp.getAnnata() %>">
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="uvaInputId">Uva:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="uvaInputId" name="uvaInput" value="<%=temp.getUva()%>">
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="localitaInputId">Localita:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="localitaInputId" name="localitaInput" value="<%=temp.getLocalita() %>">
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