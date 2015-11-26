package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.Employes;


/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	static String PAGE_HEADER = "<html><head><title>TP1 JEE</title><body>";

	static String PAGE_FOOTER = "</body></html>";
	
	private Employes employesList;
	private SessionManager sessionManager = new SessionManager();

	public Authentification() {
		super();
		employesList = new Employes();
	}
	
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(sessionManager.checkSession(request, response)){
			response.sendRedirect("Verification");
		}
		else{
			RequestDispatcher dispatcher;
			dispatcher=request.getRequestDispatcher("/WEB-INF/index.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String Login = request.getParameter("login");
	    String Password = request.getParameter("password");
	    
	    RequestDispatcher dispatcher;
	    
	    if(employesList.checkCredentials(Login, Password))
	    {	
    		Employee loggedEmployee = employesList.getEmployee(Login);
    		sessionManager.createSession(request, response, loggedEmployee);
    		response.sendRedirect("Verification");
	    } else {
	    	request.setAttribute("ErrorType", "Bad credentials.");
	    	dispatcher=request.getRequestDispatcher("/WEB-INF/error.jsp");
    		dispatcher.forward(request, response);
	    }
	}
}
