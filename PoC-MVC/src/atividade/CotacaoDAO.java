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
	
	public boolean create(Cotacao cotacao, Veiculo veiculo, Segurado segurado) throws SQLException {
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement("INSERT INTO Cotacoes ("
					+ "data_de_inicio, data_de_fim, premio_liquido, premio_total, valor_veiculo, franquia, fk_segurado, fk_veiculo) "
					+ "VALUES (?, ?, ?, ?, ?, ?)");
			preparedstatement.setDate(1, (Date) cotacao.getData_de_inicio());
			preparedstatement.setDate(2, (Date) cotacao.getData_de_fim());
			preparedstatement.setFloat(3, cotacao.getPremio_liquido());
			preparedstatement.setFloat(4, cotacao.getPremio_total());
			preparedstatement.setFloat(5, cotacao.getValor_veiculo());
			preparedstatement.setFloat(6, cotacao.getFranquia());
			preparedstatement.setInt(7, segurado.getId_segurado());
			preparedstatement.setInt(8, veiculo.getId());
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
		        cotacao.setFranquia(result.getFloat("franquia"));
		        cotacao.setValor_veiculo(result.getFloat("valor_veiculo"));
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
		        cotacao.setFranquia(result.getFloat("franquia"));
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
		        cotacao.setFranquia(result.getFloat("franquia"));
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
	
	public boolean update(Cotacao cotacao) throws SQLException {
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement("UPDATE Cotacao SET "
					+ "data_de_inicio = ?, data_de_fim = ?, premio_liquido = ?, "
					+ "premio_total = ?, valor_veiculo = ?, franquia = ? WHERE "
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
}
