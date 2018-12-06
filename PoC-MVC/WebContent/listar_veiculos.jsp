<%@ page import="atividade.Veiculo,java.util.ArrayList"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<style>
		table {
			width: 100%;
			border-spacing: 0;
		}
		table tbody tr {
			cursor: pointer;
			background-color: #CCC;
		}
		table tbody tr:hover {
			background-color: #EEE;
		}
		table td, table th {
			padding: 5px;
			text-align: center;
		}
		</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Veículos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<% ArrayList<Veiculo> v = (ArrayList<Veiculo>) request.getAttribute("listarVeiculos"); %>
	<h2>Todos os veículos cadastrados</h2>
	<table>
		<tr>
			<th>Marca</th>
			<th>Modelo</th>
			<th>Ano do Modelo</th>
			<th>Ano de Fabricação</th>
			<th>Detalhes</th>
		</tr>
		<% for (int i =0; i<v.size(); i++) { %>
		<tr>
			<td> <%= v.get(i).getMarca() %> </td>
			<td> <%= v.get(i).getModelo() %> </td>
			<td> <%= v.get(i).getAnoModelo() %> </td>
			<td> <%= v.get(i).getAnoFabricacao() %> </td>
			
			<td> <a href="veiculos?id=<%= v.get(i).getId() %>">Detalhes</a> </td>
		</tr>
		<% } %>
	</table>
	<a href="home">Voltar</a>
	
</body>
</html>