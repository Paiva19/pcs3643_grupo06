package atividade;

import java.sql.SQLException;
import java.util.Date;

public class Cotacao {
	private Date data_de_inicio;
	private Date data_de_fim;
	private float premio_liquido;
	private float premio_total;
	private float valor_veiculo;
	private float franquia; //Casco, não vou renomar pq tempo
	private float franquiaAcessorios;
	private float danos_materiais;
	private float danos_corporais;
	private float valor_acessorios;
	private float premio_casco;
	private float premio_acessorios;
	private float premio_danos_materiais;
	private float premio_danos_corporais;
	private float iof;
	private int segurado_id;
	private int veiculo_id;
	private int id;
	
	public Cotacao(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public float getFranquiaAcessorios() {
		return franquiaAcessorios;
	}

	public void setFranquiaAcessorios(float franquiaAcessorios) {
		this.franquiaAcessorios = franquiaAcessorios;
	}

	public float getDanos_materiais() {
		return danos_materiais;
	}

	public void setDanos_materiais(float danos_materiais) {
		this.danos_materiais = danos_materiais;
	}

	public float getDanos_corporais() {
		return danos_corporais;
	}

	public void setDanos_corporais(float danos_corporais) {
		this.danos_corporais = danos_corporais;
	}

	public float getValor_acessorios() {
		return valor_acessorios;
	}

	public void setValor_acessorios(float valor_acessorios) {
		this.valor_acessorios = valor_acessorios;
	}

	public float getPremio_casco() {
		return premio_casco;
	}

	public void setPremio_casco(float premio_casco) {
		this.premio_casco = premio_casco;
	}

	public float getPremio_acessorios() {
		return premio_acessorios;
	}

	public void setPremio_acessorios(float premio_acessorios) {
		this.premio_acessorios = premio_acessorios;
	}

	public float getPremio_danos_materiais() {
		return premio_danos_materiais;
	}

	public void setPremio_danos_materiais(float premio_danos_materiais) {
		this.premio_danos_materiais = premio_danos_materiais;
	}

	public float getPremio_danos_corporais() {
		return premio_danos_corporais;
	}

	public void setPremio_danos_corporais(float premio_danos_corporais) {
		this.premio_danos_corporais = premio_danos_corporais;
	}

	public float getIof() {
		return iof;
	}

	public void setIof(float iof) {
		this.iof = iof;
	}

	public int getSegurado_id() {
		return segurado_id;
	}

	public void setSegurado_id(int segurado_id) {
		this.segurado_id = segurado_id;
	}

	public int getVeiculo_id() {
		return veiculo_id;
	}

	public void setVeiculo_id(int veiculo_id) {
		this.veiculo_id = veiculo_id;
	}
	
	public Veiculo getVeiculo() {
		VeiculoDAO dao = new VeiculoDAO();
		Veiculo veiculo = null;
		try {
			veiculo = dao.findVeiculoByPrimaryKey(this.veiculo_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return veiculo;
	}
}
