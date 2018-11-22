<%@ page import="atividade.Veiculo"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Veiculo v = (Veiculo) request.getAttribute("detalheVeiculo"); %>
	<h2>Detalhes do veículo: <%= v.getModelo() %></h2>
	<table>
		<tr>
			<th>Id</th>
			<th>Modelo</th>
		</tr>
		
		<tr>
			<td> <%= v.getId() %> </td>
			<td> <%= v.getModelo() %> </td>
		</tr>
	</table>

	
</body>
</html>