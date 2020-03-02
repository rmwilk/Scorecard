package com.perscholas.casestudy.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
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
import com.perscholas.casestudy.entities.GameScores;
import com.perscholas.casestudy.entities.Games;

/**
 * Servlet implementation class SubmitScorecard
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/submitScorecard" })
public class SubmitScorecard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/* Copied to Every Servlet */
	private HttpSession session;
	private AccountsService accountsService;
	private HolesService holesService;
	private CoursesService coursesService;
	private GamesService gamesService;
	private GameScoresService gameScoresService;

	/* Session variables */
	private String guests;
	private List<Accounts> accountInfo; // current players on this game
	List<HashMap<Integer, String>> allScores;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitScorecard() {
		super();
		// TODO remove console log
		System.out.println(getClass().getName());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initialize();
		session = request.getSession(true);
		guests = (String) session.getAttribute("guests");
		RequestDispatcher rd;
		allScores = (List<HashMap<Integer, String>>)session.getAttribute("allScores");
		session = request.getSession(false);
		boolean loggedIn = (boolean) session.getAttribute("loggedIn");

		if (!loggedIn) {
			rd = getServletContext().getRequestDispatcher("/TrashScorecard");
			rd.forward(request, response);
		} else {
			processScorecard();
			rd = getServletContext().getRequestDispatcher("/home");
			rd.forward(request, response);
		}

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

	private void processScorecard() {
		Accounts mainAccount = (Accounts) session.getAttribute("account");
		int accountId = mainAccount.getId();
		int courseId = (int) session.getAttribute("courseNumber");
		int gameId = (int) session.getAttribute("gameId");
		GameScores thisHole;
		int holeId;

		Date date = new Date();
		Games game = gamesService.getGamesByID(gameId).get(0);
		gamesService.addEndDate(game, new Timestamp(date.getTime()));
		int score;
		for (int hole = 1; hole <= 18; hole++) {
			if (courseId == 2) {
				holeId = hole + 18;
			} else {
				holeId = hole;
			}
			try {
				// the user might submit a scorecard that is not completed
				score = Integer.parseInt(allScores.get(0).get(hole));
			} catch (NumberFormatException nfe) {
				score = 6;
			} catch(Exception e) {
				e.printStackTrace();
				score = 6;
			}
			thisHole = new GameScores(gameId, accountId, holeId, score);
			gameScoresService.addGameScores(thisHole);
		}

	}

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
