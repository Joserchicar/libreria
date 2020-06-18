<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/cabecera.jsp">
	<jsp:param name="pagina" value="index" />
	<jsp:param name="title" value="index" />
</jsp:include>


<!-- tabla listado libros -->
<table class="tabla table table-striped">
	<thead>
		<tr>
			<td>Id</td>
			<td>Titulo</td>
			<td>Acciones</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${libros}" var="l">
			<tr>
				<td>${l.id}</td>
				<td>${l.titulo}</td>
				<td><a href="registro?id=${l.id}" class="mr-4"> <i
						class="far fa-edit fa-2x" title="Editar libro"></i></a> <a
					href="EliminarLibro?id=${l.id}"
					onclick="confirmar('¿Estas Seguro ?')"><i
						class="fas fa-trash fa-2x" title="Eliminar libro"></i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@include file="includes/pie.jsp" %>