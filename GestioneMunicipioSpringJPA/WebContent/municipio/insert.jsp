<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

 <div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Inserimeto</h3>
	</div>

      	<form class="form-horizontal" action="EseguiInsertMunicipio" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput">
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="ubicazioneInputId">Ubicazione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="ubicazioneInputId" name="ubicazioneInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId" name="codiceInput">
			 	</div>
  			</div>
		
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Inserisci</button>
		      </div>
		    </div>
		</form>

    </div><!-- /.container -->

	

</body>

</html>