<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Location</title>
</head>
<body>
	<h1>Guru Register Form</h1>
	<form action="editloc" method="post">
		<table style="with: 50%">
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" value="${location.id}" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Code</td>
				<td><input type="text" name="code" value="${location.code}" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"  value="${location.name}"/></td>
			</tr>
		</table>
		Type: Urban<input type="radio" name="type" value="URBAN" ${location.type=='URBAN'?'checked':''} />
		      Rural<input type="radio"   name="type" value="RULAL" ${location.type=='RULAL'?'checked':''}  /> 
		     <br>
		     <input type="submit" value="save" />
		     
	</form>
</body>
</html>