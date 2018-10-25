package servletPackage;

public class Veiculo {
	private String modelo;
	private int id;
	
	
	public Veiculo(int id, String modelo){
		super();
		this.id = id;
		this.modelo = modelo;
	}
	
	public int getId() {
		return this.id;
	}
	public String getModelo() {
		return this.modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	
}
