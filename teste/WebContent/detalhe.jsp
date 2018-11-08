<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,atividade.Cotacao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Detalhes de cotação</title>
</head>
<body>
<% Cotacao c = (Cotacao) request.getAttribute("cotacao"); %>
<p>Cotação <%= c.getId() %>:</p>
<ul>
	<li>Data de início: <%= c.getData_de_inicio() %></li>
	<li>Data de fim: <%= c.getData_de_fim() %></li>
	<li>Prêmio total: <%= c.getPremio_total() %></li>
	<li>Prêmio líquido: <%= c.getPremio_liquido() %></li>
	<li>Franquia: <%= c.getFranquia() %></li>
	<li>Valor do veículo: <%= c.getValor_veiculo() %></li>
</ul>
</body>
</html>