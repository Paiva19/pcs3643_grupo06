package testes;

import atividade.Cotacao;
import atividade.CotacaoDAO;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.*;

public class TestCotacao extends Auxiliar {
	private static int cotacaoId;
	
	@BeforeClass
	public static void setUp() throws SQLException {
		Cotacao cotacao = new Cotacao(4);
		cotacao.setData_de_fim(new Date(2018, 12, 3));
		cotacao.setData_de_inicio(new Date(2017, 12, 3));
		cotacao.setFranquia((float) 14.0);
		cotacao.setPremio_liquido((float) 12);
		cotacao.setPremio_total(13);
		cotacao.setValor_veiculo(15);
		CotacaoDAO dao = new CotacaoDAO();
		TestCotacao.cotacaoId = dao.create(cotacao);
	}
	
	@Test
	public void testListAllCotacoes() {
		String response = this.getHttp(this.formatUrl("/cotacoes"));
		assertTrue(response.contains("Formulário Cotação"));
	}
	
	@Test
	public void testDetailsACotacao() {
		String response = this.getHttp(this.formatUrl(String.format("/cotacoes?id=%d", TestCotacao.cotacaoId)));
		assertTrue(response.contains(String.format("Detalhes de Cotação #%d", TestCotacao.cotacaoId)));
	}
	
	@Test
	public void testFinishCotacaoIntoApolice() {
		String response = this.getHttp(this.formatUrl(String.format("/cotacoes?id=%d&vender=1", TestCotacao.cotacaoId)));
		assertTrue(response.contains("Lista de apólices"));
		//assertTrue(response.contains(String.format("apolices?&id=%d", TestCotacao.cotacaoId)));
	}
	
	@AfterClass
	public static void tearDown() throws SQLException {
		CotacaoDAO dao = new CotacaoDAO();
		dao.remove(TestCotacao.cotacaoId);
	}

}
