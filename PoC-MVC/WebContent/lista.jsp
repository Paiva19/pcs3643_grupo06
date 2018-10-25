<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,atividade.Cotacao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Lista de cotações</title>
</head>
<body>
<% ArrayList<Cotacao> c = (ArrayList<Cotacao>) request.getAttribute("lista"); %>
<table>
	<tr>
		<th>Data de início</th>
		<th>Data de fim</th>
		<th>Prêmio total</th>
		<th>Prêmio líquido</th>
		<th>Franquia</th>
		<th>Valor veículo</th>
		<th>Ver detalhes</th>
	</tr>
	<% for (int i=0; i<c.size(); i++) { %>
	<tr>
		<td><%= c.get(i).getData_de_inicio() %></td>
		<td><%= c.get(i).getData_de_fim() %></td>
		<td><%= c.get(i).getPremio_total() %></td>
		<td><%= c.get(i).getPremio_liquido() %></td>
		<td><%= c.get(i).getFranquia() %></td>
		<td><%= c.get(i).getValor_veiculo() %></td>
		<td><a href="Controller?id=<%= c.get(i).getId() %>">Detalhes</a></td>
	</tr>
	<% } %>
</table>
</body>
</html>