package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.model.Beneficiary;
import bank.model.Register;
import bank.dao.BeneficiaryDao;
import bank.dao.BeneficiaryDaoImpl;
import bank.dao.RegisterDao;
import bank.dao.RegisterDaoImpl;
/**
 * Servlet implementation class AddbController
 */
@WebServlet("/AddbController")
public class AddbController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddbController() {
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
		RegisterDao bdao = new RegisterDaoImpl();
		BeneficiaryDao bendao = new BeneficiaryDaoImpl();

		
		
		List<Register> rlst = (List<Register>) session.getAttribute("udata");//Login Data From Session


		if(rlst != null) {
			System.out.println("Udata Found");
			List<Register> lst = bdao.retrieveRecord(Integer.parseInt(request.getParameter("aNo")));
			
			if(lst.size() > 0) {
				if(Integer.parseInt(request.getParameter("aNo")) == rlst.get(0).getaNo()) {
					session.setAttribute("sacc", true);
					response.sendRedirect("Addb.jsp"); //Flag To Check Beneficiary Acc No and User Acc No Are Not Same
				}
				else {
					System.out.println("Account number of User: "+lst.get(0).getaNo());
					System.out.println("Entered Data Validation Checked");
					List<Beneficiary> blst = new ArrayList<Beneficiary>();
					blst.add(new Beneficiary(rlst.get(0).getaNo(), Integer.toString(lst.get(0).getaNo()), lst.get(0).getcName(),lst.get(0).getmNo()));
					int i = bendao.CreateRecord(blst);
					if(i>0) {
						System.out.println("Record Created and Forwarded to Fund Controller");
						response.sendRedirect("FundController");
					}
					else {
						System.out.println("Record Not Created");
						session.setAttribute("bflag", true);
						response.sendRedirect("FundTransfer.jsp");
					}
				}	
			}
			else {
				session.setAttribute("accf", true);
				response.sendRedirect("Addb.jsp");
			}
		}
		else {
			session.setAttribute("f1", true);
			response.sendRedirect("Login.jsp");
		}		
	}

}
