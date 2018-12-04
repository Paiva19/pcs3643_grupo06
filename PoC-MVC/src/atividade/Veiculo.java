package atividade;

public class Veiculo {
	
	private int id_veiculo;
	private String fipe;
	private String marca;
	private String modelo;
	private int portas;
	private int anoFabricacao;
	private int anoModelo;
	private int nPassageiros;
	private String chassi;
	private String renavam;
	private String classe;
	
	public Veiculo(int id_veiculo, String fipe, String marca, String modelo,
				   int portas, int anoFabricacao, int anoModelo, int nPassageiros,
				   String chassi, String renavam, String classe){
		super();
		this.id_veiculo = id_veiculo;
		this.setFipe(fipe);
		this.setMarca(marca);
		this.modelo = modelo;
		this.setPortas(portas);
		this.setAnoFabricacao(anoFabricacao);
		this.setAnoModelo(anoModelo);
		this.setnPassageiros(nPassageiros);
		this.setChassi(chassi);
		this.setRenavam(renavam);
		this.setClasse(classe);
	}
	
	public int getId() {
		return this.id_veiculo;
	}
	public void setId(int id) {
		this.id_veiculo = id;
	}
	public String getModelo() {
		return this.modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFipe() {
		return fipe;
	}

	public void setFipe(String fipe) {
		this.fipe = fipe;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getPortas() {
		return this.portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}

	public int getAnoFabricacao() {
		return this.anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public int getAnoModelo() {
		return this.anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public int getnPassageiros() {
		return this.nPassageiros;
	}

	public void setnPassageiros(int nPassageiros) {
		this.nPassageiros = nPassageiros;
	}

	public String getChassi() {
		return this.chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getRenavam() {
		return this.renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getClasse() {
		return this.classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}	
}
