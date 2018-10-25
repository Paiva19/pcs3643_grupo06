package atividade;


import java.io.IOException;
import java.util.ArrayList;

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
        
        Cotacao cotacao0 = new Cotacao(0);
        cotacao0.setData_de_inicio("2018-10-25");
        cotacao0.setData_de_fim("2019-10-25");
        cotacao0.setPremio_liquido((float) 1800.50);
        cotacao0.setPremio_total((float) 2000.00);
        cotacao0.setFranquia((float) 14.0);
        cotacao0.setValor_veiculo((float) 15000.14); 
        
        Cotacao cotacao1 = new Cotacao(1);
        cotacao1.setData_de_inicio("2017-10-25");
        cotacao1.setData_de_fim("2018-10-25");
        cotacao1.setPremio_liquido((float) 1400.00);
        cotacao1.setPremio_total((float) 3000.00);
        cotacao1.setFranquia((float) 750.0);
        cotacao1.setValor_veiculo((float) 12000.00);
        
        Cotacao cotacao2 = new Cotacao(2);
        cotacao2.setData_de_inicio("2016-10-25");
        cotacao2.setData_de_fim("2017-10-25");
        cotacao2.setPremio_liquido((float) 1000.25);
        cotacao2.setPremio_total((float) 2000.00);
        cotacao2.setFranquia((float) 500.0);
        cotacao2.setValor_veiculo((float) 15000.00); 
        
        this.cotacoes.add(cotacao0);
        this.cotacoes.add(cotacao1);
        this.cotacoes.add(cotacao2);
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
