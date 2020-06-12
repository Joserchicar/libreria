
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Index</title>


<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<!-- datatables -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

<!--  CSS propio -->
<link rel="stylesheet" href="css/styles.css">

</head>

<body id="top">
	<header>
		<!-- encabezado pagina -->
		<h1>Libreria</h1>

	</header>
	<!-- Barra navegacion -->
	<nav class="navbar navbar-expand-sm bg-dark">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="inicio">pagina
					principal</a></li>
			<li class="nav-item"><a class="nav-link" href="inicio">listado
					de libros</a></li>
			<li class="nav-item"><a class="nav-link" href="registro">gestion libros</a></li>
			
			<li class="nav-item"><a class="nav-link" href="EliminarLibro">eliminar</a></li>
		</ul>
	</nav>
	<br>

	<main>
		<!-- tabla listado libros -->
		<table class="tabla table table-striped">
			<thead>
				<tr>
					<td>Id</td>
					<td>Titulo</td>
					<td>Acciones </td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${libros}" var="l">
					<tr>
						<td>${l.id}</td>
						<td>${l.titulo}</td>
						
						
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	<div>
		<!-- pie de pagina-->
		<footer class="container">
			<div>
				<a href="#"> <i class="fab fa-facebook"></i></a> <a href="#"><i
					class="fab fa-twitter-square"></i></a>
			</div>
			<div>
				<a href="#">politica de privacidad</a> <a href="#">Contacto</a>
			</div>

			<p>&copy; Libreria 2020</p>
		</footer>

	</div>
	<a href="#top"
		class="btn btn-warning position-fixed fixed-bottom d-block d-sm-none">Top</a>



</body>
</html>