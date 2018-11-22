package atividade;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApoliceDAO {
	
	private Connection connection;
	
	public ApoliceDAO() {
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
	
	public boolean create(Apolice apolice, Cotacao cotacao) throws SQLException {
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement("INSERT INTO Apolices ("
					+ "data_de_inicio, data_de_fim, numero_da_apolice, status, fk_cotacao) "
					+ "VALUES (?, ?, ?, ?, ?)");
			preparedstatement.setDate(1, (Date) apolice.getData_de_inicio());
			preparedstatement.setDate(2, (Date) apolice.getData_de_fim());
			preparedstatement.setInt(3, apolice.getNumero_da_apolice());
			preparedstatement.setString(4, apolice.getStatus());
			preparedstatement.setInt(5, cotacao.getId());
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
	
	public Apolice findByPrimaryKey(int id) throws SQLException {
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement("SELECT * FROM Apolices WHERE "
					+ "id_apolice = ?");
			preparedstatement.setInt(1, id);
			ResultSet result = preparedstatement.executeQuery();
			Apolice apolice = null;
			while (result.next()) {
				apolice = new Apolice(
						id,
						result.getInt("numero_da_apolice"),
						result.getDate("data_de_inicio"),
						result.getDate("data_de_fim"),
						result.getString("status"));
		        return apolice;
			}
			return apolice;
			
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
	
	public ArrayList<Apolice> getAll() throws SQLException {
		PreparedStatement preparedstatement = null;
		ArrayList<Apolice> apolices = new ArrayList<Apolice>();
		try {
			preparedstatement = connection.prepareStatement("SELECT * FROM Apolices");
			ResultSet result = preparedstatement.executeQuery();
			while (result.next()) {
				Apolice apolice = new Apolice(
						result.getInt("id_apolice"),
						result.getInt("numero_da_apolice"),
						result.getDate("data_de_inicio"),
						result.getDate("data_de_fim"),
						result.getString("status")
				);
		        apolices.add(apolice);
			}
			return apolices;
			
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
	
	public boolean update(Apolice apolice) throws SQLException {
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement("UPDATE Apolices SET "
					+ "data_de_inicio = ?, data_de_fim = ?, numero_da_apolice = ?, "
					+ "status = ? WHERE id_apolice = ?");
			preparedstatement.setDate(1, (Date) apolice.getData_de_inicio());
			preparedstatement.setDate(2, (Date) apolice.getData_de_fim());
			preparedstatement.setInt(3, apolice.getNumero_da_apolice());
			preparedstatement.setString(4, apolice.getStatus());
			preparedstatement.setInt(5, apolice.getId());
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
	
	public boolean remove(int id) throws SQLException {
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement("DELETE FROM Apolices WHERE "
					+ "id_apolice = ?");
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
	
	public ArrayList<Apolice> getAllByDate(Date inicio, Date fim) throws SQLException {
		ArrayList<Apolice> apolices = null;
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement("SELECT * FROM Apolices WHERE "
					+ "data_de_inicio > ? and data_de_fim < ?");
			preparedstatement.setDate(1, inicio);
			preparedstatement.setDate(2, fim);
			ResultSet result = preparedstatement.executeQuery();
			apolices = new ArrayList<Apolice>();
			while (result.next()) {
				Apolice apolice = new Apolice(
						result.getInt("id_apolice"),
						result.getInt("numero_da_apolice"),
						result.getDate("data_de_inicio"),
						result.getDate("data_de_fim"),
						result.getString("status")
				);
		        apolices.add(apolice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedstatement != null) {
				preparedstatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return apolices;
	}
}
