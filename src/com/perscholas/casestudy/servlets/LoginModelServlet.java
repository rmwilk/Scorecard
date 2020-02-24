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
@WebServlet(asyncSupported = true, urlPatterns = { "/doLogin" })
public class LoginModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public LoginModelServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("emailTB");
		String pass = request.getParameter("passwordTB");
		
		System.out.println(email);
		
		request.setAttribute("email", email);
		request.setAttribute("loggedIn", false);

		AccountsService as = new AccountsService();
		List<Accounts> accounts = as.getAccountByEmail(email.toLowerCase());
		Accounts goodAccount = null;
		for (Accounts ac : accounts) {
			System.out.println(ac);
			if (ac.getPassword().equals(pass)) {
				goodAccount = ac;
				request.setAttribute("loggedIn", true);
				break;
			}
		}

		request.setAttribute("account", goodAccount);
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
