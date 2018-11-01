package atividade;

import java.util.Date;

public class Cotacao {
	private Date data_de_inicio;
	private Date data_de_fim;
	private float premio_liquido;
	private float premio_total;
	private float valor_veiculo;
	private float franquia;
	private int id;	
	
	public Cotacao(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Date getData_de_inicio() {
		return data_de_inicio;
	}
	public void setData_de_inicio(Date data_de_inicio) {
		this.data_de_inicio = data_de_inicio;
	}
	public Date getData_de_fim() {
		return data_de_fim;
	}
	public void setData_de_fim(Date data_de_fim) {
		this.data_de_fim = data_de_fim;
	}
	public float getPremio_liquido() {
		return premio_liquido;
	}
	public void setPremio_liquido(float premio_liquido) {
		this.premio_liquido = premio_liquido;
	}
	public float getPremio_total() {
		return premio_total;
	}
	public void setPremio_total(float premio_total) {
		this.premio_total = premio_total;
	}
	public float getValor_veiculo() {
		return valor_veiculo;
	}
	public void setValor_veiculo(float valor_veiculo) {
		this.valor_veiculo = valor_veiculo;
	}
	public float getFranquia() {
		return franquia;
	}
	public void setFranquia(float franquia) {
		this.franquia = franquia;
	}
}
