package atividade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CorretorDAO {

	private Connection connection;
	
	public CorretorDAO() {
		this.connection = this.GetConnection();
	}

	private Connection GetConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g6",
													 "t1g6", "XFfw*PhB");			
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public boolean CreateCorretor(Corretor corretor) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
		preparedStatement = connection.prepareStatement("INSERT INTO Corretores (	"
				+ "	id_corretor, nome, telefone, email) "
				+ "VALUES (?, ?, ?, ?)");
		preparedStatement.setInt(1, corretor.getId_corretor());
		preparedStatement.setString(2, corretor.getNome());
		preparedStatement.setString(3, corretor.getTelefone());
		preparedStatement.setString(4, corretor.getEmail());
		ResultSet resultset = preparedStatement.executeQuery();
		return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if( preparedStatement != null ){
				preparedStatement.close();
			}
			if( connection != null ){
				connection.close();
			}
		}
	}
	
	public Corretor findCorretorByPrimaryKey (int id) throws SQLException {
		PreparedStatement preparedStatement = null;
		try{
			preparedStatement = connection.prepareStatement("SELECT * FROM Corretores WHERE id_corretor = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			Corretor corretor = new Corretor(resultSet.getInt("corretor_id"), resultSet.getString("nome"), resultSet.getString("telefone"), resultSet.getString("email"));
			return corretor;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if( preparedStatement != null ){
				preparedStatement.close();
			}
			if( connection != null ){
				connection.close();
			}
		}
	}
	
	
}
