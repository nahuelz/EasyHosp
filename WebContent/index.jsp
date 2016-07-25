<%@include file="header.html" %>
<header id="top" class="header">
    <div class="text-vertical-center">
        <h1 class="text-center login-title">Easy-Hosp</h1>
        <h3>Buscas aventuras o queres conocer nuevas personas?</h3>
        <br>
   		<a>
        <div class="text-vertical-center" id="barraBusqueda">
      <nav class="navbar">
          <form class="navbar-form navbar-left" method="POST" id="searchForm" action="hospedajes.jsp" role="search" style="margin-left: -16px">
              <div class="form-group">
                  <input type="text" class="form-control" name="datefilter" id="fechas" value="" placeholder="A donde queres ir?" />
                  <input type="hidden" name="desde" id="desde" value="">
                  <input type="hidden" name="hasta" id="hasta" value="">
              </div>
              <button id="btnSearchHosp" class="btn btn-info searchOrder">Buscar</button>
          	<legend class="oblique searchHosp" >Busca hospedaje en la ciudad que queres conocer!</legend>
          </form>
      </nav>	    
		</div>	   		
		</a>
    </div>
</header>
<h1>EJB</h1>
<jsp:useBean id="per" scope="request" class="easyHosp.modelo.Persona" />
Email: <jsp:getProperty name="per" property="email"/>
<%@include file="footer.html" %>