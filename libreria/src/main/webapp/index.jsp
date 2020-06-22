<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/cabecera.jsp">
	<jsp:param name="pagina" value="inicio" />
	<jsp:param name="title" value="inicio" />
</jsp:include>



<h1>Últimos Libros</h1>


<ol>
	<c:forEach items="${libro}" var="l">
		<li>${l}</li>
	</c:forEach>
</ol>
<%@include file="includes/pie.jsp"%>