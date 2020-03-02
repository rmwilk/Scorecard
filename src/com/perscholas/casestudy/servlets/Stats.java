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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		initialize();
		session = request.getSession(true);
		RequestDispatcher rd;
		
		developStats(request);
		
		rd = getServletContext().getRequestDispatcher("/stats.jsp");
		rd.forward(request, response);
		closeup();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void developStats(HttpServletRequest request) {
		int totalGames;
		int totalAces;
		Timestamp firstGame;
		Timestamp lastGame;
		
		Accounts thisAccount = (Accounts)session.getAttribute("account");
		List <GameScores> allGames = gameScoresService.getAllGameScoress();
		
		int gameCounter = 0;
		int acesCounter = 0;
		//Date earliest =  Date.newinstance(1700, 1, 1);
		for(GameScores gs : allGames) {
			if(gs.getAccountId() == thisAccount.getId()) {
				gameCounter++;
				if(gs.getScore() == 1) {
					acesCounter++;
				}
			}
		}
		
		gameCounter = gameCounter / 18;
		totalGames = gameCounter;
		
		totalAces = acesCounter;
		
		
		request.setAttribute("totalGames", totalGames);
		request.setAttribute("totalAces", totalAces);
//		request.setAttribute("firstGame", firstGame);
//		request.setAttribute("lastGame", lastGame);
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
