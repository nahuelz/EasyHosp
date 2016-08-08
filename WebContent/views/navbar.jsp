<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">EasyHosp</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <% if (session.getAttribute("id") != null){ %>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mis solicitudes<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li>
							<a href="MisSolicitudesController?tipo=1">Solicitudes enviadas</a>
						</li>
						<li>
							<a href="MisSolicitudesController?tipo=2">Solicitudes recibidas</a>
						</li>
					</ul>
                </li>
				<li>
					<a href="FavoritoController">Favoritos</a>
                </li>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <%= session.getAttribute("nombre")  %>
							<b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="MiCuentaController">Mi cuenta</a>
							</li>
							<li>
								<a href="MiCasaController">Mi casa</a>
							</li>
							<li>
								<a href="LogoutController">Cerrar sesión</a>
							</li>
						</ul>
					</li>
				</ul>
                <%}else{ %>
                	<ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="registro.jsp">Registrarse</a>
                        </li>
                        <li>
                            <a href="login.jsp">Ingresar</a>
                        </li>
                    </ul>
                 <% } %>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
<br><br>
<%@ include file="../utils/Alert.jsp" %>