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
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="home">SP Corretora de Seguros Ltda.</a>
	</nav><div class="container">
	<form method="POST">
		<fieldset>
			<legend>Datas</legend>
			<div class="input-group">
				<label>Data inicial: <input type="date" name="data_inicial" class="form-control" /></label>
				<label>Data final: <input type="date" name="data_final" class="form-control" /></label>
			</div>
		</fieldset>
		<button class="btn btn-primary">Gerar relatório</button>
	</form>
	<a href="home">Voltar</a></div>
</body>
</html>