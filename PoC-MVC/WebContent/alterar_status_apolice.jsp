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
		<link rel="stylesheet" href="common.css" />
</head>
<body>
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
</body>
</html>