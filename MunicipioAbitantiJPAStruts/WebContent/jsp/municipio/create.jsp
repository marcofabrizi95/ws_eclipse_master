<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<%@ include file="/header.jsp"%>
		<form action="${pageContext.request.contextPath }/municipio.do"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="descrizioneInputId">inserisci
					Municipio:</label>
				<div class="col-sm-4">
					DESCRIZIONE: <input type="text" name="descrizioneInput"><br>
				</div>
			</div>
			<div class="form-group">

				<div class="col-sm-4">
					CODICE: <input type="text" name="codiceInput">
				</div>
			</div>
			<br> UBICAZIONE: <input type="text" name="ubicazioneInput"><br>
			<input type="hidden" name="codop" value="save"> <input
				type="submit" value="INSERISCI">

		</form>
	</div>
</body>
</html>