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
import com.perscholas.casestudy.entities.Holes;

/**
 * Servlet implementation class TrashScorecard
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/TrashScorecard"})
public class TrashScorecard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private AccountsService accountsService;
	private HolesService holesService;
	private CoursesService coursesService;
	private GamesService gamesService;
	private GameScoresService gameScoresService;
	/* Session variables */
	private String guests;
	private List<Holes> holeInfo; // used for hint query
	private List<Accounts> accountInfo; // current players on this game
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrashScorecard() {
        super();
		// TODO remove console log
		System.out.println(getClass().getName());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		initialize();
		session = request.getSession(true);
		guests = (String) session.getAttribute("guests");
		RequestDispatcher rd;
		boolean loggedIn = (boolean) session.getAttribute("loggedIn");
		if(loggedIn) {
			
			rd = getServletContext().getRequestDispatcher("/home");
			removeAllAttributes();
			
		}
		else {
			session.invalidate();
			rd = getServletContext().getRequestDispatcher("/index");
		}
		rd.forward(request, response);
		closeup();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void removeAllAttributes() {
		session.removeAttribute("guests");
		session.removeAttribute("course");
		session.removeAttribute("courseNumber");
		session.removeAttribute("players");
		session.removeAttribute("courseInfo");
		session.removeAttribute("gameId");
		session.removeAttribute("table");
		session.removeAttribute("allScores");
		
		StringBuilder tempString = new StringBuilder("");
		int counter = 1;
		for(Holes hole : holeInfo) {
			tempString.append("hint" + counter);
			session.removeAttribute(tempString.toString());
			tempString.delete(0, tempString.length());
			counter++;
		}
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
