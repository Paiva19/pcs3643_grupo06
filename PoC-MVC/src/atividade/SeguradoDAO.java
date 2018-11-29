package atividade;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SeguradoDAO {
	private Connection connection;
	
	public SeguradoDAO() {
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
	
	public int create(Segurado segurado) throws SQLException {
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement("INSERT INTO Segurados ("
					+"id_segurado, nome, cpf, sexo, nacionalidade, data_de_nascimento, profissao, telefone, endereco, email, cnh) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			preparedstatement.setInt(1, segurado.getId_segurado());
			preparedstatement.setString(2, segurado.getNome());
			preparedstatement.setString(3, segurado.getCpf());
			preparedstatement.setString(4, segurado.getSexo());
			preparedstatement.setString(5, segurado.getNacionalidade());
			preparedstatement.setDate(6, (Date) segurado.getData_de_nascimento());
			preparedstatement.setString(7, segurado.getProfissao());
			preparedstatement.setString(8, segurado.getTelefone());
			preparedstatement.setString(9, segurado.getEndereco());
			preparedstatement.setString(10, segurado.getEmail());
			preparedstatement.setString(11, segurado.getCnh());
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
	
	public Segurado findByPrimaryKey(int id) throws SQLException {
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement("SELECT * FROM Segurados WHERE "
					+ "id_segurado = ?");
			preparedstatement.setInt(1, id);
			ResultSet result = preparedstatement.executeQuery();
			Segurado segurado = null;
			while (result.next()) {
				segurado = new Segurado(result.getInt("id_segurado"), result.getString("nome"), result.getString("cpf"), result.getString("sexo"), result.getString("nacionalidade"), result.getDate("data_de_nascimento"), result.getString("profissao"), result.getString("telefone"), result.getString("endereco"), result.getString("email"), result.getString("cnh"));
		        return segurado;
			}
			return segurado;
			
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
	
	public ArrayList<Segurado> getAll() throws SQLException {
		PreparedStatement preparedstatement = null;
		ArrayList<Segurado> segurados = new ArrayList<Segurado>();
		try {
			preparedstatement = connection.prepareStatement("SELECT * FROM Segurados");
			ResultSet result = preparedstatement.executeQuery();
			while (result.next()) {
				Segurado segurado = new Segurado(result.getInt("id_segurado"), result.getString("nome"), result.getString("cpf"), result.getString("sexo"), result.getString("nacionalidade"), result.getDate("data_de_nascimento"), result.getString("profissao"), result.getString("telefone"), result.getString("endereco"), result.getString("email"), result.getString("cnh"));
		        segurados.add(segurado);
			}
			return segurados;
			
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
	
	
	public boolean remove(int id) throws SQLException {
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement("DELETE FROM Segurados WHERE "
					+ "id_segurado = ?");
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
