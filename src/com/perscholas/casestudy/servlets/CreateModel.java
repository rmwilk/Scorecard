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
@WebServlet("/create")
public class CreateModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateModel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountsService as = new AccountsService();
		String name = request.getParameter("nameTB");
		String email = request.getParameter("emailTB");
		String password = request.getParameter("passwordTB");
		
		Accounts newUser = new Accounts(name,email,password);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/index.jsp");; 
		if(isValidAccount(newUser)) {
			as.addAccount(newUser);
		}
		else {
			// error page
			rd = getServletContext().getRequestDispatcher("/jsp/signup.jsp");
		}
		as.close();
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean isValidAccount(Accounts acc) {
		
		// TODO validation code for new account
		return true;
	}
}
