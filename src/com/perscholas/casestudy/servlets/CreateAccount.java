package com.perscholas.casestudy.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perscholas.casestudy.data.AccountsService;
import com.perscholas.casestudy.entities.Accounts;

/**
 * Servlet implementation class Create
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/create" })
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAccount() {
		super();
		// TODO remove console log
		System.out.println(getClass().getName());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountsService as = new AccountsService();
		String name = request.getParameter("nameTB");
		String email = request.getParameter("emailTB");
		String password = request.getParameter("passwordTB");
		boolean isValid = false;
		
		Accounts newUser = new Accounts(email, password, name);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		isValid = isValidAccount(newUser);
				
		if (isValid) {
			try {
			as.addAccount(newUser);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			// error page
			rd = getServletContext().getRequestDispatcher("/signup.jsp");
			request.setAttribute("isValid", isValid);
		}
		
		rd.forward(request, response);
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

	private boolean isValidAccount(Accounts acc) {

		// TODO validation code for new account
		return true;
	}
}
