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
import java.util.Calendar;

/**
 * Servlet implementation class ControllerApolice
 */
@WebServlet("/apolices")
public class ControllerApolice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerApolice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		if (id == null) {
			ApoliceDAO apoliceDAO = new ApoliceDAO();
			ArrayList<Apolice> apolices;
			try {
				apolices = apoliceDAO.getAll();
				request.setAttribute("lista", apolices);
				RequestDispatcher requestDispatcher =
				 getServletContext().getRequestDispatcher("/lista_apolices.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			ApoliceDAO apoliceDAO = new ApoliceDAO();
			Apolice apolice;
			Calendar currenttime = Calendar.getInstance();
		    Date sqldate = new Date((currenttime.getTime()).getTime());
			try {
				apolice = apoliceDAO.findByPrimaryKey(Integer.parseInt(id));
				request.setAttribute("apolice", apolice);
				request.setAttribute("now", sqldate);
				RequestDispatcher requestDispatcher =
						getServletContext().getRequestDispatcher("/alterar_status_apolice.jsp");
				requestDispatcher.forward(request, response);
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
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		if (id == null || status == null) {
			response.getWriter().append("Faltaram id e/ou status, viu?");
		} else {
			ApoliceDAO apoliceDAO = new ApoliceDAO();
			Apolice apolice;
			try {
				apolice = apoliceDAO.findByPrimaryKey(Integer.parseInt(id));
				apolice.setStatus(status);
				apoliceDAO = new ApoliceDAO();
				boolean res = apoliceDAO.update(apolice);
				response.sendRedirect("apolices");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
