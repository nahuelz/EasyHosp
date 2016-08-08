<%@include file="views/base.jsp" %>
<body>
	<div class='container'>
		<section id="wizard">
 			<div class="page-header">
          		<h1>Sing up</h1>
        	</div>
			
			<div id="rootwizard">
				<div class="navbar">
					<div class="navbar-inner">
		    			<div class="container">
							<ul>
		  						<li><a href="#tab1" data-toggle="tab">Tus datos</a></li>
								<li><a href="#tab2" data-toggle="tab">Datos de tu hogar</a></li>
							</ul>
		 				</div>
		  			</div>
				</div>
			
				<div class="tab-content">
			    	<div class="tab-pane" id="tab1">
			    		<div class="row">
	     					<div class="col-sm-8 col-md-4 col-md-offset-4 panel panel-default" style="margin-top: 5%;">
			    				<form class="form-signin" action="RegistroController" method="POST">
	             					<h3 class="text-center login-title">Tus datos</h3>
	             					<div class="form-group">
						                <label>Nommbre*</label>
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
						                 <label>Contraseña*</label>
						                 <input type="password" name="password" id="password" class="form-control" required autofocus>
						             </div>
						             <div class="form-group">
						                 <label>Repetir contraseña*</label>
						                 <input type="password" name="passwordRep" class="form-control" required autofocus>
						             </div>
						             
	             					<ul class="pager wizard">
										<li class="previous"><a href="#">Previous</a></li>
										<li class="next"><a href="#">Next</a></li>
									</ul>
		         				</div>
		       				</div>
		   				</div>
					<div class="tab-pane" id="tab2">
		     			<div class="row">
		  					<div class="col-sm-8 col-md-4 col-md-offset-4 panel panel-default" style="margin-top: 5%;">
		  						<div class="form-signin">
		             				<h3 class="text-center login-title">Datos de tu hogar</h3>
		             				<div class="form-group">
		                 				<label>Quieries hacer publico tu hogar?</label>
		                 				<p>*Así otras persona podran solicitar hospedarse<p>
		                 				<p>*Luego podras modificar esta opcion</p>
		                 				<select name="disponible" class="form-control">
											<option value="1">Si</option>
											<option value="0">No</option>			  
										</select>
		             				</div>
		             				
		             				<div class="form-group">
										<label>Provincia*</label> </br>
										<select name="provincia" class="form-control">
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
		
									<div class="form-group">
										<label>Ciudad*</label>
						            	<input type="text" name="ciudad" class="form-control" required autofocus>
						            </div>
						            
		             				<div class="form-group">
		                 				<label>Lugar disponible</label>
		                 				<select name="lugar" class="form-control">
											<option value="1">1</option>
											<option value="2">2</option>			  
										</select>
		             				</div>
		             				<div class="form-group">
			               				<label>Hay chicos?</label>
			               				<select name="chicos" class="form-control">
											<option value="Si">Si</option>
											<option value="No">No</option>			  
										</select>
		           					</div>
		            				<div class="form-group">
		                 				<label>Tenes mascota?</label>
		                 				<select name="mascota" class="form-control">
											<option value="Si">Si</option>
											<option value="No">No</option>			  
										</select>
		             				</div>
			
									<div class="form-group">
								    	<label>Se puede fumar en la casa?</label>
								        <select name="fumar" class="form-control">
											<option value="Si">Si</option>
											<option value="No">No</option>			  
										</select>
									</div>
			
			
									<div class="form-group">
		                 				<label>La habitacion es compartida?</label>
		                 				<select name="compartida" class="form-control">
											<option value="Si">Si</option>
											<option value="No">No</option>			  
										</select>
		             				</div>
		             				
		             				<ul class="pager wizard">
										<li class="previous"><a href="#">Previous</a></li>
			  							<li class="next"><a href="#">Next</a></li>
									</ul>
			                		
			                		<div class="form-group">
		               					<button  class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Aceptar</button>
		          					</div>	               	           
	           					</form>
	          				</div>
	          			</div>
        			</div>
    			</div>
    		</div>
    	</section>
	</div>
</body>
<%@include file="views/footer.jsp" %>