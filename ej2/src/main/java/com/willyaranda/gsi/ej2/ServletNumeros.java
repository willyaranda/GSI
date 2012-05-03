package com.willyaranda.gsi.ej2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletNumeros extends HttpServlet {

	private static final long serialVersionUID = 4590285235724118266L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = resp.getWriter();
	    out.write("hola");
	    resp.sendRedirect("jsp/jspRedirect.jsp");
		//super.doGet(req, resp);
	}
}
