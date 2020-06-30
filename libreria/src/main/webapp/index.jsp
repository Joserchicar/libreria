
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

<!-- Custom CSS -->
<link rel="stylesheet" href="css/styles.css">

</head>

<body>
	
	<main>	
		

		<table class="tabla table table-striped">
			<thead>
				<tr>
					<td>Id</td>
					<td>Titulo</td>
					<td>precio</td>
					<td>descuento</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${libros}" var="l">
					<tr>
						<td>${l.id}</td>
						<td>${l.titulo}</td>
						<td>${l.precio}</td>
						<td>${l.descuento}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>