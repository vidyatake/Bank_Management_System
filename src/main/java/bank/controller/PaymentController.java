package bank.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.model.Beneficiary;
import bank.model.Register;
import bank.model.Transaction;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentController() {
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
		List<Transaction> lstt = new ArrayList<Transaction>();
		List<Register> rlst = (List<Register>) session.getAttribute("udata");
		if(rlst != null) {
			Register r = rlst.get(0);	
			lstt.add(new Transaction(0, r.getaNo(), request.getParameter("select"), "date","NEFT",Float.parseFloat(request.getParameter("Amount"))));
			session.setAttribute("bdata", lstt);
			response.sendRedirect("BillController");
		}
		else {
			session.setAttribute("f1", true);
			response.sendRedirect("Login.jsp");
		}
		
	}

}
