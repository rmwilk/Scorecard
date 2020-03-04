package com.perscholas.casestudy.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
 * Servlet implementation class Stats
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/stats" })
public class Stats extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/* Copied to Every Servlet */
	private HttpSession session;
	private AccountsService accountsService;
	private HolesService holesService;
	private CoursesService coursesService;
	private GamesService gamesService;
	private GameScoresService gameScoresService;

	/* Some Session variables */
	private List<Accounts> accountInfo; // current players on this game

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Stats() {
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

		developStats(request);

		rd = getServletContext().getRequestDispatcher("/stats.jsp");
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

	private void developStats(HttpServletRequest request) {
		int totalGames;
		int totalAces;
//		Timestamp firstGame;
//		Timestamp lastGame;
		int bestA = WORST_SCORE;
		int worstA = BEST_SCORE;
		int averageA;
		int bestB = WORST_SCORE;
		int worstB = BEST_SCORE;
		int averageB;

		Accounts thisAccount = (Accounts) session.getAttribute("account");
		List<GameScores> allGames = gameScoresService.getAllGameScores();

		int gamesACounter = 0;
		int gamesBCounter = 0;
		int acesACounter = 0;
		int acesBCounter = 0;
		int allStrokes = 0;
		String commaAllStrokes;
		HashMap<Integer, Integer> scoresA = new HashMap<>();
		HashMap<Integer, Integer> scoresB = new HashMap<>();

		// Date earliest = Date.newinstance(1700, 1, 1);
		for (GameScores gs : allGames) {
			if (gs.getAccountId() == thisAccount.getId()) {
				if (gamesService.getGamesByID(gs.getGameId()).get(0).getCourseId() == 1) {
					gamesACounter++; // this gets divided into single games later
					allStrokes += gs.getScore();

					if (scoresA.containsKey(gs.getGameId()) == true) {
						int score = scoresA.get(gs.getGameId());
						score += gs.getScore();
						scoresA.put(gs.getGameId(), score);
					} else {
						scoresA.put(gs.getGameId(), gs.getScore());
						allStrokes += gs.getScore();
					}
					if (gs.getScore() == 1) {
						acesACounter++;
					}
				} else {
					gamesBCounter++; // this gets divided into single games later
					if (scoresB.containsKey(gs.getGameId()) == true) {
						int score = scoresB.get(gs.getGameId());
						score += gs.getScore();
						scoresB.put(gs.getGameId(), score);
						allStrokes++;
					} else {
						scoresB.put(gs.getGameId(), gs.getScore());
					}
					if (gs.getScore() == 1) {
						acesBCounter++;
					}
				}
			}
		}
		
		gamesACounter /= HOLES;
		gamesBCounter /= HOLES;
		totalGames = gamesACounter + gamesBCounter;
		totalAces = acesACounter + acesBCounter;

		// get best and worst scores for each course
		int allAScores = 0;
		for (Map.Entry<Integer, Integer> entry : scoresA.entrySet()) {
			int value = entry.getValue();
			allAScores += value;
			if (value > worstA) {
				worstA = value;
			}
			if (value < bestA) {
				bestA = value;
			}
		}
		int allBScores = 0;
		for (Map.Entry<Integer, Integer> entry : scoresB.entrySet()) {
			int value = entry.getValue();
			allBScores += value;
			if (value > worstB) {
				worstB = value;
			}
			if (value < bestB) {
				bestB = value;
			}
		}
		// if no games are played
		if (bestA == WORST_SCORE) {
			bestA = 0;
		}
		if (worstA == BEST_SCORE) {
			worstA = 0;
		}
		if (bestB == WORST_SCORE) {
			bestB = 0;
		}
		if (worstB == BEST_SCORE) {
			worstB = 0;
		}
		
		// get average scores for each course
		// catches divide by zero if no games were played
		try {
			averageA = allAScores / gamesACounter;
		} catch (ArithmeticException ae) {
			averageA = 0;
		}
		try {
			averageB = allBScores / gamesBCounter;
		} catch (ArithmeticException ae) {
			averageB = 0;
		}
		
		// insert commas for numbers over 1,000, etc.
		commaAllStrokes = NumberFormat.getNumberInstance(Locale.US).format(allStrokes);
		
		request.setAttribute("totalGames", totalGames);
		request.setAttribute("totalAces", totalAces);
		request.setAttribute("totalShots", commaAllStrokes);
		
//		request.setAttribute("firstGame", firstGame);
//		request.setAttribute("lastGame", lastGame);
		
		request.setAttribute("totalA", gamesACounter);
		request.setAttribute("acesA", acesACounter);
		request.setAttribute("bestA", bestA);
		request.setAttribute("worstA", worstA);
		request.setAttribute("averageA", averageA);
		
		request.setAttribute("totalB", gamesBCounter);		
		request.setAttribute("acesB", acesBCounter);
		request.setAttribute("bestB", bestB);
		request.setAttribute("worstB", worstB);
		request.setAttribute("averageB", averageB);
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
