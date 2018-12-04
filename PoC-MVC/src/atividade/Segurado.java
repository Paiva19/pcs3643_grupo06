package atividade;

import java.util.Date;

public class Segurado {
	private int id_segurado;
	private String nome;
	private String cpf;
	private String sexo;
	private String nacionalidade;
	private Date data_de_nascimento;
	private String profissao;
	private String telefone;
	private String endereco;
	private String email;
	private String cnh;
	
	public Segurado( int id_segurado, String nome, String cpf, String sexo, 
					String nacionalidade, Date data_de_nascimento, String profissao,
					String telefone, String endereco, String email, String cnh){
		
		this.id_segurado = id_segurado;
		this.nome = nome;
		this.setCpf(cpf);
		this.setSexo(sexo);
		this.setNacionalidade(nacionalidade);
		this.setData_de_nascimento(data_de_nascimento);
		this.setProfissao(profissao);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.setCnh(cnh);
		
	}

	public int getId_segurado() {
		return this.id_segurado;
	}

	public void setId_segurado(int id) {
		this.id_segurado = id;
	}
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidade() {
		return this.nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Date getData_de_nascimento() {
		return this.data_de_nascimento;
	}

	public void setData_de_nascimento(Date data_de_nascimento) {
		this.data_de_nascimento = data_de_nascimento;
	}

	public String getProfissao() {
		return this.profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnh() {
		return this.cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
}