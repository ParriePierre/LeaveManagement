package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Employee;

public class SessionManager {
	
	HttpSession session;
	Cookie[] cookies;
	
	public void createSession(HttpServletRequest request,HttpServletResponse response, Employee e){
		session = request.getSession();
		cookies = new Cookie[3];
		
		session.setMaxInactiveInterval(50);
		session.setAttribute("employee", e);
		
		cookies[0] = new Cookie("login", e.getLogin());
		cookies[1] = new Cookie("firstname", e.getFirstName());
		cookies[2] = new Cookie("lastname", e.getLastName());
		
		for(Cookie cookie : cookies){
			cookie.setMaxAge(345600);
			response.addCookie(cookie);
		}
	}
	
	public boolean checkSession(HttpServletRequest request, HttpServletResponse response){
		
		Employee e = null;
		String login = null, firstname = null, lastname = null;
		session = request.getSession();
		
		if(session != null){
			if(session.getAttribute("employee") != null){
				return true;
			}
		}
		
		cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if("login".equals(cookie.getName())){
					login = cookie.getValue();
				}
				if("firstname".equals(cookie.getName())){
					firstname = cookie.getValue();
				}
				else if("lastname".equals(cookie.getName())){
					lastname = cookie.getValue();
				}
			}
			
			if(login != null && firstname != null && lastname != null){
				e = new Employee(firstname,lastname,login);
				createSession(request,response,e);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean checkSessionWithRedirection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		if(checkSession(request,response))
			return true;
		
		request.setAttribute("ErrorType", "Not authentified.");
		
		RequestDispatcher dispatcher;
		dispatcher=request.getRequestDispatcher("/WEB-INF/error.jsp");
		dispatcher.forward(request, response);
		
		return false;
	}
	
	public void killSession(HttpServletRequest request, HttpServletResponse response){
		request.getSession().invalidate();
		
		cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}
}
