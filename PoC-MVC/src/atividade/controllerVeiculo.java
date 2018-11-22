package atividade;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.ibm.CORBA.iiop.Request;

/**
 * Servlet implementation class controllerVeiculo
 */
@WebServlet("/veiculos")
public class controllerVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<Veiculo> veiculos;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controllerVeiculo() {
        super();
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        this.veiculos = new ArrayList<Veiculo>();
        try {
        	this.veiculos = veiculoDAO.GetAllVeiculos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null){
			
			request.setAttribute("listarVeiculos", this.veiculos);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/listarVeiculos.jsp");
			requestDispatcher.forward(request, response);
		}
		else{
			request.setAttribute("detalheVeiculo", this.veiculos.get((Integer.parseInt(id))));
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/detalheVeiculo.jsp");
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
