--<ScriptOptions statementTerminator=";"/>

CREATE TABLE Cotacoes (
	data_de_inicio DATETIME NOT NULL,
	data_de_fim DATETIME NOT NULL,
	premio_liquido FLOAT UNSIGNED NOT NULL,
	premio_total FLOAT UNSIGNED NOT NULL,
	valor_veiculo FLOAT UNSIGNED NOT NULL,
	franquia FLOAT UNSIGNED NOT NULL,
	id_cotacao INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (id_cotacao)
);

