package testes;

import atividade.Apolice;
import atividade.ApoliceDAO;
import atividade.Cotacao;
import atividade.CotacaoDAO;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.*;

public class TestApolices extends Auxiliar {
	private static int apoliceId;
	private static int cotacaoId;
	
	@BeforeClass
	public static void setUp() throws SQLException {
		Apolice apolice = new Apolice(1, 14, new Date(2018, 12, 3), new Date(2019, 12, 3), "ativa");
		ApoliceDAO dao = new ApoliceDAO();
		CotacaoDAO cotacaoDAO = new CotacaoDAO();
		Cotacao cotacao = new Cotacao(14);
		cotacao.setData_de_fim(new Date(2018, 12, 3));
		cotacao.setData_de_inicio(new Date(2017, 12, 3));
		cotacao.setFranquia(14);
		cotacao.setPremio_liquido(12);
		cotacao.setPremio_total(13);
		cotacao.setValor_veiculo(15);
		cotacao.setSegurado_id(1);
		cotacao.setVeiculo_id(1);
		TestApolices.cotacaoId = cotacaoDAO.create(cotacao);
		cotacao.setId(TestApolices.cotacaoId);
		TestApolices.apoliceId = dao.create(apolice, cotacao);
	}
	
	@Test
	public void testListAllApolices() {
		String response = this.getHttp(this.formatUrl("/apolices"));
		assertTrue(response.contains("Lista de apólices"));
		
	}
	
	@Test
	public void testDetailsAnApolice() {
		String response = this.getHttp(this.formatUrl(String.format("/apolices?id=%d", TestApolices.apoliceId)));
		assertTrue(response.contains("Alterar status de apólice"));
	}
	
	@Test
	public void testChangeActiveApoliceStatus() throws SQLException {
		ApoliceDAO dao = new ApoliceDAO();
		Apolice apolice = dao.findByPrimaryKey(TestApolices.apoliceId);
		dao = new ApoliceDAO();
		apolice.setData_de_fim(new Date(2016, 12, 3));
		dao.update(apolice);
		String response = this.postHttp(this.formatUrl(
				String.format("/apolices?id=%d", TestApolices.apoliceId)), "status=cancelada");
		assertTrue(response.contains("Lista de apólices"));
		assertTrue(response.contains("cancelada"));
	}
	
	@Test
	public void testChangeClosedApoliceStatus() throws SQLException {
		ApoliceDAO dao = new ApoliceDAO();
		Apolice apolice = dao.findByPrimaryKey(TestApolices.apoliceId);
		dao = new ApoliceDAO();
		apolice.setData_de_fim(new Date(2222, 12, 3));
		dao.update(apolice);
		String response = this.postHttp(this.formatUrl(
				String.format("/apolices?id=%d", TestApolices.apoliceId)), "status=encerrada");
		assertTrue(response.contains("Lista de apólices"));
		assertTrue(response.contains("encerrada"));
	}
	
	@AfterClass
	public static void tearDown() throws SQLException {
		ApoliceDAO dao = new ApoliceDAO();
		dao.remove(TestApolices.apoliceId);
		CotacaoDAO cotacaoDAO = new CotacaoDAO();
		cotacaoDAO.remove(TestApolices.cotacaoId);
	}
}
