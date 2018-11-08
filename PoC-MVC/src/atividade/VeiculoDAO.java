package atividade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDAO {

	private Connection connection;
	
	public VeiculoDAO() {
		this.connection = this.GetConnection();
	}

	private Connection GetConnection() {
		Connection conn = null;
		try {
			Class.forName("org.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g6",
													 "t1g6", "XFfw*PhB");			
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public boolean CreateVeiculo(Veiculo veiculo) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
		preparedStatement = connection.prepareStatement("INSERT INTO veiculos (modelo) VALUES (?)");
		preparedStatement.setString(1, veiculo.getModelo());
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
	
	public Veiculo findVeiculoByPrimaryKey (int id) throws SQLException {
		PreparedStatement preparedStatement = null;
		try{
			preparedStatement = connection.prepareStatement("SELECT * FROM veiculos WHERE veiculo_id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			Veiculo veiculo = new Veiculo(resultSet.getInt("veiculo_id"), resultSet.getString("modelo"));
			return veiculo;
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
	
	public ArrayList<Veiculo> GetAllVeiculos () throws SQLException {
		PreparedStatement preparedStatement = null;
		try{
			ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
			preparedStatement = connection.prepareStatement("SELECT * FROM veiculos");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Veiculo veiculo = new Veiculo(resultSet.getInt("veiculo_id"), resultSet.getString("modelo"));
				veiculos.add(veiculo);
			}
			return veiculos;
			
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
	
	public boolean updateVeiculo(Veiculo veiculo) throws SQLException{
		PreparedStatement preparedStatement = null;
			try {
				preparedStatement = connection.prepareStatement("UPDATE veiculos SET modelo = ? WHERE id_veiculo = ?");
				preparedStatement.setString(1, veiculo.getModelo());
				preparedStatement.setInt(2, veiculo.getId());
				if(veiculo.getId() > 0){
					ResultSet resultSet = preparedStatement.executeQuery();
					return true;
				}
				else return false;
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
	
	public boolean removeVeiculo (int id) throws SQLException{
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM veiculos WHERE id_veiculo = ?");
			preparedStatement.setInt(1, id);
			if(id > 0){
				ResultSet resultSet = preparedStatement.executeQuery();
				return true;
			}
			else return false;
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
	
}
