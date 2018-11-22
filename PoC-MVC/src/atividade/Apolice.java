package atividade;

import java.sql.Date;

public class Apolice {
	private int numero_da_apolice;
	private Date data_de_inicio;
	private Date data_de_fim;
	private String status;
	private int id_apolice;
	
	public Apolice(int id_apolice, int numero_da_apolice, Date data_de_inicio, Date data_de_fim, String status){
		this.setNumero_da_apolice(numero_da_apolice);
		this.id_apolice = id_apolice;
		this.setData_de_fim(data_de_fim);
		this.setData_de_inicio(data_de_inicio);
		this.status = status;
	}

	public Date getData_de_inicio() {
		return this.data_de_inicio;
	}

	public void setData_de_inicio(Date data_de_inicio) {
		this.data_de_inicio = data_de_inicio;
	}

	public int getNumero_da_apolice() {
		return this.numero_da_apolice;
	}

	public void setNumero_da_apolice(int numero_da_apolice) {
		this.numero_da_apolice = numero_da_apolice;
	}

	public Date getData_de_fim() {
		return this.data_de_fim;
	}

	public void setData_de_fim(Date data_de_fim) {
		this.data_de_fim = data_de_fim;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return this.id_apolice;
	}
}
