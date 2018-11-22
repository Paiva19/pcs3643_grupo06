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
	
	public boolean CreateVeiculo(Veiculo veiculo) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
		preparedStatement = connection.prepareStatement("INSERT INTO Veiculos (	"
				+ "id_veiculo, fipe, marca, modelo, portas, anoFabricacao, anoModelo, nPassageiros, chassi, renavam, classe) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		preparedStatement.setInt(1, veiculo.getId());
		preparedStatement.setString(2, veiculo.getFipe());
		preparedStatement.setString(3, veiculo.getMarca());
		preparedStatement.setString(4, veiculo.getModelo());
		preparedStatement.setInt(5, veiculo.getPortas());
		preparedStatement.setInt(6, veiculo.getAnoFabricacao());
		preparedStatement.setInt(7, veiculo.getAnoModelo());
		preparedStatement.setInt(8, veiculo.getnPassageiros());
		preparedStatement.setString(9, veiculo.getChassi());
		preparedStatement.setString(10, veiculo.getChassi());
		preparedStatement.setString(11, veiculo.getRenavam());
		preparedStatement.setString(12, veiculo.getClasse());
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
			preparedStatement = connection.prepareStatement("SELECT * FROM Veiculos WHERE id_veiculo = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			Veiculo veiculo = new Veiculo(resultSet.getInt("id_veiculo"), resultSet.getString("fipe"), resultSet.getString("marca"), resultSet.getString("modelo"),
					resultSet.getInt("portas"), resultSet.getInt("anoFabricacao"), resultSet.getInt("anoModelo"), resultSet.getInt("nPassageiros"),
					resultSet.getString("chassi"), resultSet.getString("renavam"), resultSet.getString("classe"));
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
			preparedStatement = connection.prepareStatement("SELECT * FROM Veiculos");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Veiculo veiculo = new Veiculo(resultSet.getInt("id_veiculo"), resultSet.getString("fipe"), resultSet.getString("marca"), resultSet.getString("modelo"),
						resultSet.getInt("portas"), resultSet.getInt("anoFabricacao"), resultSet.getInt("anoModelo"), resultSet.getInt("nPassageiros"),
						resultSet.getString("chassi"), resultSet.getString("renavam"), resultSet.getString("classe"));
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
				preparedStatement = connection.prepareStatement("UPDATE Veiculos SET "
						+ "fipe = ?, marca = ?, modelo = ?, portas = ?, anoFabricacao = ?, anoModelo = ?, nPassageiros = ?, chassi = ?, renavam = ?, classe = ?  "
						+ "WHERE id_veiculo = ?");
				preparedStatement.setString(1, veiculo.getFipe());
				preparedStatement.setString(2, veiculo.getMarca());
				preparedStatement.setString(3, veiculo.getModelo());
				preparedStatement.setInt(4, veiculo.getPortas());
				preparedStatement.setInt(5, veiculo.getAnoFabricacao());
				preparedStatement.setInt(6, veiculo.getAnoModelo());
				preparedStatement.setInt(7, veiculo.getnPassageiros());
				preparedStatement.setString(8, veiculo.getChassi());
				preparedStatement.setString(9, veiculo.getChassi());
				preparedStatement.setString(10, veiculo.getRenavam());
				preparedStatement.setString(11, veiculo.getClasse());
				preparedStatement.setInt(12, veiculo.getId());
				
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
			preparedStatement = connection.prepareStatement("DELETE FROM Veiculos WHERE id_veiculo = ?");
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
