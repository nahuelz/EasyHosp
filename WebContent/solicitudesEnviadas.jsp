<%@include file="views/base.jsp" %>
<!-- Solicitudes -->
	<br><br>
	<div class="container">	
		<table class="table table-striped table-hover">
			<thead>
				<tr class="beGrey">
            		<th></th>
            		<th>Dueño</th>
            		<th>Casa</th>
            		<th>Fecha Inicio</th>
            		<th>Fecha Fin</th>
            		<th>Estado</th>
            		<th>Acciones</th>
        		</tr>
        	</thead>
        	<tbody>
	        	<c:forEach items="${solicitudes}" var="sol">
				<tr>
					<td></td>
					<td><a href="#">${sol.dueño.nombre} ${sol.dueño.apellido }</a></td>
					<td><a href="VerDetalle?id=${sol.dueño.casa.id}">Ver detalle</a></td>
					<td>${sol.desde}</td>
					<td>${sol.hasta}</td>
					<c:if test="${sol.estado == 0}">
						<td>Esperando confirmacion</td>
						<td><a class="btn btn-danger" href="CancelarSolicitudController?id=${sol.id}" onclick="return confirm('Esta seguro que decea cancelar la solicitud?')">Cancelar</a> </td>
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