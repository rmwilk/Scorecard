package com.perscholas.casestudy.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowDeleteStats
 */
@WebServlet("/delete")
public class ShowDeleteStats extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDeleteStats() {
        super();
		// TODO remove console log
		System.out.println(getClass().getName());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession(true);
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher("/deletingStats.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
