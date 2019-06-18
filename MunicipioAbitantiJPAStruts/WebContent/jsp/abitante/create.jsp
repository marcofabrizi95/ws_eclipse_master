<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

   <%@ include file="/header.jsp" %>
      
    <div class="page-header">
	  <h3>Inserisci Abitante</h3>
	</div>

      	<form class=" form-horizontal" action="${pageContext.request.contextPath }/abitante.do" method="post">
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId">Nome</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" 
					name="nome" value="">
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId" 
					name="cognome" value="">
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="etaInputId">Eta:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId" 
					name="eta" value="">
			 	</div>
  			</div>
		<div class="form-group">
      			<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId" 
					name="residenza" value="">
			 	</div>
  			</div>
			
		<div class="form-group">
				<label class="control-label col-sm-2" for="municipioId">Municipi:</label>
				<div class="col-sm-4">
					<c:forEach items="${listaMunicipi}" var="item">
						<input type="checkbox" name="municipioId" value="${item.id}" />
			 			${item.descrizione } <br>
					</c:forEach>
				</div>
			</div>
			


			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		      <input type="hidden" name="codop" value="save">
		        <button type="submit" class="btn btn-primary btn-md">inserisci</button>
		      </div>
		    </div>
		    
		</form>
		
    </div><!-- /.container -->



</body>
</html>