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

import bank.dao.BankDao;
import bank.dao.BankDaoImpl;
import bank.model.Register;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Register reg = new Register();
		Register reg1 = new Register();
		reg.setAccNumber(Integer.parseInt(request.getParameter("accNumber")));
		reg.setPassWord(request.getParameter("pass"));
		
		List<Register> lst = new ArrayList<Register>();
		BankDaoImpl bdao = new BankDaoImpl();		
		lst = bdao.retriveRecord(reg.getAccNumber());
		if(lst.size() == 0) {
			pw.print("<a href='"+getServletContext().getContextPath()+"/Index.html'><button style='padding: 10px;' >Home</button></a>"); 
			pw.println("<div align='center' style='margin-top: -50px' ><h1>Invalid Account Number Entered!!!</h1></div>");	
		}
		else {
			reg1 = lst.get(0);
			if(reg1.getPassWord().equals(reg.getPassWord())) {
				response.sendRedirect("Index.html");
			}
			else {
				pw.print("<a href='"+getServletContext().getContextPath()+"/Index.html'><button style='padding: 10px;' >Home</button></a>"); 
				pw.println("<div align='center' style='margin-top: -50px' ><h1>Invalid Password Entered!!!</h1></div>");	
			}
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
