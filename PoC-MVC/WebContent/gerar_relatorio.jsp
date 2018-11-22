<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>Gerar relatório</title>
</head>
<body>
	<form method="POST">
		<fieldset>
			<legend>Datas</legend>
			<label>Data inicial: <input type="date" name="data_inicial" /></label>
			<label>Data final: <input type="date" name="data_final" /></label>
		</fieldset>
		<button>Gerar relatório</button>
	</form>
	<a href="home">Voltar</a>
</body>
</html>