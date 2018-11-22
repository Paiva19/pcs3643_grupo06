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
		String id = request.getParameter("id");
		String vender = request.getParameter("vender");
		if (id == null) {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
