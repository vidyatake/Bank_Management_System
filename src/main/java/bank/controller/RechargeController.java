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

import bank.dao.TransactionDao;
import bank.dao.TransactionDaoImpl;
import bank.model.*;

/**
 * Servlet implementation class RechargeController
 */
@WebServlet("/RechargeController")
public class RechargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechargeController() {
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
		List<Transaction> lstt = new ArrayList<Transaction>();
		HttpSession session = request.getSession();
		List<Register> lstr = (List<Register>) session.getAttribute("udata");
		if(lstr != null) {
			Register r = lstr.get(0);
			String tacc = request.getParameter("mNo")+"-"+request.getParameter("mOp");
			lstt.add(new Transaction(0, r.getaNo(), tacc,"date","Recharge", Float.parseFloat(request.getParameter("Amt"))));
			session.setAttribute("bdata", lstt);
			response.sendRedirect("BillController");
		}
		else {
			session.setAttribute("f1", true);
			response.sendRedirect("Login.jsp");
		}
	}
}
