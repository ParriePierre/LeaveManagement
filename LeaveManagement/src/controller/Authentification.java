package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Employee;
import data.Employes;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	static String PAGE_HEADER = "<html><head><title>TP1 JEE</title><body>";

	static String PAGE_FOOTER = "</body></html>";
	
	private Employes employesList;

	public Authentification() {
		super();
		employesList = new Employes();
	}
	
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter writer = response.getWriter();
	    writer.println(PAGE_HEADER);
	    
	    writer.println("<p>Send a login and a password</p>");
	    
	    writer.println(PAGE_FOOTER);
	    writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String Login = request.getParameter("login");
	    String Password = request.getParameter("password");
	    
	    RequestDispatcher dispatcher;
	    
	    if(Password != null)
	    {
	    	Boolean result = employesList.checkPassword(Login, Password);
	    	if(result)
	    	{
	    		dispatcher=getServletContext().getRequestDispatcher("/demandeConge.jsp");
	    		Employee loggedEmployee = employesList.getEmployee(Login);
	    		request.setAttribute("loggedEmployee", loggedEmployee);
				dispatcher.include(request, response);
	    	} else {
	    		dispatcher=getServletContext().getRequestDispatcher("/error.jsp");
	    		request.setAttribute("ErrorType", "Wrong Password.");
	    		dispatcher.include(request, response);
	    	}
	    } else {
	    	dispatcher=getServletContext().getRequestDispatcher("/error.jsp");
	    	request.setAttribute("ErrorType", "No credential.");
    		dispatcher.include(request, response);
	    }
	}
}
