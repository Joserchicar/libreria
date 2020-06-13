<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/cabecera.jsp">
	<jsp:param name="pagina" value="usuario" />
	<jsp:param name="title" value="Usuarios" />
</jsp:include>


<p style="color: red">${mensaje}</p>


<form action="registro" method="post">
	<div class="form-group">
		<label for="id">id </label> <input type="text" name="id"
			Value="${libro.id}" class="form-control">
	</div>
	<br>
	<div class="form-group">
		<label for="titulo">titulo del libro</label> <input type="text"
			name="titulo" Value="${libro.titulo}" class="form-control"
			placeholder="Introduce el Titulo" id="titulo">
	</div>
	<br>
	<button type="submit" class="btn btn-primary">Submit</button>
</form>



<%@include file="includes/pie.jsp"%>