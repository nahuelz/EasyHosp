<a>
<div class="text-vertical-center" id="barraBusqueda">
	<nav class="navbar">
		<form class="navbar-form navbar-left" method="POST" id="searchForm" action="HospedajeController" role="search" style="margin-left: -16px">
			<div class="form-group">
				<select name="provincia" class="form-control">
					<option value="todos">A que provincia queres ir? </option>
					<option value="Buenos Aires">Buenos Aires</option>
					<option value="Catamarca">Catamarca</option>
					<option value="Chaco">Chaco</option>
					<option value="Chubut">Chubut</option>					  
					<option value="Cordoba">Córdoba</option>
					<option value="Corrientes">Corrientes</option>
					<option value="Entre Ríos">Entre Ríos</option>
					<option value="Formosa">Formosa</option>
					<option value="Jujuy">Jujuy</option>
					<option value="La Pampa">La Pampa</option>
					<option value="La Rioja">La Rioja</option>
					<option value="Mendoza">Mendoza</option>
					<option value="Misiones">Misiones</option>
					<option value="Neuquen">Neuquén</option>
					<option value="Rio Negro">Río Negro</option>
					<option value="Salta">Salta</option>
					<option value="San Juan">San Juan</option>
					<option value="San Luis">San Luis</option>
					<option value="Santa Cruz">Santa Cruz</option>
					<option value="Santa Fe">Santa Fe</option>
					<option value="Santiago del Estero">Santiago del Estero</option>
					<option value="Tierra del Fuego">Tierra del Fuego</option>
					<option value="Tucuman">Tucumán</option>			  
				</select>
			</div>
			<button name="boton" value="porProvincia" id="porProvincia" class="btn btn-info">Buscar</button>
			<button name="boton" value="todos" id="todos" class="btn btn-warning">Ver todos!</button>
			<legend class="oblique searchHosp" >Busca hospedaje en la provincia que queres conocer!</legend>
		</form>
	</nav>	    
</div>	 
</a>  		
	