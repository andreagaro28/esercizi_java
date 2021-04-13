package it.objectmethod.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("inputName");
		HttpSession session = request.getSession();
		if(userName == null || userName.isBlank()) {
			userName = "Insert your name";
			request.setAttribute("noName", userName);
			request.getRequestDispatcher("/pages/home.jsp").forward(request, response);	
		}
		else {
			session.setAttribute("userName", userName);
			request.getRequestDispatcher("/pages/city.jsp").forward(request, response);	
		}
	}
}
