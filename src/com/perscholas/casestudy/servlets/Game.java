package com.perscholas.casestudy.servlets;

import java.io.IOException;
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
import com.perscholas.casestudy.data.CoursesService;
import com.perscholas.casestudy.data.GameScoresService;
import com.perscholas.casestudy.data.GamesService;
import com.perscholas.casestudy.data.HolesService;

import com.perscholas.casestudy.entities.Accounts;
import com.perscholas.casestudy.entities.Holes;
import com.perscholas.casestudy.entities.Courses;
import com.perscholas.casestudy.entities.Games;
import com.perscholas.casestudy.entities.GameScores;

/**
 * Servlet implementation class Game
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/game" })
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* Copied to Every Servlet */
	private HttpSession session;
	private AccountsService accountsService;
	private HolesService holesService;
	private CoursesService coursesService;
	private GamesService gamesService;
	private GameScoresService gameScoresService;

	/* Session variables */
	private int guests;
	private List<Accounts> accountInfo; // current players on this game
	List<HashMap<Integer, String>> allScores;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Game() {
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
		initialize();
		session = request.getSession(true);
		RequestDispatcher rd;
				
		rd = getServletContext().getRequestDispatcher("/draw");
		rd.include(request, response);

		rd = getServletContext().getRequestDispatcher("/game.jsp");
		rd.forward(request, response);
		closeup();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 
	 */
	private void initialize() {
		accountsService = new AccountsService();
		holesService = new HolesService();
		coursesService = new CoursesService();
		gamesService = new GamesService();
		gameScoresService = new GameScoresService();
	}

	/**
	 * 
	 */
	private void closeup() {
		accountsService.close();
		holesService.close();
		coursesService.close();
		gamesService.close();
		gameScoresService.close();
	}
}
