package atividade;

import java.util.Date;

public class Segurado {
	private int id_segurado;
	private String nome;
	private String cpf;
	private Date data_de_nascimento;
	private String telefone;
	private String email;
	private String cnh;
	
	public Segurado(int id_segurado,String nome, String cpf, Date data_de_nascimento,
					String telefone, String email, String cnh){
			this.id_segurado = id_segurado;
			this.nome = nome;
			this.cpf = cpf;
			this.data_de_nascimento = data_de_nascimento;
			this.telefone = telefone;
			this.email = email;
			this.cnh = cnh;
	}

	public int getId_segurado() {
		return id_segurado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_de_nascimento() {
		return data_de_nascimento;
	}

	public void setData_de_nascimento(Date data_de_nascimento) {
		this.data_de_nascimento = data_de_nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

}
