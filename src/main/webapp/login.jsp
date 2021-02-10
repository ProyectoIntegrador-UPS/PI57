<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.ecodeup.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

		<a href="http://localhost:8080/JSF_JPA_CRUD/index.jsf"><img src="images/banner2.png" width="1520px"></img></a>
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h2>Ingreso al Sistema</h2>
		
		<form action="<%=request.getContextPath()%>/login" method="post">

			<div class="form-group">
				<label for="uname">Nombre de Usuario:</label> <input type="text"
					class="form-control" id="username" placeholder="Nombre de Usuario"
					name="username" required>
			</div>

			<div class="form-group">
				<label for="uname">Contraseña:</label> <input type="password"
					class="form-control" id="password" placeholder="Contraseña"
					name="password" required>
			</div>


			<button type="submit" class="btn btn-primary">Ingresar</button>
		</form>
	</div>

      <div id="footer">


</div>
<br></br>


   
   
<a><img src="images/footer.png" width="1520px"></img></a>     
<div style="text-align: center; font-size: 1em;"><b>Versión: 1.0 | Copyright© 2020. Know COVID. Todos los derechos reservados. </b></div>
	
<div style="text-align: center; font-size: 1em;"><b>Diseño realizado por Saurios INC.</b></div>
</body>
</html>