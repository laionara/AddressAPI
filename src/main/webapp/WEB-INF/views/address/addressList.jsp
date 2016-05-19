<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title>SimpledDev - Spring MVC</title>
</head>
<body>
	<h3>Address</h3>
	<table>
		<tr>
			<td>Id</td>
			<td>Rua</td>
			<td>Bairro</td>
			<td>Estado</td>
			<td>CEP</td>
		</tr>
		<tr>
			<td>${address.id}</td>
			<td>${address.rua}</td>
			<td>${address.bairro}</td>
			<td>${address.estado}</td>
			<td>${address.cep}</td>
		</tr>
	</table>
	<br>
</body>
</html>