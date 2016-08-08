<%@include file="views/base.jsp" %>
<!-- Solicitudes -->
	<br><br>
	<div class="container">	
		<table class="table table-striped table-hover">
			<thead>
				<tr class="beGrey">
            		<th></th>
            		<th>Solicitador</th>
            		<th>Fecha Inicio</th>
            		<th>Fecha Fin</th>
            		<th>Comentario</th>
            		<th>Estado</th>
            		<th>Acciones</th>
        		</tr>
        	</thead>
        	<tbody>
	        	<c:forEach items="${solicitudes}" var="sol">
				<tr>
					<td></td>
					<td><a href="#">${sol.solicitador.nombre} ${sol.solicitador.apellido }</a></td>
					<td>${sol.desde}</td>
					<td>${sol.hasta}</td>
					<td width="10px">${sol.comentario }</td>
					<c:if test="${sol.estado == 0}">
						<td>Esperando confirmacion</td>
						<td><a class="btn btn-success" href="AceptarSolicitudController?id=${sol.id}" onclick="return confirm('Esta seguro que decea aceptar la solicitud?')">Acetar</a>
							<a class="btn btn-danger" href="RechazarSolicitud?id=${sol.id}" onclick="return confirm('Esta seguro que decea rechazar la solicitud?')">Rechazar</a> </td>
					</c:if>
					<c:if test="${sol.estado == 1}">
						<td>Confirmado</td>
						<td><td>
					</c:if>
					<c:if test="${sol.estado == 2}">
						<td>Rechazado</td>
						<td></td>
					</c:if>
	            </tr>
				</c:forEach>
			</tbody>
		</table>
		</div>

<%@ include file="views/footer.jsp" %>