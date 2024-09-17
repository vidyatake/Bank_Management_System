package bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.model.Register;
import bank.model.Transaction;
import bank.dao.TransactionDao;
import bank.dao.TransactionDaoImpl;


/**
 * Servlet implementation class TransactionController
 */
@WebServlet("/TransactionController")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionController() {
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
		HttpSession session = request.getSession();
		TransactionDao tdao = new TransactionDaoImpl();
		List<Register> rlst = (List<Register>) session.getAttribute("udata");
		if(rlst!=null) {
			Register r = rlst.get(0);
			List<Transaction> tlst = tdao.retrieveRecords(r.getaNo());
			if(tlst.size()>0) {
				session.removeAttribute("tlst");
				session.setAttribute("tlst", tlst);
				response.sendRedirect("Transaction.jsp");
			}
			else {
				session.setAttribute("thflag", true);
				response.sendRedirect("Report.jsp");	
			}
		}
		else {
			session.setAttribute("f1", true);
			response.sendRedirect("Login.jsp");
		}
	}

}
