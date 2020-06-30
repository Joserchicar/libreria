<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Formulario Para Crear/Modificar Libro</h1>
	
	<div class="row pb-4">
	
		<div class="col">
				<form action="inicio" method="post">
			
				<div class="form-group">
					<label for="id">id:</label>
					<input type="text" name="id" id="id" value="${libro.id}" readonly class="form-control">
				</div>	
				
				<div class="form-group">
					<label for="titulo">titulo:</label>
					<input type="text" name="titulo" id="titulo" value="${libro.titulo}" class="form-control" placeholder="Escribe el nombre del producto" >
				</div>
				
				<div class="form-group">
					<label for="precio">precio:</label>
					<input type="text" name="precio" id="precio" value="${producto.precio}" class="form-control" placeholder="0.0 €" >
				</div>
				
				<div class="form-group">
					<label for="descuento">descuento:</label>
					<input type="text" name="descuento" id="descuento" value="${libro.descuento}" class="form-control" placeholder="URL de la imagen (.jpg o .png)" >
				</div>
				
				<input type="submit" value="Guardar" class="btn btn-primary btn-block">
			</form>
		</div>




</body>
</html>