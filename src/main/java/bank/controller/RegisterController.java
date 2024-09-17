package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.dao.RegisterDao;
import bank.dao.RegisterDaoImpl;
import bank.model.Register;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
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
		List<Register> lst = new ArrayList<Register>();
		RegisterDao robj = new RegisterDaoImpl();
		lst.add(new Register(Integer.parseInt(request.getParameter("aNo")),request.getParameter("cName"), request.getParameter("mNo"), Float.parseFloat(request.getParameter("aBal")),request.getParameter("Pass")));
		
		int i = robj.createRecord(lst);
		
		HttpSession session = request.getSession(true);		
		if(i>0) {
			session.invalidate();
			response.sendRedirect("Login.jsp");
		}
		else {
			session.setAttribute("acc", true);
			response.sendRedirect("Register.jsp");
		}
		
	}

}
