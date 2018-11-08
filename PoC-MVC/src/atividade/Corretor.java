package atividade;

public class Corretor {
	private int id_corretor;
	private String nome;
	private String telefone;
	private String email;
	
	
	public Corretor(int id_corretor, String nome, String telefone, String email){
		this.id_corretor = id_corretor;
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEmail(email);
	}


	public int getId_corretor() {
		return id_corretor;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
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

	

}
