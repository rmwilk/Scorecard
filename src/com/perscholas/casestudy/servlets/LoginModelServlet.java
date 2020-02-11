package com.perscholas.casestudy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perscholas.casestudy.data.AccountsService;
import com.perscholas.casestudy.entities.Accounts;

/**
 * Servlet implementation class ModelServlet
 */
@WebServlet("/ModelServlet")
public class LoginModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("emailTB");
		String pass = request.getParameter("passwordTB");

		request.setAttribute("email", email);
		request.setAttribute("loggedIn", false);

		AccountsService as = new AccountsService();
		List<Accounts> accounts = as.getAccountByEmail(email);
		if (accounts.get(0).getEmail().equals(email) && accounts.get(0).getPassword().equals(pass)) {
			request.setAttribute("loggedIn", true);
		}

		request.setAttribute("account", accounts.get(0));
		as.close();
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
