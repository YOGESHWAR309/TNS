package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.BankDaoImpl;
import bank.model.Register;

/**
 * Servlet implementation class DisplayAllController
 */
@WebServlet("/DisplayAllController")
public class DisplayAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		List<Register> lst = new LinkedList<Register>();
		BankDaoImpl bdao = new BankDaoImpl();
		lst = bdao.displayAll();
		if(lst.size() == 0) {
			response.sendRedirect("Error.html");
		}
		else {
			pw.print("<a href='"+getServletContext().getContextPath()+"/Index.html'><button style='padding: 10px;' >Home</button></a>"); 
			pw.println("<div align='center' style='margin-top: -50px;' ><h1 align='center' style='display: inline-flex' > Table </h1></div>");
			
			pw.println("<table align='center' border='4px' style='border-collapse: collapse;'>");
			pw.println("<tr><td style='padding: 10px' > Account Number </td>");
			pw.println("<td style='padding: 10px' > Customer Name </td>");
			pw.println("<td style='padding: 10px' > Account Balance </td></tr>");
			
			for(Register reg:lst) {
				pw.println("<tr><td style='padding: 10px' >"+ reg.getAccNumber() +"</td>");
				pw.println("<td style='padding: 10px' > "+ reg.getCustName() +" </td>");
				pw.println("<td style='padding: 10px' > "+ reg.getAccBal() +" </td></tr>");
			}
			pw.println("</table>");
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
