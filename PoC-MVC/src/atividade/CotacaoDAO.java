package atividade;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CotacaoDAO {
	private Connection connection;
	
	public CotacaoDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g6",
					"t1g6", "XFfw*PhB");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int create(Cotacao cotacao) throws SQLException {
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement("INSERT INTO Cotacoes ("
					+ "data_de_inicio, data_de_fim, premio_liquido, premio_total, "
					+ "valor_veiculo, franquia_casco, franquia_acessorios, "
					+ "premio_acessorios, premio_casco, premio_danos_materiais, "
					+ "premio_danos_corporais, danos_materiais, danos_corporais, "
					+ "valor_acessorios, iof, fk_segurado, fk_veiculo) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedstatement.setDate(1, (Date) cotacao.getData_de_inicio());
			preparedstatement.setDate(2, (Date) cotacao.getData_de_fim());
			preparedstatement.setFloat(3, cotacao.getPremio_liquido());
			preparedstatement.setFloat(4, cotacao.getPremio_total());
			preparedstatement.setFloat(5, cotacao.getValor_veiculo());
			preparedstatement.setFloat(6, cotacao.getFranquia());
			preparedstatement.setFloat(7, cotacao.getFranquiaAcessorios());
			preparedstatement.setFloat(8, cotacao.getPremio_acessorios());
			preparedstatement.setFloat(9, cotacao.getPremio_casco());
			preparedstatement.setFloat(10, cotacao.getPremio_danos_materiais());
			preparedstatement.setFloat(11, cotacao.getPremio_danos_corporais());
			preparedstatement.setFloat(12, cotacao.getDanos_materiais());
			preparedstatement.setFloat(13, cotacao.getDanos_corporais());
			preparedstatement.setFloat(14, cotacao.getValor_acessorios());
			preparedstatement.setFloat(15, cotacao.getIof());
			preparedstatement.setInt(16, cotacao.getSegurado_id());
			preparedstatement.setInt(17, cotacao.getVeiculo_id());
			int result = preparedstatement.executeUpdate();
			ResultSet generatedKeys = preparedstatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				return (int) generatedKeys.getLong(1);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (preparedstatement != null) {
				preparedstatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	public Cotacao findByPrimaryKey(int id) throws SQLException {
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement("SELECT * FROM Cotacoes WHERE "
					+ "id_cotacao = ?");
			preparedstatement.setInt(1, id);
			ResultSet result = preparedstatement.executeQuery();
			Cotacao cotacao = null;
			while (result.next()) {
				cotacao = new Cotacao(id);
				cotacao.setData_de_inicio(result.getDate("data_de_inicio")); 
		        cotacao.setData_de_fim(result.getDate("data_de_fim"));
		        cotacao.setPremio_liquido(result.getFloat("premio_liquido"));
		        cotacao.setPremio_total(result.getFloat("premio_total"));
		        cotacao.setFranquia(result.getFloat("franquia_casco"));
		        cotacao.setValor_veiculo(result.getFloat("valor_veiculo"));
		        cotacao.setSegurado_id(result.getInt("fk_segurado"));
		        cotacao.setVeiculo_id(result.getInt("fk_veiculo"));
		        //@ TO-DO: Find Veiculo by fk_veiculo, and find Segurado by fk_segurado
		        return cotacao;
			}
			return cotacao;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (preparedstatement != null) {
				preparedstatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	public ArrayList<Cotacao> getCotacaoBySegurado(Segurado segurado) throws SQLException {
		PreparedStatement preparedstatement = null;
		ArrayList<Cotacao> cotacoes = new ArrayList<Cotacao>();
		try {
			preparedstatement = connection.prepareStatement("SELECT * FROM Cotacoes WHERE fk_segurado = ?");
			preparedstatement.setInt(1, segurado.getId_segurado());
			ResultSet result = preparedstatement.executeQuery();
			while (result.next()) {
				Cotacao cotacao = new Cotacao(result.getInt("id_cotacao"));
				cotacao.setData_de_inicio(result.getDate("data_de_inicio")); 
		        cotacao.setData_de_fim(result.getDate("data_de_fim"));
		        cotacao.setPremio_liquido(result.getFloat("premio_liquido"));
		        cotacao.setPremio_total(result.getFloat("premio_total"));
		        cotacao.setFranquia(result.getFloat("franquia_casco"));
		        cotacao.setValor_veiculo(result.getFloat("valor_veiculo"));
		        cotacoes.add(cotacao);
			}
			return cotacoes;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (preparedstatement != null) {
				preparedstatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	
	public ArrayList<Cotacao> getAll() throws SQLException {
		PreparedStatement preparedstatement = null;
		ArrayList<Cotacao> cotacoes = new ArrayList<Cotacao>();
		try {
			preparedstatement = connection.prepareStatement("SELECT * FROM Cotacoes");
			ResultSet result = preparedstatement.executeQuery();
			while (result.next()) {
				Cotacao cotacao = new Cotacao(result.getInt("id_cotacao"));
				cotacao.setData_de_inicio(result.getDate("data_de_inicio")); 
		        cotacao.setData_de_fim(result.getDate("data_de_fim"));
		        cotacao.setPremio_liquido(result.getFloat("premio_liquido"));
		        cotacao.setPremio_total(result.getFloat("premio_total"));
		        cotacao.setFranquia(result.getFloat("franquia_casco"));
		        cotacao.setFranquiaAcessorios(result.getFloat("franquia_acessorios"));
		        cotacao.setValor_veiculo(result.getFloat("valor_veiculo"));
		        cotacao.setDanos_corporais(result.getFloat("danos_corporais"));
		        cotacao.setDanos_materiais(result.getFloat("danos_materiais"));
		        cotacao.setSegurado_id(result.getInt("fk_segurado"));
		        cotacao.setVeiculo_id(result.getInt("fk_veiculo"));
		        cotacoes.add(cotacao);
			}
			return cotacoes;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (preparedstatement != null) {
				preparedstatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	public boolean update(Cotacao cotacao) throws SQLException {
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement("UPDATE Cotacao SET "
					+ "data_de_inicio = ?, data_de_fim = ?, premio_liquido = ?, "
					+ "premio_total = ?, valor_veiculo = ?, franquia_casco = ? WHERE "
					+ "id_cotacao = ?");
			preparedstatement.setDate(1, (Date) cotacao.getData_de_inicio());
			preparedstatement.setDate(2, (Date) cotacao.getData_de_fim());
			preparedstatement.setFloat(3, cotacao.getPremio_liquido());
			preparedstatement.setFloat(4, cotacao.getPremio_total());
			preparedstatement.setFloat(5, cotacao.getValor_veiculo());
			preparedstatement.setFloat(6, cotacao.getFranquia());
			preparedstatement.setInt(7, cotacao.getId());
			ResultSet result = preparedstatement.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (preparedstatement != null) {
				preparedstatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	public boolean remove(int id) throws SQLException {
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement("DELETE FROM Cotacoes WHERE "
					+ "id_cotacao = ?");
			preparedstatement.setInt(1, id);
			int result = preparedstatement.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (preparedstatement != null) {
				preparedstatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
}
