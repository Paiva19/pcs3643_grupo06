package atividade;

import java.io.IOException;
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
@WebServlet("/controllerVeiculo")
public class controllerVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<Veiculo> veiculos;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controllerVeiculo() {
        super();
        this.veiculos = new ArrayList<Veiculo>();
        Veiculo mustang = new Veiculo(0, "Mustang");
        this.veiculos.add(mustang);
        Veiculo carroVelho = new Veiculo(1, "Carro Velho");
        this.veiculos.add(carroVelho);
        Veiculo nissanZ = new Veiculo(2, "350Z");
        this.veiculos.add(nissanZ);
        Veiculo fiesta = new Veiculo(3, "Fiesta");
        this.veiculos.add(fiesta);
        Veiculo zafira = new Veiculo(4, "Zafira");
        this.veiculos.add(zafira);
        Veiculo agabe = new Veiculo(5, "HB14");
        this.veiculos.add(agabe);
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
