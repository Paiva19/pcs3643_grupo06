package atividade;

public class Veiculo {
	private String modelo;
	private int id_veiculo;
	
	public Veiculo(int id_veiculo, String modelo){
		super();
		this.id_veiculo = id_veiculo;
		this.modelo = modelo;
	}
	
	public int getId() {
		return this.id_veiculo;
	}
	public String getModelo() {
		return this.modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	
}
