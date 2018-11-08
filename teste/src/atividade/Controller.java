package atividade;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Cotacao> cotacoes;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        this.cotacoes = new ArrayList<Cotacao>();
        CotacaoDAO cotacaoDAO = new CotacaoDAO();
        try {
        	this.cotacoes = cotacaoDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		if (id == null) {
			request.setAttribute("lista", this.cotacoes);
			RequestDispatcher requestDispatcher =
			 getServletContext().getRequestDispatcher("/lista.jsp");
			requestDispatcher.forward(request, response);
		} else {
			request.setAttribute("cotacao", this.cotacoes.get(Integer.parseInt(id)));
			RequestDispatcher requestDispatcher =
			 getServletContext().getRequestDispatcher("/detalhe.jsp");
			requestDispatcher.forward(request, response);
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
