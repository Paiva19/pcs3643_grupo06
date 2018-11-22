<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,atividade.Apolice" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Lista de apólices</title>
		<link rel="stylesheet" href="common.css" />
</head>
<body>
	<% ArrayList<Apolice> c = (ArrayList<Apolice>) request.getAttribute("lista"); %>
	<ul>
		<% for (int i=0; i<c.size(); i++) { %>
			<li>Apolíce <%= c.get(i).getNumero_da_apolice() %>:
			<a href="apolices?&id=<%= c.get(i).getId() %>" title="Editar"><%= c.get(i).getStatus() %></a></li>
		<% } %>
	</ul>
</body>
</html>