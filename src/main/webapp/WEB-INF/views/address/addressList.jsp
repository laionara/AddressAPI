<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
</head>
<body>
	<form:form method="get" modelAttribute="message" commandName="message" action="/desafio-java/address/form">
	<fieldset>
		{message}
		<table>
			<tr>
		    <td colspan="2"><h3>Endereço</h3></td>
		  </tr>
		  <tr>
		    <td colspan="2"><hr /></td>
		  </tr>
			<tr>
				<td>CEP</td>
				<td>Rua</td>
				<td>Número</td>
				<td>Bairro</td>
				<td>Cidade</td>
				<td>Estado</td>
				<td>Complemento</td>
			</tr>
			<c:forEach var="address" items="${addressList}">
				<tr>
					<td>${address.cep}</td>
					<td>${address.rua}</td>
					<td>${address.numero}</td>
					<td>${address.bairro}</td>
					<td>${address.cidade}</td>
					<td>${address.estado}</td>
					<td>${address.complemento}</td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>		
	</form:form>
	<br>
	<a href="/form">Incluir</a>
</body>
</html>