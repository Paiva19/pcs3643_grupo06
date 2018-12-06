<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>Gerar relatório</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
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