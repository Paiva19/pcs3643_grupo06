<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,atividade.Apolice,java.sql.Date" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<% Apolice ap = (Apolice) request.getAttribute("apolice"); %>
		<% Date agora = (Date) request.getAttribute("now"); %>
		<title>Alterar status de apólice <%= ap.getNumero_da_apolice() %></title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link rel="stylesheet" href="common.css" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="home">SP Corretora de Seguros Ltda.</a>
	</nav>
	<div class="container">
	<p>Essa apólice encerra <%= ap.getData_de_fim() %></p>
	<form method="POST">
		<label>Status: <select name="status">
			<% if (ap.getData_de_fim().compareTo(agora) > 0) { %>
				<option value="ativa">Ativa</option>
				<option value="cancelada">Cancelada</option>
			<% } else { %>
				<option value="encerrada">Encerrada</option>
			<% } %>
		</select></label>
		<input type="hidden" name="id" value="<%= ap.getId() %>" />
		<input type="submit" />
	</form>
	<a href="apolices">Voltar</a>
	</div>
</body>
</html>