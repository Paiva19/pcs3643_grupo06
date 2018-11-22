<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,atividade.Apolice" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<% Apolice ap = (Apolice) request.getAttribute("apolice"); %>
		<title>Alterar status de apólice <%= ap.getNumero_da_apolice() %></title>
		<link rel="stylesheet" href="common.css" />
</head>
<body>
	<form method="POST">
		<label>Status: <select name="status">
			<option value="ativa">Ativa</option>
			<option value="encerrada">Encerrada</option>
			<option value="cancelada">Cancelada</option>
		</select></label>
		<input type="hidden" name="id" value="<%= ap.getId() %>" />
		<input type="submit" />
	</form>
	<a href="apolices">Voltar</a>
</body>
</html>