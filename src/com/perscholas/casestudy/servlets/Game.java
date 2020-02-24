package com.perscholas.casestudy.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Game
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/game" })
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Game() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/game.jsp");
		HttpSession session = request.getSession(true);

		String guests = request.getParameter("guests");
		String course = request.getParameter("courses");
		String selectedCourse;
		if (course.equals("A")) {
			selectedCourse = "A";
		} else {
			selectedCourse = "B";
		}

		session.setAttribute("guests", guests);
		session.setAttribute("course", selectedCourse);

		if (request.getParameter("loggedIn") == null) {
			session.setAttribute("loggedIn", false);
		}
		HashMap scorecard;
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
