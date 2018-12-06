<%@ page import="atividade.Segurado, java.util.ArrayList" language="java" contentType="text/html; charset=ISO-8859-1"
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Clientes Cadastrados</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<% ArrayList<Segurado> s = (ArrayList<Segurado>) request.getAttribute("lista_segurados"); %>
<table>
	<tr>
		<th>Nome</th>
		<th>CPF</th>
		<th>Data de nascimento</th>
		<th>Telefone</th>
		<th>E-mail</th>
		<th></th>
	</tr>
	<% for (int i=0; i<s.size(); i++) { %>
	<tr>
		<td><%= s.get(i).getNome() %></td>
		<td><%= s.get(i).getCpf() %></td>
		<td><%= s.get(i).getData_de_nascimento() %></td>
		<td><%= s.get(i).getTelefone() %></td>
		<td><%= s.get(i).getEmail() %></td>
		<td><a href="segurados?id_segurado=<%= s.get(i).getId_segurado() %>">Selecionar</a></td>
	</tr>
	<% } %>
</table>
<a href="home">Voltar</a>
</body>
</html>