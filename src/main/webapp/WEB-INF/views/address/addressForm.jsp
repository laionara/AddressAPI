<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
<script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" charset="utf-8">
	function findByCep() {
		alert("cheguei");
		var cep = $("#cep").val();
		$.ajax({
			 type: "get",
			 url: "http://localhost:8080/desafio-java/address/" +cep,
			 cache: false,    
			 success: function(response){
				 alert(response);
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
	
	<form:form method="post" modelAttribute="address" commandName="address" action="/desafio-java/address/save">
		<fieldset>
		<% if(request.getAttribute("message") != null){%>
			<h2><font color="red"><center><%= request.getAttribute("message") %></center></font></h2>
		<%} %>
		
		<table>
		  <tr>
		    <td colspan="2"><h3>Incluir Endereço</h3></td>
		  </tr>
		  <tr>
		    <td colspan="2"><hr /></td>
		  </tr>
		  <tr>
		    <td>CEP:</td>
		    <td><input name="cep" id="cep" type="text" onblur="findByCep()"/></td>
		  </tr>
		  <tr>
		    <td>Cidade:</td>
		    <td><input name="cidade" id="cidade"  type="text" /></td>
		    <td><form:errors path="cidade"/></td>
		  </tr>
		  <tr>
		  <tr>
		    <td>Estado:</td>
		    <td><input name="estado" id="estado" type="text" /></td>
		  </tr>
		  <tr>
		    <td>Bairro:</td>
		    <td><input name="bairro" id="bairro" type="text" /></td>
		  </tr>
		  <tr>
		    <td>Rua:</td>
		    <td><input name="rua" id="rua" type="text" /></td>
		    <td><form:errors path="rua"/></td>
		  </tr>
		  <tr>
		    <td>Número:</td>
		    <td><input name="numero" id="numero" type="text" /></td>
		  </tr>
		   <tr>
		    <td>Complemento:</td>
		    <td><input name="complemento" id="complemento" type="text" /></td>
		  </tr>
		  <tr>
		    <td colspan="2"><input value="Enviar" type="submit" ></td>
		  </tr>
		</table>
		</fieldset>
	</form:form>
</body>
</html>