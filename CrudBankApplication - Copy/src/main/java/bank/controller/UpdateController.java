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

import bank.dao.BankDaoImpl;
import bank.model.Register;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		List<Register> lst = new ArrayList<Register>();
		List<Register> lst1 = new ArrayList<Register>();
		BankDaoImpl bdao = new BankDaoImpl();
		
		int accNum = Integer.parseInt(request.getParameter("accNumber"));
		float accBal =  Float.parseFloat(request.getParameter("accBal"));
		
		lst.add(new Register(accNum, null, accBal, null));
		int i = bdao.updateRecord(lst);
		if(i > 0) {
			lst1 = bdao.retriveRecord(accNum);
			Register reg = lst1.get(0);
			pw.print("<a href='"+getServletContext().getContextPath()+"/Index.html'><button style='padding: 10px;' >Home</button></a>"); 
			pw.println("<div align='center' style='margin-top: -50px' ><h1>Record Updated Successfully!!!</h1></div>");
			pw.println("<table align='center' border='4px' style='border-collapse: collapse;'>");
			pw.println("<tr><td style='padding: 10px' > Account Number </td>");
			pw.println("<td style='padding: 10px' > Customer Name </td>");
			pw.println("<td style='padding: 10px' > Account Balance </td></tr>");	
			pw.println("<tr><td style='padding: 10px' >"+ reg.getAccNumber() +"</td>");
			pw.println("<td style='padding: 10px' > "+ reg.getCustName() +" </td>");
			pw.println("<td style='padding: 10px' > "+ reg.getAccBal() +" </td></tr>");
			pw.println("</table>");
		}
		else {
			pw.print("<a href='"+getServletContext().getContextPath()+"/Index.html'><button style='padding: 10px;' >Home</button></a>"); 
			pw.println("<div align='center' style='margin-top: -50px' ><h1>Record Not Found!!!</h1></div>");	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
