package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.model.*;
import bank.dao.*;

/**
 * Servlet implementation class FundController
 */
@WebServlet("/FundController")
public class FundController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundController() {
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
		BeneficiaryDao bedo = new BeneficiaryDaoImpl();	
		List<Beneficiary> blst = null;
		List<Register> rlst = (List<Register>) session.getAttribute("udata");
		
		if(rlst != null) { //ok	
			blst = bedo.retriveRecord(rlst.get(0).getaNo());
			if(blst != null) {
				session.setAttribute("bedata", blst);
				response.sendRedirect("FundTransfer.jsp");
			}
			else {
				
				response.sendRedirect("Addb.jsp");//No Beneficiary is Currently Added
			}
		}
		else {
			session.setAttribute("f1", true);
			response.sendRedirect("Login.jsp");
		}
	}

}
