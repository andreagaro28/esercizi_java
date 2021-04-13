package it.objectmethod.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.dao.WorldDao;
import it.objectmethod.dao.impl.WorldDaoImpl;


@WebServlet("/ContinentServlet")
public class ContinentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> continentList = new ArrayList<>();
		WorldDao continentDao = new WorldDaoImpl();
		try {
			continentList = continentDao.getContinent();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("continentList", continentList);
		request.getRequestDispatcher("pages/continent.jsp").forward(request, response);
	}

}
