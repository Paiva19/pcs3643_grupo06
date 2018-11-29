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
@WebServlet("/segurados")
public class ControllerSegurado extends HttpServlet {
	private ArrayList<Segurado> segurados;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerSegurado() {
        super();
        SeguradoDAO seguradoDAO = new SeguradoDAO();
        this.segurados = new ArrayList<Segurado>();
        try {
			this.segurados = seguradoDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null){	
			request.setAttribute("lista_segurados", this.segurados);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/lista_segurados.jsp");
			requestDispatcher.forward(request, response);
		}
		else{
			//deu ruim?
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
