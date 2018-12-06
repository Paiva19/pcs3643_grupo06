<%@ page import="atividade.Veiculo"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalhes de veículo</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<% Veiculo v = (Veiculo) request.getAttribute("detalheVeiculo"); %>
	<h2>Detalhes do veículo: <%= v.getModelo() %></h2>
	<table>
		<tr>
			<th>Id</th>
			<th>Marca</th>
			<th>Modelo</th>
			<th>Ano de Fabricação</th>
			<th>Ano do Modelo</th>
			<th>Núm. Portas</th>
			<th>Classe</th>
		</tr>
		<tr>
			<td> <%= v.getId() %> </td>
			<td> <%= v.getMarca() %> </td>
			<td> <%= v.getModelo() %> </td>
			<td> <%= v.getAnoFabricacao() %> </td>
			<td> <%= v.getAnoModelo() %> </td>
			<td> <%= v.getPortas() %> </td>
			<td> <%= v.getClasse() %> </td>
		</tr>
	</table>
	<a href="veiculos">Voltar</a>
	
</body>
</html>