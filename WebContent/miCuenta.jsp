<%@include file="views/base.jsp" %>
<br>
	<div class="container">
    <div class="main">
        <div class="col-lg-12">
            <h1 class="page-header">
                Mi Cuenta
            </h1>
        </div>
        <div class="row">
            <div class="col-sm-8 col-md-4 col-md-offset-4 panel panel-default" style="margin-top: 5%;">
                <form id="formEditUsuario" action="EditarPersonaController" method="POST">
                    <h1 class="text-center login-title">Mis Datos</h1>
                    <input type="hidden" name="id" value="${persona.id}">
                    <div class="form-group">
                        <label>Nombre*</label>
                        <input type="text" name="nombre" class="form-control" required value="${persona.nombre}">
                    </div>
                    <div class="form-group">
                        <label>Apellido*</label>
                        <input type="text" name="apellido" class="form-control" value="${persona.apellido}" required>
                    </div>
                    <div class="form-group">
                        <label>Email*</label>
                        <input type="email" name="email" class="form-control" id="emailEdit" value="${persona.email}" disabled="disabled">
                    </div>
                    <div class="form-group">
                    	<label>Provincia*</label>
						<select name="provincia" class="form-control">
							<option value="todos">A que provincia queres ir? </option>
							<option value="Buenos Aires" <c:if test="${persona.provincia == 'Buenos Aires'}"> selected </c:if>>Buenos Aires</option>
							<option value="Catamarca"<c:if test="${persona.provincia == 'Catamarca'}"> selected </c:if>>Catamarca</option>
							<option value="Chaco"<c:if test="${persona.provincia == 'Chaco'}"> selected </c:if>>Chaco</option>
							<option value="Chubut"<c:if test="${persona.provincia == 'Chubut'}"> selected </c:if>>Chubut</option>					  
							<option value="Cordoba"<c:if test="${persona.provincia == 'Cordoba'}"> selected </c:if>>Córdoba</option>
							<option value="Corrientes"<c:if test="${persona.provincia == 'Corrientes'}"> selected </c:if>>Corrientes</option>
							<option value="Entre Ríos"<c:if test="${persona.provincia == 'Entre Ríos'}"> selected </c:if>>Entre Ríos</option>
							<option value="Formosa"<c:if test="${persona.provincia == 'Formosa'}"> selected </c:if>>Formosa</option>
							<option value="Jujuy"<c:if test="${persona.provincia == 'Jujuy'}"> selected </c:if>>Jujuy</option>
							<option value="La Pampa"<c:if test="${persona.provincia == 'La Pampa'}"> selected </c:if>>La Pampa</option>
							<option value="La Rioja"<c:if test="${persona.provincia == 'La Rioja'}"> selected </c:if>>La Rioja</option>
							<option value="Mendoza"<c:if test="${persona.provincia == 'Mendoza'}"> selected </c:if>>Mendoza</option>
							<option value="Misiones"<c:if test="${persona.provincia == 'Misiones'}"> selected </c:if>>Misiones</option>
							<option value="Neuquen"<c:if test="${persona.provincia == 'Neuquen'}"> selected </c:if>>Neuquén</option>
							<option value="Rio Negro"<c:if test="${persona.provincia == 'Rio Negro'}"> selected </c:if>>Río Negro</option>
							<option value="Salta"<c:if test="${persona.provincia == 'Salta'}"> selected </c:if>>Salta</option>
							<option value="San Juan"<c:if test="${persona.provincia == 'San Juan'}"> selected </c:if>>San Juan</option>
							<option value="San Luis"<c:if test="${persona.provincia == 'San Luis'}"> selected </c:if>>San Luis</option>
							<option value="Santa Cruz"<c:if test="${persona.provincia == 'Santa Cruz'}"> selected </c:if>>Santa Cruz</option>
							<option value="Santa Fe"<c:if test="${persona.provincia == 'Santa Fe'}"> selected </c:if>>Santa Fe</option>
							<option value="Santiago del Estero"<c:if test="${persona.provincia == 'Santiago del Estero'}"> selected </c:if>>Santiago del Estero</option>
							<option value="Tierra del Fuego"<c:if test="${persona.provincia == 'Tierra del Fuego'}"> selected </c:if>>Tierra del Fuego</option>
							<option value="Tucuman"<c:if test="${persona.provincia == 'Tucuman'}"> selected </c:if>>Tucumán</option>			  
						</select>
					</div>
                    <div class="form-group">
                        <label>Ciudad*</label>
                        <input type="text" name="ciudad" class="form-control" value="${persona.ciudad}" required>
                    </div>
                    <div class="form-group">
                        <label>Telefono</label>
                        <input type="text" name="tel" class="form-control" value="${persona.telefono}">
                    </div>
                    <div class="form-group">
                        <label>DNI</label>
                        <input type="text" name="dni" class="form-control" value="${persona.dni}" required>
                    </div>
                    <div class="form-group">
                        <p style="font-weight: 700">Sexo</p>
                            <label class="radio-inline"><input <c:if test="${persona.sexo == 'M'}"> checked </c:if> type="radio" name="sexo" value="M">M</label>
                            <label class="radio-inline"><input <c:if test="${persona.sexo == 'F'}"> checked </c:if> type="radio" name="sexo" value="F">F</label>
                    </div>
                    <div class="form-group">
                        <label>Contraseña actual*</label>
                        <input type="hidden" name="password" id="password" value="${persona.password}">
                        <input type="password" name="passwordAct" id="passwordAct" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <button id="aceptarEditarUsuario" class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Aceptar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="views/footer.jsp" %>
