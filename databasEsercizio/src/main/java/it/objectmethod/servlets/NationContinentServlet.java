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
import it.objectmethod.model.CountryContinent;


@WebServlet("/NationContinentServlet")
public class NationContinentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String continent = request.getParameter("continentName");
		System.out.println(continent);
		WorldDao continentDao = new WorldDaoImpl();
		List<CountryContinent> countryList = new ArrayList<>();
		try {
			countryList = continentDao.getCountryByContinentList(continent);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("countryList", countryList);
		request.getRequestDispatcher("pages/continent.jsp").forward(request, response);
	}


}
