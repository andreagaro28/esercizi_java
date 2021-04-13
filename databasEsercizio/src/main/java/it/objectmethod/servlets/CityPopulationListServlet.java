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
import it.objectmethod.model.City;


@WebServlet("/CityPopulationListServlet")
public class CityPopulationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countryCode = request.getParameter("countryCode");
		List<City> cityList = new ArrayList<>();
		WorldDao cityDao = new WorldDaoImpl();
		
		try {
			cityList = cityDao.getCityByCode(countryCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("cityList", cityList);
		request.getRequestDispatcher("pages/continent.jsp").forward(request, response);
	}

}
