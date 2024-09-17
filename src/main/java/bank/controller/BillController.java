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
import bank.dao.*;
import bank.model.*;
/**
 * Servlet implementation class BillController
 */
@WebServlet("/BillController")
public class BillController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BillController() {
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
		List<Transaction> tlst = (List<Transaction>) session.getAttribute("bdata"); //Bill Data
		RegisterDao rdao = new RegisterDaoImpl(); //Database Interactions
		TransactionDao tdao = new TransactionDaoImpl();//Database Interactions
		session.removeAttribute("bdata");
		

		if(tlst!=null) { //To Check That bdata is Received Or Not
			Transaction t = tlst.get(0); //Transaction Data Received
			
			List<Register> rlst = rdao.retrieveRecord(t.getFaccNo());
			Register r = rlst.get(0); //User Data Received 

			rlst.clear();
			rlst = new ArrayList<Register>();//To Reuse rlst

			//float tamt = t.getAmount(); Amount User Want To Spend
			float abal = r.getaBal(); //Available Balance

			if(abal>t.getAmount()) { //To Check Sufficient Amount
				r.setaBal(abal-t.getAmount());
				//System.out.println(r.getaBal()+"   "+r.getaNo());
				rlst.add(0, r);

				int i = rdao.updateRecord(rlst);//Updating Record
				
				if(t.getService().equals("NEFT")) {//If Service is NEFT
					List<Register> rlst2 = rdao.retrieveRecord(Integer.parseInt(t.getTaccNo()));
					float accbal = rlst2.get(0).getaBal();
					rlst2.get(0).setaBal(accbal+t.getAmount());
					int neft = rdao.updateRecord(rlst2);

				}
				if(i>0) {

					System.out.println("Record Updated Successfully!!!");
					int j = tdao.createRecord(tlst); //Transaction Record Creation
					int tId = tdao.retriveId(t.getFaccNo(), t.getTaccNo());
					t.setId(tId);//Transaction Id Set From Database
					if(j>0) {
						//	System.out.println("Transaction Record Created SuccessFully!!!");
						BillModel bm = new BillModel(r, t);
						session.setAttribute("pdata", bm);

						if(t.getService().equals("Recharge")) {//Recharge Bill
							System.out.println("Bill Printed SuccessFully!!!");
							response.sendRedirect("RBill.jsp");

						}
						else { //Fund Transfer Bill	
							System.out.println("NEFT Data Forwarded!!!");
							response.sendRedirect("FBill.jsp");
						}
					}
					else {
						//System.out.println("Creation Of Transaction Recored Failed!!!");
						//Amount Deducted But Trasaction Recored Not Stored
						session.setAttribute("s", true);
						response.sendRedirect("Profile.jsp");
					}
				}
				else {
					//System.out.println("Record Updation Failed!!");
					//Amount Not Deducted
					session.setAttribute("s", true);
					response.sendRedirect("Profile.jsp");
				}
			}
			else {
				//System.out.println("Insufficient Amount");
				session.setAttribute("bal", true);
				response.sendRedirect("Profile.jsp");
			}
		}
		else {
			// User Data Not Received From Session Need To Start From Login Page
			session.setAttribute("f1", true);
			response.sendRedirect("Login.jsp");
		}
	}

}
