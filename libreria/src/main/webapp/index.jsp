<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/cabecera.jsp">
	<jsp:param name="pagina" value="inicio" />
	<jsp:param name="title" value="inicio" />
</jsp:include>



<h1>Últimos Libros</h1>


<ol>
	<c:forEach items="${libros}" var="l">
		<li>${l}</li>
	</c:forEach>
</ol>

<div class="row-card">	

			<c:forEach items="${libros}" var="l" >
						
					<div class="card">
					  <img src="${l.titulo}" class="card-img-top" alt="${l.id}">
					  <div class="card-body">
					    <h5 class="card-title">${l.titulo}</h5>
					    <p><span class="badge badge-secondary">${l.genero.genero}</span></p>
					    <!-- <p class="precio">${p.precio} €</p> -->					    					    
					  </div>
					</div>
				
			</c:forEach>
	</div>

	<c:forEach items="${generoConlibros}" var="c">
				
				<h4>${g.genero}</h4>
				
				<div class="row-card">
						
					<c:forEach items="${g.libros}" var="p">	
						
						<div class="card">
						<!--   <img src="${p.imagen}" class="card-img-top" alt="${p.nombre}"> -->
						  <div class="card-body">
						    <h5 class="card-title">${l.titulo}</h5>
						    <p><span class="badge badge-secondary">${l.genero.genero}</span></p>
						  <!--    <p class="precio">${p.precio} €</p>	-->				    					    
						  </div>
						</div>
						
					</c:forEach>
					
				</div>
				
			</c:forEach>
			

<%@include file="includes/pie.jsp"%>