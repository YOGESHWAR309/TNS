package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.BankDaoImpl;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int accNumber = Integer.parseInt(request.getParameter("accNumber"));
		BankDaoImpl bdao = new BankDaoImpl();
		int i = bdao.deleteRecord(accNumber);
		if(i>0) {
			pw.print("<a href='"+getServletContext().getContextPath()+"/Index.html'><button style='padding: 10px;' >Home</button></a>"); 
			pw.println("<div align='center' style='margin-top: -50px' ><h1>Record Deleted Successfully!!!</h1></div>");
		}
		else {
			pw.print("<a href='"+getServletContext().getContextPath()+"/Index.html'><button style='padding: 10px;' >Home</button></a>"); 
			pw.println("<div align='center' style='margin-top: -50px' ><h1>Record Deletion Failed!!!</h1></div>");
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
