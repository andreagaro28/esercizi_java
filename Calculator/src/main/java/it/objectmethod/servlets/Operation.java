package it.objectmethod.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/operation")
public class Operation extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Operation() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String operator = request.getParameter("opr");
		float firstNumber = 0;
		float secondNumber = 0;
		float result = 0;
		String error = "";
		boolean setResult = true;

		if(request.getParameter("in1").isEmpty() || request.getParameter("in2").isEmpty()) {
			error = "Inserisci entrambi i numeri";
			setResult = false;
		}
		else {
			try {
				firstNumber = Float.parseFloat(request.getParameter("in1"));
				secondNumber = Float.parseFloat(request.getParameter("in2"));
				setResult = true;
			} catch (Exception e) {
				error = "You can only insert numbers";
				setResult = false;
			}

			if(setResult) {
				switch(operator) {
				case "+":
					result = firstNumber + secondNumber;
					break;
				case "-":
					result = firstNumber - secondNumber;
					break;
				case "x":
					result = firstNumber * secondNumber;
					break;
				case "/":
					if(secondNumber == 0) {
						error = "Cannot divide by zero";
						setResult = false;
					}else
						result = firstNumber / secondNumber;
					break;
				}
			}


		}

		if(setResult) request.setAttribute("result", result);
		else request.setAttribute("error", error);


		request.getRequestDispatcher("pages/calculator.jsp").forward(request, response);

	}

}
