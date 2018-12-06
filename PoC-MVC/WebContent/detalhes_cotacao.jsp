<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,atividade.Cotacao" %>
<!DOCTYPE html>
<html>
<% Cotacao c = (Cotacao) request.getAttribute("cotacao"); %>
	<head>
		<meta charset="UTF-8" />
		<title>Detalhes de Cotação #<%= c.getId() %></title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link rel="stylesheet" href="common.css" />
		<style>
		p { margin: 2px; }
		fieldset {
			margin: 5px;
		}
		</style>
	</head>
	<body>
		<fieldset>
			<legend>Cotação n. <%= c.getId() %></legend>
			<p>Data de início: <%= c.getData_de_inicio() %></p>
			<p>Data de fim: <%= c.getData_de_fim() %></p>
		</fieldset>
		<fieldset>
			<legend>Tipo de cobertura</legend>
			<p>Tipo: Compreensivo</p>
		</fieldset>
		<fieldset>
			<legend>Corretor</legend>
			<p>${Nome}</p>
			<p>${Telefone}</p>
			<p>${Email}</p>
		</fieldset>
		<fieldset>
			<legend>Cliente</legend>
			<p>${Nome}</p>
			<p>${CPF}</p>
			<p>${Sexo}</p>
			<p>${Nacionalidade}</p>
			<p>${DataDeNascimento}</p>
			<p>${Profissão}</p>
			<p>${Telefone}</p>
			<p>${Endereço}</p>
			<p>${Email}</p>
			<p>${CNH}</p>
		</fieldset>
		<fieldset>
			<legend>Seguradora</legend>
			<p>Seguro Auto Ldta.</p>
			<p>${Endereço}</p>
		</fieldset>
		<fieldset>
			<legend>Veículo segurado</legend>
			<p>${FIPE}</p>
			<p>${Marca}</p>
			<p>${Modelo}</p>
			<p>${Portas}</p>
			<p>${AnoFabricação}</p>
			<p>${AnoModelo}</p>
			<p>${NúmeroPassageiros}</p>
			<p>${Chassi}</p>
			<p>${Renavam}</p>
			<p>${NomeCondutor}</p>
			<p>${Classe}</p>
			<p><%= c.getValor_veiculo() %></p>
		</fieldset>
		<fieldset>
			<legend>Danos materiais</legend>
			<p>${DanosMateriais}</p>
		</fieldset>
		<fieldset>
			<legend>Danos corporais</legend>
			<p>${DanosCorporais}</p>
		</fieldset>
		<fieldset>
			<legend>Franquia casco</legend>
			<p>${FranquiaCasco}</p>
		</fieldset>
		<fieldset>
			<legend>Franquia acessórios</legend>
			<p>${FranquiaAcessórios}</p>
		</fieldset>
		<fieldset>
			<legend>Prêmios</legend>
			<p>Casco: <%= c.getFranquia() %></p>
			<p>Acessórios: ${PrêmioAcessórios}</p>
			<p>Danos materiais: ${PrêmioDanosMateriais}</p>
			<p>Danos corporais: ${PrêmioDanosCorporais}</p>
			<p>IOF: ${IOF}</p>
			<p>Prêmio Líquido: <%= c.getPremio_liquido() %>; Prêmio Total: <%= c.getPremio_total() %></p>
		</fieldset>
		<form method="GET" style="display:inline;">
			<button>Confirmar venda</button>
			<input type="hidden" name="vender" value="1" />
			<input type="hidden" name="id" value="<%= c.getId() %>" />
		</form>
		<span style="float: right"><form action="cotacoes"><button>Cancelar</button></form></span>
		
	</body>
</html>