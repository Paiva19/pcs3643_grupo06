package testes;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import org.junit.*;

import atividade.ApoliceDAO;
import atividade.Apolice;
import atividade.CotacaoDAO;
import atividade.Cotacao;

public class TestRelatorio extends Auxiliar {
	
	@Test
	public void testLandingPage() {
		String response = this.getHttp(this.formatUrl("/relatorio"));
		assertTrue(response.contains("Gerar relatório"));
	}
	
	@Test
	public void testGenerateAReport() {
		String response = this.postHttp(this.formatUrl("/relatorio"), "data_inicial=2016-12-03&"
				+ "data_final=2020-12-03");
		assertTrue(response.contains("num,inicio,fim,status"));
	}
	
	@Test
	public void testReportIncludesApolice() throws SQLException {
		Date dataInicial = new Date((new GregorianCalendar(2018, 8 - 1, 10).getTime()).getTime());
		Date dataFinal = new Date((new GregorianCalendar(2018, 12 - 1, 3).getTime()).getTime());
		Apolice apolice = new Apolice(1, 12, dataInicial, dataFinal, "ativa");
		Cotacao cotacao = new Cotacao(14);
		cotacao.setData_de_inicio(dataInicial);
		cotacao.setData_de_fim(dataFinal);
		cotacao.setSegurado_id(1);
		cotacao.setVeiculo_id(1);
		
		ApoliceDAO dao = new ApoliceDAO();
		CotacaoDAO cotacaoDAO = new CotacaoDAO();
		int cotacaoId = cotacaoDAO.create(cotacao);
		cotacao.setId(cotacaoId);
		int apoliceId = dao.create(apolice, cotacao);
		
		String response = this.postHttp(this.formatUrl("/relatorio"), 
				"data_inicial=2018-07-09&data_final=2019-12-04");
		cotacaoDAO = new CotacaoDAO();
		cotacaoDAO.remove(cotacaoId);
		assertTrue(response.contains("2018-08-10,2018-12-03"));
	}
}
