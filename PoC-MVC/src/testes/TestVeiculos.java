package testes;

import atividade.Veiculo;
import atividade.VeiculoDAO;
import atividade.Segurado;
import atividade.SeguradoDAO;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.*;

public class TestVeiculos extends Auxiliar {
	private static int veiculoId;
	private static int seguradoId;
	
	@BeforeClass
	public static void setUp() throws SQLException {
		Veiculo veiculo = new Veiculo(14, null, null, null, 1, 2, 3, 4, null, null, null);
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		Segurado segurado = new Segurado(14, null, null, null, null, null, null, null, null, null, null);
		SeguradoDAO seguradoDAO = new SeguradoDAO();
		TestVeiculos.seguradoId = seguradoDAO.create(segurado);
		segurado.setId_segurado(TestVeiculos.seguradoId);
		TestVeiculos.veiculoId = veiculoDAO.CreateVeiculo(veiculo, segurado);
	}
	
	@Test
	public void testListAllVeiculos() {
		String response = this.getHttp(this.formatUrl("/veiculos"));
		assertTrue(response.contains("Lista de Veículos"));
	}
	
	@Test
	public void testDetailsAVeiculo() {
		String response = this.getHttp(this.formatUrl(String.format(
				"/veiculos?id=%d", TestVeiculos.veiculoId)));
		assertTrue(response.contains("Detalhes de veículo"));
	}
	
	@AfterClass
	public static void tearDown() throws SQLException {
		SeguradoDAO seguradoDAO = new SeguradoDAO();
		seguradoDAO.remove(TestVeiculos.seguradoId);
	}
}
