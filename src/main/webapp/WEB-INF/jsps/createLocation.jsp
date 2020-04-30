<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Location</title>
</head>
<body>
	<h1>Guru Register Form</h1>
	<form action="saveloc" method="post">
		<table style="with: 50%">
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>Code</td>
				<td><input type="text" name="code" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
		</table>
		Type: Urban<input type="radio" name="type" value="URBAN" />
		      Rural<input type="radio"   name="type" value="RULAL" /> 
		     <br>
		     <input type="submit" value="save" />
		     
	</form>
	${msg}
	<a href="displayLocations">VIEW ALL</a>
</body>
</html>