<%@ page import="atividade.Veiculo,java.util.ArrayList"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% ArrayList<Veiculo> v = (ArrayList<Veiculo>) request.getAttribute("listarVeiculos"); %>
	<h2>Todos os veículos cadastrados</h2>
	<table>
		<tr>
			<th>Modelo</th>
			<th>Detalhes</th>
		</tr>
		<% for (int i =0; i<v.size(); i++) { %>
		<tr>
			<td> <%= v.get(i).getModelo() %> </td>
			<td> <a href="controllerVeiculo?id=<%= v.get(i).getId() %>">Ver detalhes</a> </td>
		</tr>
		<% } %>
	</table>

	
</body>
</html>