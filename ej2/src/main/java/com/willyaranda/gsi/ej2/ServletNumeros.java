package com.willyaranda.gsi.ej2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletNumeros extends HttpServlet {

	private static final long serialVersionUID = 4590285235724118266L;
	private ServletContext sc;
	
	public void init(ServletConfig config) throws ServletException {
		sc = config.getServletContext();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int type = Integer.parseInt(req.getParameter("type"));
		int num1 = 0;
		int num2 = 0;
		try {
			num1 = Integer.parseInt(req.getParameter("numero1"));
			num2 = Integer.parseInt(req.getParameter("numero2"));
		} catch (Exception e) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html; charset=UTF-8");
			out.write("Error en la conversión de los números");
		}
		if (CheckSuma.isCorrect(num1, num2)) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html; charset=UTF-8");
			out.write("¡Enhorabuena! Has acertado");
		} else {
			switch (type) {
			case 1:
				//sendRedirect
				resp.sendRedirect("jsp/jspRedirect.jsp");
				break;
			case 2:
				//forward
				RequestDispatcher dispatcher = sc.getRequestDispatcher("/jsp/jspRedirect.jsp");
				dispatcher.forward(req, resp);
				break;
			case 3:
				//Include
				RequestDispatcher dispatcher2 = sc.getRequestDispatcher("/jsp/jspRedirect.jsp");
				dispatcher2.include(req, resp);
				break;
			default:
				resp.setStatus(500);
				break;
			}
		}
	}
}
