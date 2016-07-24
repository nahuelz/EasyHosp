<%@include file="header.html" %>
<body>
	
 <div class="row">
     <div class="col-sm-8 col-md-4 col-md-offset-4 panel panel-default" style="margin-top: 5%;">
     <form class="form-signin" action="LoginServlet" method="POST">
       <h1 class="text-center login-title">Sign in to EasyHosp</h1></br>
       <label for="inputEmail" class="sr-only"">Email address</label>
       <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="Email address" required autofocus></br>
       <label for="inputPassword" class="sr-only">Password</label>
       <input type="password" name="inputPassword" id="inputPassword" class="form-control" placeholder="Password" required>
       <div class="checkbox">
         <label>
           <input type="checkbox" value="remember-me"> Remember me
         </label>
       </div>
       <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
     </form>
</div>
 
</body>
<%@include file="footer.html" %>