<%@include file="views/base.jsp" %>
<br>
	<div class="container">
    <div class="main">
        <div class="col-lg-12">
            <h1 class="page-header">
                Mi Casa
            </h1>
        </div>
        <div class="row">
            <div class="col-sm-8 col-md-4 col-md-offset-4 panel panel-default" style="margin-top: 5%;">
                <form action="EditarCasaController" method="POST">
                    <h1 class="text-center login-title">Mi Casa</h1>
                    <c:if test="${persona.disponible == '1'}">
                   		<h1 class="text-center login-title" style="color: green;">Disponible</h1>
                   	</c:if>
                   	<c:if test="${persona.disponible == '0'}">
                   		<h1 class="text-center login-title" style="color: red;">No disponible</h1>
                   	</c:if>
                    <input type="hidden" name="id" value="${persona.casa.id}">
                    <div class="form-group">
           				<label>Lugar disponible</label>
           				<select name="lugar" class="form-control">
							<option <c:if test="${persona.casa.lugar == '1'}"> selected </c:if> value="1">1</option>
							<option <c:if test="${persona.casa.lugar == '2'}"> selected </c:if> value="2">2</option>
							<option <c:if test="${persona.casa.lugar == '3'}"> selected </c:if> value="3">3</option>
							<option <c:if test="${persona.casa.lugar == '4'}"> selected </c:if> value="4">4</option>
							<option <c:if test="${persona.casa.lugar == '5'}"> selected </c:if> value="5">5</option>			  
						</select>
					</div>
				    <div class="form-group">
				    	<label>Hay chicos?</label>
				    	<select name="chicos" class="form-control">
							<option <c:if test="${persona.casa.chicos == 'Si'}"> selected </c:if> value="Si">Si</option>
							<option <c:if test="${persona.casa.chicos == 'No'}"> selected </c:if> value="No">No</option>			  
						</select>
				    </div>
			  		<div class="form-group">
			    		<label>Tenes mascota?</label>
			       		<select name="mascota" class="form-control">
							<option <c:if test="${persona.casa.mascota == 'Si'}"> selected </c:if> value="Si">Si</option>
							<option <c:if test="${persona.casa.mascota == 'No'}"> selected </c:if> value="No">No</option>			  
						</select>
			     	</div>			
					<div class="form-group">
				    	<label>Se puede fumar en la casa?</label>
				        <select name="fumar" class="form-control">
							<option <c:if test="${persona.casa.permitidoFumar == 'Si'}"> selected </c:if> value="Si">Si</option>
							<option <c:if test="${persona.casa.permitidoFumar == 'No'}"> selected </c:if>  value="No">No</option>			  
						</select>
					</div>
					<div class="form-group">
           				<label>La habitacion es compartida?</label>
           				<select name="compartida" class="form-control">
							<option <c:if test="${persona.casa.habitacionCompartida == 'Si'}"> selected </c:if> value="Si">Si</option>
							<option <c:if test="${persona.casa.habitacionCompartida == 'No'}"> selected </c:if> value="No">No</option>			  
						</select>
       				</div>

                    <div class="form-group" id="passwordActInput">
                        <label>Contraseña actual*</label>
                        <input type="hidden" name="passwordAct" id="passwordAct" value="${persona.password }">
                        <input type="password" name="password" id="password" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Aceptar</button>
                    </div>
                    <c:if test="${persona.disponible == '0'}">
                   		<div class="form-group">
                    		<a class="btn btn-lg btn-success btn-block btn-signin" href="SetearDisponibilidad?setDisp=1">Habilitar</a> 
                    	</div>
                   	</c:if>
                   	<c:if test="${persona.disponible == '1'}">
                   		<div class="form-group">
                    		<a class="btn btn-lg btn-danger btn-block btn-signin" href="SetearDisponibilidad?setDisp=0">Deshablitiar</a> 
                   		</div>
                   	</c:if>
                    
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="views/footer.jsp" %>