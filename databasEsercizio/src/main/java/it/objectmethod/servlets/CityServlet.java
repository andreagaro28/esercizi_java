package it.objectmethod.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.dao.WorldDao;
import it.objectmethod.dao.impl.WorldDaoImpl;
import it.objectmethod.model.City;

@WebServlet("/cityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cityName = request.getParameter("cityInput");
		WorldDao cityDao = new WorldDaoImpl();
		City city = null;
		String error = "NO CITY FOUND";

		if(cityName == null || cityName.isBlank()) {
			request.setAttribute("noCity", error);
		}else {
			try {
				city = cityDao.getCityByName(cityName);
				request.setAttribute("city", city);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("pages/city.jsp").forward(request, response);
	}


}
