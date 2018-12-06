package atividade;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/cotacoes")
public class ControllerCotacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerCotacao() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String vender = request.getParameter("vender");
		String id_segurado = request.getParameter("id_segurado");
		if(id_segurado != null){				
			try {
				SeguradoDAO seguradoDAO= new SeguradoDAO();
				request.setAttribute("segurado", seguradoDAO.findByPrimaryKey((Integer.parseInt(id_segurado))));
				VeiculoDAO veiculoDAO = new VeiculoDAO();
				request.setAttribute("veiculos", veiculoDAO.GetVeiculosByDonoId(Integer.parseInt(id_segurado)));
				RequestDispatcher requestDispatcher =
						getServletContext().getRequestDispatcher("/formulario_cotacao.jsp");
				requestDispatcher.forward(request, response);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		else if (id == null) {
	        try {
	        	CotacaoDAO cotacaoDAO = new CotacaoDAO();
	        	ArrayList<Cotacao> cotacoes = cotacaoDAO.getAll();
	        	request.setAttribute("lista", cotacoes);
				RequestDispatcher requestDispatcher =
				 getServletContext().getRequestDispatcher("/lista_cotacoes.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (vender == null) {
			try {
				CotacaoDAO cotacaoDAO = new CotacaoDAO();
				Cotacao cotacao = cotacaoDAO.findByPrimaryKey(Integer.parseInt(id)); 
				request.setAttribute("cotacao", cotacao);
				SeguradoDAO seguradoDAO = new SeguradoDAO();
				Segurado segurado = seguradoDAO.findByPrimaryKey(cotacao.getSegurado_id());
				System.out.print(segurado == null);
				request.setAttribute("segurado", segurado);
				VeiculoDAO veiculoDAO = new VeiculoDAO();
				Veiculo veiculo = veiculoDAO.findVeiculoByPrimaryKey(cotacao.getVeiculo_id());
				request.setAttribute("veiculo", veiculo);
				RequestDispatcher requestDispatcher =
						getServletContext().getRequestDispatcher("/detalhes_cotacao.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			ApoliceDAO apoliceDAO = new ApoliceDAO();
			CotacaoDAO cotacaoDAO = new CotacaoDAO();
			try {
				Cotacao cotacao = cotacaoDAO.findByPrimaryKey(Integer.parseInt(id));
				Apolice apolice = new Apolice(
						0,
						ThreadLocalRandom.current().nextInt(1, 70 + 1),
						(Date) cotacao.getData_de_inicio(),
						(Date) cotacao.getData_de_fim(),
						"ativa"
				);
				response.sendRedirect("apolices");
				apoliceDAO.create(apolice, cotacao);
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	variavel aqui = request.getParameter(nome do parametro)
		String idSegurado = request.getParameter("seguradoId");
		String idVeiculo = request.getParameter("veiculoId");
		System.out.println("ID segurado: " + idSegurado + " ID Veiculo: " + idVeiculo);
		int vdOuVmr = Integer.parseInt(request.getParameter("valorVeiculo"));
		float danosMateriais = 0f;
		float danosCorporais = 0f;
		float valorAcessorios = 0f;
		try {
			danosMateriais = Float.parseFloat(request.getParameter("danosMateriais"));
		} catch (NullPointerException e) {
			System.out.print("Sem danos materiais");
		}
		try {
			danosCorporais = Float.parseFloat(request.getParameter("danosCorporais"));
		} catch (NullPointerException e) {
			System.out.print("Sem danos corporais");
		}
		int qualFranquiaCasco = Integer.parseInt(request.getParameter("franquiaCasco"));
		if (request.getParameter("franquiaAcessorios") != null) {
			valorAcessorios = 1000f;
		}
		
		float valorVeiculo;
		float franquiaCasco = 0;
		float franquiaAcessorios = 0;
		float premioCasco = 0;
		float premioAcessorios = 0;
		float premioDanosMateriais = 0;
		float premioDanosCorporais = 0;
		float iof = 0;
		float premioLiquido = 0;
		float premioTotal = 0;
		
		if(vdOuVmr == 1){
			valorVeiculo = Float.parseFloat(request.getParameter("valorDeterminado"));
		}
		else {
			valorVeiculo = Float.parseFloat(request.getParameter("VMR"));
		}
		//Calculo Franquias
		if (qualFranquiaCasco == 0) {//Majorada
			franquiaCasco = 0.1f  * valorVeiculo;
		} else if (qualFranquiaCasco == 1) {//Obrigatória
			franquiaCasco = 0.08f * valorVeiculo;
		} else {//Reduzida
			franquiaCasco = 0.06f  * valorVeiculo;
		}
		franquiaAcessorios = 0.15f * valorAcessorios;
		
		//Calculo Premios
		if (qualFranquiaCasco == 0) {//Majorada
			premioCasco = 0.02f * valorVeiculo;
		} else if (qualFranquiaCasco == 1) {//Obrigatória
			premioCasco = 0.03f * valorVeiculo;
		} else {//Reduzida
			premioCasco = 0.05f * valorVeiculo;
		}
		premioAcessorios = 0.005f * valorAcessorios;
		premioDanosMateriais = 0.0025f * danosMateriais;
		premioDanosCorporais = 0.0025f * danosCorporais;
		premioLiquido = premioCasco + premioAcessorios + premioDanosMateriais + premioDanosCorporais;
		iof = 0.0738f * premioLiquido;
		premioTotal = iof + premioLiquido;
		
		Cotacao cotacao = new Cotacao(14);
		Calendar currenttime = Calendar.getInstance();
		cotacao.setData_de_inicio(new Date((currenttime.getTime()).getTime()));
		cotacao.setData_de_fim(new Date((long) ((currenttime.getTime()).getTime() + 3.154e+10)));
		cotacao.setDanos_corporais(danosCorporais);
		cotacao.setDanos_materiais(danosMateriais);
		cotacao.setFranquia(franquiaCasco);
		cotacao.setFranquiaAcessorios(franquiaAcessorios);
		cotacao.setIof(iof);
		cotacao.setPremio_acessorios(premioAcessorios);
		cotacao.setPremio_casco(premioCasco);
		cotacao.setPremio_danos_corporais(premioDanosCorporais);
		cotacao.setPremio_danos_materiais(premioDanosMateriais);
		cotacao.setPremio_liquido(premioLiquido);
		cotacao.setPremio_total(premioTotal);
		cotacao.setValor_acessorios(valorAcessorios);
		cotacao.setValor_veiculo(valorVeiculo);
		cotacao.setSegurado_id(Integer.parseInt(idSegurado));
		cotacao.setVeiculo_id(Integer.parseInt(idVeiculo));
		CotacaoDAO dao = new CotacaoDAO();
		try {
			dao.create(cotacao);
			response.sendRedirect("cotacoes");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
