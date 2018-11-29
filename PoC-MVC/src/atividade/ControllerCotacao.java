package atividade;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
		System.out.println("oi rs");
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
				RequestDispatcher requestDispatcher =
						getServletContext().getRequestDispatcher("/detalhes_cotacao.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			ApoliceDAO apoliceDAO = new ApoliceDAO();
			Apolice apolice = new Apolice(
					0,
					ThreadLocalRandom.current().nextInt(1, 70 + 1),
					new Date(2018 - 1900, 11, 22),
					new Date(2019 - 1900, 11, 22),
					"ativa"
			);
			response.sendRedirect("apolices");
			try {
				apoliceDAO.create(apolice, new Cotacao(Integer.parseInt(id)));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		float danosMateriais = Float.parseFloat(request.getParameter("danosMateriais"));
		float danosCorporais = Float.parseFloat(request.getParameter("danosCorporais"));
		int qualFranquiaCasco = Integer.parseInt(request.getParameter("franquiaCasco"));
		float valorAcessorios = Float.parseFloat(request.getParameter("franquiaAcessorios"));
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
		
		if(vdOuVmr == 0){
			valorVeiculo = Float.parseFloat(request.getParameter("valorDeterminado"));
		}
		else {
			valorVeiculo = Float.parseFloat(request.getParameter("VMR"));
		}
		//Calculo Franquias
		franquiaCasco = (0.1f - 0.02f * qualFranquiaCasco) * valorVeiculo;
		franquiaCasco = 0.15f * valorAcessorios;
		
		//Calculo Premios
		
		
		
		
		response.sendRedirect("cotacoes");
	}
}
