<%@include file="header.html" %>
<body>
	<div class="row">
        <div class="col-sm-8 col-md-4 col-md-offset-4 panel panel-default" style="margin-top: 5%;">
            <form class="form-signin" action="RegistroController" method="POST">
                <h3 class="text-center login-title">Sign up</h3>
                <div class="form-group">
                    <label>Nombre*</label>
                    <input type="text" name="nombre" class="form-control" required autofocus>
                </div>
                <div class="form-group">
                    <label>Apellido*</label>
                    <input type="text" name="apellido" class="form-control" required autofocus>
                </div>
                <div class="form-group">
                    <label>Email*</label>
                    <input type="email" name="email" class="form-control" required autofocus>
                </div>
				
				<div class="form-group">
					<label>Provincia*</label> </br>
					<select name="provincia" class="form-control">
						<option value="Buenos Aires">Buenos Aires</option>
						<option value="Catamarca">Catamarca</option>
						<option value="Chaco">Chaco</option>
						<option value="Chubut">Chubut</option>					  
						<option value="Cordoba">C�rdoba</option>
						<option value="Corrientes">Corrientes</option>
						<option value="Entre R�os">Entre R�os</option>
						<option value="Formosa">Formosa</option>
						<option value="Jujuy">Jujuy</option>
						<option value="La Pampa">La Pampa</option>
						<option value="La Rioja">La Rioja</option>
						<option value="Mendoza">Mendoza</option>
						<option value="Misiones">Misiones</option>
						<option value="Neuquen">Neuqu�n</option>
						<option value="Rio Negro">R�o Negro</option>
						<option value="Salta">Salta</option>
						<option value="San Juan">San Juan</option>
						<option value="San Luis">San Luis</option>
						<option value="Santa Cruz">Santa Cruz</option>
						<option value="Santa Fe">Santa Fe</option>
						<option value="Santiago del Estero">Santiago del Estero</option>
						<option value="Tierra del Fuego">Tierra del Fuego</option>
						<option value="Tucuman">Tucum�n</option>			  
					</select>
				</div>
				
				<div class="form-group">
                    <label>Coudad*</label>
                    <input type="text" name="ciudad" class="form-control" required autofocus>
                </div>
                	                
                <div class="form-group">
                    <label>Tel�fono</label>
                    <input type="tel" name="telefono" class="form-control" required autofocus>
                </div>
                <div class="form-group">
                    <label>Contrase�a*</label>
                    <input type="password" name="password" id="password" class="form-control" required autofocus>
                </div>
                <div class="form-group">
                    <label>Repetir contrase�a*</label>
                    <input type="password" name="passwordRep" class="form-control" required autofocus>
                </div>
                <div class="form-group">
                    <button id="aceptarNuevoRegistro" class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Aceptar</button>
                </div>
            </form>
        </div>
    </div>
</body>
<%@include file="footer.html" %>