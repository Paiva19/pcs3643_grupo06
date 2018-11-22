package atividade;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerRelatorio
 */
@WebServlet("/relatorio")
public class ControllerRelatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerRelatorio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher =
				 getServletContext().getRequestDispatcher("/gerar_relatorio.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] dataInicialStr = request.getParameter("data_inicial").split("-");
		String[] dataFinalStr = request.getParameter("data_final").split("-");
		Date dataInicial = new Date(
				Integer.parseInt(dataInicialStr[0]),
				Integer.parseInt(dataInicialStr[1]),
				Integer.parseInt(dataInicialStr[2]));
		Date dataFinal = new Date(
				Integer.parseInt(dataFinalStr[0]),
				Integer.parseInt(dataFinalStr[1]),
				Integer.parseInt(dataFinalStr[2])
				);
		ApoliceDAO apoliceDAO = new ApoliceDAO();
		try {
			ArrayList<Apolice> apolices = apoliceDAO.getAllByDate(dataInicial, dataFinal);
			String relatorio = "num,inicio,fim,status\n";
			for (int i=0; i<apolices.size(); i++) {
				relatorio += apolices.get(i).getNumero_da_apolice() + ",";
				relatorio += apolices.get(i).getData_de_inicio() + ",";
				relatorio += apolices.get(i).getData_de_fim() + ",";
				relatorio += apolices.get(i).getStatus() + "\n";
			}
			response.setContentType("application/force-download");
			response.setContentLength((int)relatorio.length());
			        //response.setContentLength(-1);
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setHeader("Content-Disposition","attachment; filename=\"" + "relatorio.csv\"");//fileName)
			response.getWriter().append(relatorio);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
