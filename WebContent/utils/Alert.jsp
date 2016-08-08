<c:if test= "${tipo == 1}">  	
	<div class="container">
		<div class="alert alert-block alert-success fade in">
			<i class="icon-ok green"></i>
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<c:out value= "${msj}"/>
		</div>
	</div>	
</c:if>

<c:if test= "${tipo == 2}">  	
	<div class="container">
		<div class="alert alert-block alert-danger fade in">
			<i class="icon-explamation-sign red"></i>
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<c:out value= "${msj}"/>
		</div>
	</div>	
</c:if>