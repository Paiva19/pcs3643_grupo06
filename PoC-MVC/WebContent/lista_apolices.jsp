<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,atividade.Apolice" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Lista de apólices</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link rel="stylesheet" href="common.css" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="home">SP Corretora de Seguros Ltda.</a>
	</nav><div class="container">
	<% ArrayList<Apolice> c = (ArrayList<Apolice>) request.getAttribute("lista"); %>
	<ul class="list-group">
		<% for (int i=0; i<c.size(); i++) { %>
			<li class="list-group-item">Apolíce <%= c.get(i).getNumero_da_apolice() %>:
			<a href="apolices?&id=<%= c.get(i).getId() %>" title="Editar"><%= c.get(i).getStatus() %></a></li>
		<% } %>
	</ul>
	<a href="home">Voltar</a></div>
</body>
</html>