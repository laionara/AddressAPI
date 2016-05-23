<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="model.Address" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%><html>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
<script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" charset="utf-8">
	
	function deleteById(id) {
		alert("cheguei");
		alert(id);
		$.ajax({
			type: "delete",
			 url: "http://localhost:8080/desafio-java/address/delete/" + id,
			 cache: false,    
			 success: function(response){
				 
			 },
			 error: function(){      
			  alert('Erro de requisição');
			 }
			});
	}

	function display(data){
		var name = JSON.stringify(data) ;
		alert(name)
	}
</script>
</head>
<body>
	<fieldset>
		<%= request.getAttribute("message") %>
		<table style="width: 900px">
		  <tr>
		    <td colspan="2"><h3>Endereço</h3></td>
		  </tr>
		  <tr>
		    <td colspan="4"><hr /></td>
		  </tr>
			<tr>
				<td><div align="center">CEP</div></td>
				<td><div align="center">Rua</div></td>
				<td><div align="center">Número</div></td>
				<td><div align="center">Bairro</div></td>
				<td><div align="center">Cidade</div></td>
				<td><div align="center">Estado</div></td>
				<td><div align="center">Complemento</div></td>
				<td><div align="center">Ação</div></td>
			</tr>
				<% List<Address> addressList = (ArrayList<Address>) request.getAttribute("addressList");
				   for(Address address: addressList){
				%>
					<tr>
						<td><div align="center"><%=address.getCep()%></div></td>
						<td><div align="center"><%=address.getRua()%></div></td>
						<td><div align="center"><%=address.getNumero()%></div></td>
						<td><div align="center"><%=address.getBairro()%></div></td>
						<td><div align="center"><%=address.getCidade()%></div></td>
						<td><div align="center"><%=address.getEstado()%></div></td>
						<td><div align="center"><%=address.getComplemento()%></div></td>
						<td><div align="center"><input type="button" value="Deletar" onclick ="deleteById(<%= address.getId()%>)"></div></td>
						
					</tr>
				<% } %>
		</table>
	</fieldset>		
	<br>
</body>
</html>