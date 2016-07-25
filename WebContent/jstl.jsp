<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>JSTL</title>
	</head>
	
	<body>
		<H1>CONEXION</H1>
		<sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/prueba" user="root" password="" var="con" />
		
		<sql:query dataSource="${con}" var="resultados">
			select id,nombre from persona;
		</sql:query>
		
		<c:forEach var="filas" items="${resultados.rows}">
			<c:out value="${filas.nombre}" /> <br>
		</c:forEach>
	</body>
</html>