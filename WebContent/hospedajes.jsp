<%@include file="views/base.jsp" %>
<!-- Lista hospedajes -->
	<div class="container">		
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
				<th></th>
				<th>LUGAR DISPONIBLE</th>
				<th>PROVINCIA</th>
				<th>CIUDAD</th>
				<th></th>
				</tr>
			</thead>
			<c:forEach items="${personas}" var="personas">		
			
			<tbody>
				<tr>
				<td><a href="#"><c:out value="${personas.nombre} ${personas.apellido}" /></a></td>
				<td><c:out value="${personas.casa.lugar} persona/s" /></td>
				<td><c:out value="${personas.provincia}" /></td>
				<td><c:out value="${personas.ciudad}" /></td>
				<td><a class="btn btn-primary" href="VerDetalle?id=${personas.id}">Ver detalle</a> 
				
					<% if (session.getAttribute("id") != null){ %>
						<% int count = 0; %>	
						<c:forEach items="${favoritos}" var="favoritos">
							<c:set var="fav" value="${favoritos.personaFav.id}"/>
							<c:if test="${fav == personas.id}">
								<% count =  count + 1; %>
								<a href="EliminarFavorito?id=${favoritos.id}" onclick="return confirm('Esta seguro que decea eliminar el favorito?')"> <i class="fa fa-star fa-lg markFav" data-ref="#" title="Favorito" aria-hidden="true" ></i></a>
							</c:if>
						</c:forEach>
						<% if (count == 0){ %>
							<a href="AgregarFavorito?id=${personas.id}"> <i class="fa fa-star-o fa-lg markFav" data-ref="#" title="Favorito" aria-hidden="true"></i></a>
						<%}%>
					<%}%>
					
				</td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
	</div>
</body>
<%@include file="views/footer.jsp" %>