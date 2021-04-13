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
import it.objectmethod.model.Country;


@WebServlet("/CountryServlet")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nameInput");
		String continent = request.getParameter("continentInput");
		WorldDao countryDao = new WorldDaoImpl();
		List<Country> list = new ArrayList<>();
		String error = "Try again";
		
		if(name == null || continent == null) {
			request.setAttribute("noCountry", error);
		}else if(name.isBlank() && continent.isBlank()) {
			request.setAttribute("noCountry", error);
		}else {
			try {
				list = countryDao.getCountryByContinentName(name, continent);
				if(list.isEmpty()) {
					request.setAttribute("noCountry", error);
				}
				else {
					request.setAttribute("countryList", list);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		

		request.getRequestDispatcher("pages/country.jsp").forward(request, response);
		
	}


}
