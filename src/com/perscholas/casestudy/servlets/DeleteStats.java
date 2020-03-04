package com.perscholas.casestudy.servlets;

import java.io.IOException;
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
import com.perscholas.casestudy.entities.GameScores;

import static com.perscholas.casestudy.data.Finals.*;


/**
 * Servlet implementation class DeleteStats
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/deleteStats" })
public class DeleteStats extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/* Copied to Every Servlet */
	private HttpSession session;
	private AccountsService accountsService;
	private HolesService holesService;
	private CoursesService coursesService;
	private GamesService gamesService;
	private GameScoresService gameScoresService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteStats() {
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

		deleteUserStats();

		rd = getServletContext().getRequestDispatcher("/stats");
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

	private void deleteUserStats() {
		Accounts thisAccount = (Accounts)session.getAttribute(ACCOUNT);
		List<GameScores> allGames = gameScoresService.getAllGameScores();
		
		for(GameScores game : allGames) {
			if(game.getAccountId() == thisAccount.getId()) {
				gameScoresService.deleteGameScores(game);
			}
		}
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
