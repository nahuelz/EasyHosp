<%@include file="views/base.jsp" %>
<!-- Detalle hospedaje -->
<br>
<div class="container">
	<div class="row">
		<dl class="col-lg-6">
			<h4>Datos</h4>
			<hr>
			<dt>Localidad</dt>
				<dd>${persona.provincia} - ${persona.ciudad}</dd>
			<dt>A cuantas personas puedes hospedar?</dt>
				<dd>${persona.casa.lugar} persona/s</dd>
			<dt>Hay chicos en la casa?</dt>
				<dd>${persona.casa.chicos }</dd>
			<dt>Hay mascota en la casa?</dt>
				<dd> ${persona.casa.mascota} </dd>
			<dt>La habitacion es compartida?</dt>
				<dd> ${persona.casa.habitacionCompartida} </dd>
		</dl>				
		<dl class="col-lg-6">
			<h4>Solicitar hospedarse</h4>
			<% if (session.getAttribute("id") != null){ %>
				<hr>	            
					<div id="barraBusqueda">
				        <nav class="navbar">				  
				            <form class="navbar-form navbar-left" method="POST" action="SolicitarHospedajeController">
				            	<dt>En que fecha tienes pensado viajar?</dt>
				                <div class="form-group">
				                    <input type="text" class="form-control" name="datefilter" id="fechas" value="" placeholder="Fecha" required />
				                    <input type="hidden" name="desde" id="desde" value="">
				                    <input type="hidden" name="hasta" id="hasta" value="">
				                    <input type="hidden" name="idCasa" value="${persona.casa.id}">
				                    <input type="hidden" name="idDueño" value="${persona.id}">
				                    <input type="hidden" name="idSolicitador" value="<%= session.getAttribute("id")%>">
				                    
				                </div>
				                <button id="btnCleanSearch" type="reset" class="btn btn-warning searchOrder" data-path="#">Limpiar</button>		                				            	
				            	<br><br>
				            	<dt>Escribi un comentario (opcional)</dt>			            		
				            	<div name="comentario" class="form-group">
				            		<textarea name="comentario" class="form-control" cols="35" rows="4"></textarea><br><br>
								</div>
								<br>
								<button class="btn btn-success">Solicitar</button>				            		
				            </form>
						</nav>
					</div>    	        
			<% }else{ %>
				<hr>
				<dt>Hace click <a href="registro.jsp">Aqui</a> para registrarte o <a href="login.jsp">Inicia sesion</a> para enviar una solicitud!</dt>
           	<% } %>
		</dl>
	</div>
</div>		
<%@ include file="views/footer.jsp" %>

