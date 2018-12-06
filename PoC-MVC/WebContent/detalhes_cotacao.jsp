<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,atividade.Cotacao,atividade.Segurado,atividade.Veiculo" %>
<!DOCTYPE html>
<html>
<% Cotacao c = (Cotacao) request.getAttribute("cotacao"); %>
<% Segurado s = (Segurado) request.getAttribute("segurado"); %>
<% Veiculo v = (Veiculo) request.getAttribute("veiculo"); %>
	<head>
		<meta charset="UTF-8" />
		<title>Detalhes de Cotação #<%= c.getId() %></title>
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
			<p><%= s.getNome() %></p>
			<p><%= s.getCpf() %></p>
			<p><%= s.getSexo() %></p>
			<p><%= s.getNacionalidade() %></p>
			<p><%= s.getData_de_nascimento() %></p>
			<p><%= s.getProfissao() %></p>
			<p><%= s.getTelefone() %></p>
			<p><%= s.getEndereco() %></p>
			<p><%= s.getEmail() %></p>
			<p><%= s.getCnh() %></p>
		</fieldset>
		<fieldset>
			<legend>Seguradora</legend>
			<p>Seguro Auto Ldta.</p>
			<p>${Endereço}</p>
		</fieldset>
		<fieldset>
			<legend>Veículo segurado</legend>
			<p><%= v.getFipe() %></p>
			<p><%= v.getMarca() %></p>
			<p><%= v.getModelo() %></p>
			<p><%= v.getPortas() %> portas</p>
			<p>Fabricação <%= v.getAnoFabricacao() %></p>
			<p>Modelo <%= v.getAnoModelo() %></p>
			<p><%= v.getnPassageiros() %> passageiros</p>
			<p><%= v.getChassi() %></p>
			<p><%= v.getRenavam() %></p>
			<p><%= v.getClasse() %></p>
			<p><%= c.getValor_veiculo() %></p>
		</fieldset>
		<fieldset>
			<legend>Danos materiais</legend>
			<p><%= c.getDanos_materiais() %></p>
		</fieldset>
		<fieldset>
			<legend>Danos corporais</legend>
			<p><%= c.getDanos_corporais() %></p>
		</fieldset>
		<fieldset>
			<legend>Franquia casco</legend>
			<p><%= c.getFranquia() %></p>
		</fieldset>
		<fieldset>
			<legend>Franquia acessórios</legend>
			<p><%= c.getFranquiaAcessorios() %></p>
		</fieldset>
		<fieldset>
			<legend>Prêmios</legend>
			<p>Casco: <%= c.getPremio_casco() %></p>
			<p>Acessórios: <%= c.getPremio_acessorios() %></p>
			<p>Danos materiais: <%= c.getPremio_danos_materiais() %></p>
			<p>Danos corporais: <%= c.getPremio_danos_corporais() %></p>
			<p>IOF: <%= c.getIof() %></p>
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