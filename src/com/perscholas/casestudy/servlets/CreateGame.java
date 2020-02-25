package com.perscholas.casestudy.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.casestudy.data.AccountsService;
import com.perscholas.casestudy.entities.Accounts;

/**
 * Servlet implementation class CreateGame
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/createGame" })
public class CreateGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountsService accountsService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateGame() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/game");
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
		if (request.getParameter("loggedIn") == null) { // guest
			session.setAttribute("loggedIn", false);
			ArrayList<Accounts> players = new ArrayList<>();
			accountsService = new AccountsService();
			int tempGuests = (Integer.parseInt(guests));
			if (tempGuests > 0) {
				players.add(getAccountHere("temp1@temp.temp"));
			}
			if (tempGuests > 1) {
				players.add(getAccountHere("temp2@temp.temp"));
			}
			if (tempGuests > 2) {
				players.add(getAccountHere("temp3@temp.temp"));
			}
			if (tempGuests > 3) {
				players.add(getAccountHere("temp4@temp.temp"));
			}
			session.setAttribute("players", (List<Accounts>)players);
		}
		// else (( account is logged in ))
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

	private Accounts getAccountHere(String email) {
		List<Accounts> results = accountsService.getAccountByEmail(email);
		return results.get(0);
	}
}
