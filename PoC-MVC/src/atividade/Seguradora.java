package atividade;

public class Seguradora {
	private String nome = "Seguro Auto Ldta.";
	private String endereco;
	
	public Seguradora(String endereco){
		this.setEndereco(endereco);
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getNome(){
		return this.nome;
	}
}
