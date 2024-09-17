package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.model.Register;
import bank.dao.RegisterDao;
import bank.dao.RegisterDaoImpl;
/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Register> lst = null;
		RegisterDao bdao = new RegisterDaoImpl();
		int accNum = Integer.parseInt(request.getParameter("aNo"));
		String accPass = request.getParameter("Pass");
		HttpSession session = request.getSession(true);
		lst = bdao.retrieveRecord(accNum);


		if(lst.size() == 0) {		
			session.setAttribute("acc", true);//Account Number Invalid
			response.sendRedirect("Login.jsp");
		}
		else {
			Register r = lst.get(0);
			if(r.getPass().equals(accPass)) {
				session.setAttribute("udata", lst);//Successful login 
				response.sendRedirect("Profile.jsp");			
			}
			else {	
				session.setAttribute("pass", true);//Password Invalid
				response.sendRedirect("Login.jsp");
			}
		}

	}

}
