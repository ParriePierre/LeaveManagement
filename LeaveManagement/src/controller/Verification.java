package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conges;

/**
 * Servlet implementation class Verification
 */
@WebServlet("/Verification")
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SessionManager sessionManager = new SessionManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(sessionManager.checkSessionWithRedirection(request, response)){
			RequestDispatcher dispatcher;
			dispatcher=request.getRequestDispatcher("/WEB-INF/demandeConge.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(sessionManager.checkSessionWithRedirection(request, response)){
			int day;
			String error = null;
			String success = null;
			Conges conges = Conges.instance();
			
			try{
				day = Integer.parseInt(request.getParameter("day"));
				
				if(day <= 0 || day >= 366){
					throw new NumberFormatException();
				}
				
				if(conges.verifierJour(day-1)){
					conges.poserJour(day-1);
					success = "Day " + day + " reserved.";
				}
				else{
					throw new Exception("Day is not available.");
				}
			}
			catch(NumberFormatException ex){
				error = "Invalid day";
			}
			catch(Exception e){
				error = e.getMessage();
			}
			
			if(error != null){
				request.setAttribute("Error", error);
			}
			else if(success != null){
				request.setAttribute("Success", success);
			}
			
			RequestDispatcher dispatcher;
			dispatcher=request.getRequestDispatcher("/WEB-INF/resultatDemande.jsp");
			dispatcher.forward(request, response);
		}
	}

}
