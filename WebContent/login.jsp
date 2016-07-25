<%@include file="header.html" %>
<body>
	
<div class="row">
	<div class="col-sm-8 col-md-4 col-md-offset-4 panel panel-default" style="margin-top: 5%;">
		<form class="form-signin" action="LoginController" method="POST">
			<h1 class="text-center login-title">Sign in to EasyHosp</h1></br>
			<label for="email" class="sr-only">Email address</label>
				<input type="email" id="email" name="email" class="form-control" placeholder="Email address" required autofocus>
				</br>
			<label for="password" class="sr-only">Password</label>
				<input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
			<div class="checkbox">
				<label>
					<input type="checkbox" value="remember-me"> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</div>
</div>
 
</body>

<jsp:useBean id="per" scope="request" class="easyHosp.modelo.Persona" />
Email: <jsp:getProperty name="per" property="email"/>
Es Admin: <jsp:getProperty name="per" property="isAdmin" />



<%@include file="footer.html" %>