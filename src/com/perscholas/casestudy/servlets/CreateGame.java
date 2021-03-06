package com.perscholas.casestudy.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import com.perscholas.casestudy.entities.Courses;
import com.perscholas.casestudy.entities.Games;
import com.perscholas.casestudy.entities.Holes;

/**
 * Servlet implementation class CreateGame
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/createGame" })
public class CreateGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountsService accountsService;
	private HolesService holesService;
	private CoursesService coursesService;
	private HttpSession session;
	private GamesService gamesService;
	private GameScoresService gameScoresService;

	/* Session variables */
	private String guests;
	private List<Holes> holeInfo; // used for hint query
	private List<Accounts> accountInfo; // current players on this game
	ArrayList<HashMap<Integer, String>> allScores;

	/**
	 * @throws ServletException
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateGame() throws ServletException {
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

		guests = (String) request.getParameter("guests");
		String course = request.getParameter("course");

		String selectedCourse;
		int courseNumber;
		if (course.equals("A")) {
			selectedCourse = "A";
			courseNumber = 1;
		} else {
			selectedCourse = "B";
			courseNumber = 2;
		}

		session.setAttribute("guests", guests);
		session.setAttribute("course", selectedCourse);
		session.setAttribute("courseNumber", courseNumber);

		ArrayList<Accounts> players = new ArrayList<>();
		// HashMaps for session scores <Hole, Score>
		HashMap<Integer, String> p1Scores = new HashMap<>(18);
		HashMap<Integer, String> p2Scores = new HashMap<>(18);
		HashMap<Integer, String> p3Scores = new HashMap<>(18);
		HashMap<Integer, String> p4Scores = new HashMap<>(18);
		allScores = new ArrayList<>();

		int tempGuests = (Integer.parseInt(guests));
		final String loggedIn = "loggedIn";
		boolean isLoggedIn; 
		// to catch null attribute
		try {
			isLoggedIn = (boolean)session.getAttribute("loggedIn");
		}
		catch(Exception e) {
			session.setAttribute(loggedIn, false);
		}
		
		if ((boolean)session.getAttribute(loggedIn) == false) {
			// guest game

			players.add(getAccountHere("temp1@temp.temp"));
			p1Scores = new HashMap<>();
			for (Integer i = 1; i <= 18; i++) {
				p1Scores.put(i, "-");
			}
			allScores.add(p1Scores);

		} else {
			// (( account is logged in ))
			session.setAttribute(loggedIn, true);

			Accounts player1 = (Accounts) session.getAttribute("account");
			players.add(getAccountHere(player1.getEmail()));
			p1Scores = new HashMap<>();
			for (Integer i = 1; i <= 18; i++) {
				p1Scores.put(i, "-");
			}
			allScores.add(p1Scores);
		}

		if (tempGuests > 1) {
			players.add(getAccountHere("temp2@temp.temp"));
			p2Scores = new HashMap<>();
			for (Integer i = 1; i <= 18; i++) {
				p2Scores.put(i, "-");
			}
			allScores.add(p2Scores);
		}
		if (tempGuests > 2) {
			players.add(getAccountHere("temp3@temp.temp"));
			p3Scores = new HashMap<>();
			for (Integer i = 1; i <= 18; i++) {
				p3Scores.put(i, "-");
			}
			allScores.add(p3Scores);
		}
		if (tempGuests > 3) {
			players.add(getAccountHere("temp4@temp.temp"));
			p4Scores = new HashMap<>();
			for (Integer i = 1; i <= 18; i++) {
				p4Scores.put(i, "-");
			}
			allScores.add(p4Scores);
		}
		allScores.trimToSize();

		session.setAttribute("players", players);
		session.setAttribute("allScores", allScores);
		
		// session course / hole info for hints
		holeInfo = getHoleInfo(courseNumber);
		session.setAttribute("courseInfo", holeInfo);


		/* Create the game in games table */
		Date date = new Date();
		List<Holes> currentCourse = holesService.getAllHolesByCourseNumber(courseNumber);
		Games currentGame = new Games(currentCourse.get(0).getId(), new Timestamp(date.getTime()));
		int gameId = gamesService.addGames(currentGame); // add to game to games table
		session.setAttribute("gameId", gameId);
		StringBuilder tempString = new StringBuilder("");
		int counter = 1;
		
		for (Holes hole : holeInfo) {
			tempString.append("hint" + counter);
			session.setAttribute(tempString.toString(), hole.getHint());
			tempString.delete(0, tempString.length());
			counter++;
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/game");
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

	private Accounts getAccountHere(String email) {
		List<Accounts> results = accountsService.getAccountByEmail(email);
		return results.get(0);
	}

	private List<Holes> getHoleInfo(int courseId) {
		return holesService.joinHolesAndCoursesByCourseId(courseId);
	}

	private void initialize() {
		accountsService = new AccountsService();
		holesService = new HolesService();
		coursesService = new CoursesService();
		gamesService = new GamesService();
		gameScoresService = new GameScoresService();
	}

	private void closeup() {
		accountsService.close();
		holesService.close();
		coursesService.close();
		gamesService.close();
		gameScoresService.close();
	}
}