<%@ page import="atividade.Veiculo, atividade.Segurado, java.util.ArrayList" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulário Cotação</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="common.css" />
<style>
form { padding: 5px ; }
fieldset {
	display: block;
	padding: 5px;
	margin: 5px;
}
</style>

</head>
<body>
		<% Segurado segurado = (Segurado) request.getAttribute("segurado"); %>
		<% ArrayList<Veiculo> veiculos = (ArrayList<Veiculo>) request.getAttribute("veiculos"); %>
		<form method="POST" name="form1" action="cotacoes">
			<p>Olá, <b><%= segurado.getNome() %></b>!</p>
			<input type="hidden" name="seguradoId" value="<%=segurado.getId_segurado() %>" />
			<fieldset>
				<legend>Tipo de cobertura</legend>
				<select name="CoberturaTipo" disabled>
					<option value="0">Compreensivo</option>
				</select>
			</fieldset>
			<fieldset>
				<legend>Veículo segurado</legend>
				<select style="display: block;" name="veiculoId">
				<% for (int i =0; i<veiculos.size(); i++) { %>
					<option value="<%= veiculos.get(i).getId() %>"><%= veiculos.get(i).getModelo() %></option>
					<% }; %>
				</select>
				<label><input type="radio" name="valorVeiculo" value="0" />Valor de Mercado Referenciado: </label><input type="number" name="VMR" value="12000.00" step="0.01"/><br />
				<input type="radio" name="valorVeiculo" value="1" />
				<input type="number" name="valorDeterminado" placeholder="Valor Determinado" pattern="^[0-9]+(\.[0-9]{1,2})?$" />
			</fieldset>
			<fieldset>
				<legend>Danos materiais</legend>
				<input
					type="checkbox"
					name="danosMateriaisEnable"
					onchange="document.form1.danosMateriais.disabled = !document.form1.danosMateriaisEnable.checked" />
				<input type="number" name="danosMateriais" value="100000.00" step="0.01"  pattern="^[0-9]+(\.[0-9]{1,2})?$" disabled />
			</fieldset>
			<fieldset>
				<legend>Danos corporais</legend>
				<input
					type="checkbox"
					name="danosCorporaisEnable"
					onchange="document.form1.danosCorporais.disabled = !document.form1.danosCorporaisEnable.checked" />
				<input type="number" name="danosCorporais" value="100000.00" step="0.01"  pattern="^[0-9]+(\.[0-9]{1,2})?$" disabled />
			</fieldset>
			<fieldset>
				<legend>Franquia casco</legend>
				<select name="franquiaCasco">
					<option value="0">Majorada</option>
					<option value="1">Obrigatória</option>
					<option value="2">Reduzida</option>
				</select>
			</fieldset>
			<fieldset>
				<label><input type="checkbox" name="franquiaAcessorios" />Franquia acessórios</label>
			</fieldset>
			<input type="submit" />
			<fieldset id="premios" style="display:none;">
				<legend>Prêmios</legend>
				<p>Casco: PrêmioCasco</p>
				<p>Acessórios: PrêmioAcessórios</p>
				<p>Danos materiais: PrêmioDanosMateriais</p>
				<p>Danos corporais: PrêmioDanosCorporais</p>
				<p>IOF: ${IOF}</p>
				<p>Prêmio Líquido: PrêmioLíquido; Prêmio Total: PrêmioTotal</p>
				<button>Finalizar Cotação</button>
				<span style="float: right"><button>Gerar Apólice</button></span>
			</fieldset>
		</form><form action="segurados"><button>Cancelar</button></form>


</body>
</html>