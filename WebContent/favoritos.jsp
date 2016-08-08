<%@ include file="views/base.jsp" %>
<br><br><br>
	<div class="container">		
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
				<th>LUGAR DISPONIBLE</th>
				<th>PROVINCIA</th>
				<th>CIUDAD</th>
				<th></th>
				</tr>
			</thead>
			<c:forEach items="${favoritos}" var="favoritos">	
			
			<tbody>
				<tr>
				<td><c:out value="${favoritos.personaFav.casa.lugar} persona/s" /></td>
				<td><c:out value="${favoritos.personaFav.provincia}" /></td>
				<td><c:out value="${favoritos.personaFav.ciudad}" /></td>
				<td>
					<a class="btn btn-primary" href="VerDetalle?id=${favoritos.personaFav.casa.id}">Ver detalle</a> 						
					<a href="EliminarFavorito?id=${favoritos.id}" onclick="return confirm('Esta seguro que decea eliminar el favorito?')"> <i class="fa fa-star fa-lg markFav" data-ref="#" title="Favorito" aria-hidden="true" ></i></a>
				</td>
				
				</tr>
			</tbody>
			</c:forEach>
		</table>
	</div>
</body>
		
<%@include file ="views/footer.jsp" %>