<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,atividade.Cotacao,atividade.Veiculo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Formulário Cotação</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link rel="stylesheet" href="common.css" />
		<style>
		table {
			width: 100%;
			border-spacing: 0;
		}
		table tbody tr {
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
	</head>
	<body>
		<% ArrayList<Cotacao> c = (ArrayList<Cotacao>) request.getAttribute("lista"); %>
		<table>
			<thead>
				<tr>
					<th>Modelo do Veículo</th>
					<th>Valor do Veículo</th>
					<th>Danos materiais</th>
					<th>Danos corporais</th>
					<th>Franquia casco</th>
					<th>Franquia acessórios</th>
					<th>Prêmio total</th>
				</tr>
			</thead>
			<tbody>
				<% for (int i=0; i<c.size(); i++) { %>
					<tr>
						<% Veiculo v = c.get(i).getVeiculo(); %>
						<td><%= v.getMarca() %> <%= v.getModelo() %> <%= v.getAnoModelo() %></td>
						<td><%= c.get(i).getValor_veiculo() %></td>
						<td><%= c.get(i).getDanos_materiais() %></td>
						<td><%= c.get(i).getDanos_corporais() %></td>
						<td><%= c.get(i).getFranquia() %></td>
						<td><%= c.get(i).getFranquiaAcessorios() %></td>
						<td><%= c.get(i).getPremio_total() %></td>
						<td><a href="cotacoes?id=<%= c.get(i).getId() %>">Detalhes</a></td>
					</tr>
				<% } %>
			</tbody>
		</table>
		<a href="home">Voltar</a>
	</body>
</html>