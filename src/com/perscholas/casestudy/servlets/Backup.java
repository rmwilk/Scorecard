package com.perscholas.casestudy.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(asyncSupported = true, urlPatterns = { "/backup" })
public class Backup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private AccountsService accountsService;
	private HolesService holesService;
	private CoursesService coursesService;
	private GamesService gamesService;
	private GameScoresService gameScoresService;

	/* Session variables */
	private int guests;
	private List<Accounts> accountInfo; // current players on this game

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Backup() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		String table = buildTable();
		session.setAttribute("table", table);

		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/game.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@SuppressWarnings("unchecked")
	private String buildTable() {
		/* StringBuilder holds html for output */
		StringBuilder html = new StringBuilder("");
		if ((boolean) session.getAttribute("loggedIn")) {
			accountInfo = getAccountInfo();
		} else {
			accountInfo = (List<Accounts>) session.getAttribute("players");
		}
		// Table Head
		html.append("<tr><th id=\"hole#\">#</th><th id=\"par\">Par</th><th id=\"p1name\" name=\"p1name\">P1</th>");
		if (guests > 1) {
			html.append("<th id=\"p2name\" name=\"p2name\">P2</th>");
		}
		if (guests > 2) {
			html.append("<th id=\"p3name\" name=\"p3name\">P3</th>");
		}
		if (guests > 3) {
			html.append("<th id=\"p4name\" name=\"p4name\">P4</th>");
		}
		html.append("<th>&nbsp;</th>");
		// Table Body
		
		for (int i = 1; i <= 18; i++) {
			String space = putSpace(i);
			html.append("<tr><td style=\"padding-left:2px; padding-right: 2px;\">Hole");
			html.append(space);
			html.append(i);
			html.append("</td><td id=\"hole");
			html.append(i);
			html.append("par\" name=\"hole");
			html.append(i);
			html.append("par\" class=\"bold\">");
			
			List<Holes> thisHole = (List<Holes>) session.getAttribute("courseInfo");
			html.append(thisHole.get(i - 1).getPar());
			
			// html.append("par");
			html.append("</td><td id=\"p1hole");
			html.append(i);
			html.append("\" name=\"p1hole");
			html.append(i);
			html.append("\" class=\"stronger\">-</td>");

			// element("game-table").innerHTML += printPlayersToTBody;
			if (guests > 1) {
				html.append("<td id=\"p2hole");
				html.append(i);
				html.append("\" name=\"p2hole");
				html.append(i);
				html.append("\" class=\"stronger\">-</td>");
			}
			if (guests > 2) {
				html.append("<td id=\"p3hole");
				html.append(i);
				html.append("\" name=\"p3hole");
				html.append(i);
				html.append("\" class=\"stronger\">-</td>");
			}
			if (guests > 3) {
				html.append("<td id=\"p4hole");
				html.append(i);
				html.append("\" name=\"p4hole");
				html.append(i);
				html.append("\" class=\"stronger\">-</td>");
			}
			
			//holeHintModals button
			// change button to submit and buildholehintmodal function to send to servlet
			html.append("<td><button type=\"button\" class=\"btn btn-secondary btn-sm\"	data-toggle=\"modal\"");
			html.append("data-target=\"#hintModal\" onclick=\""
					+ "setHoleHintClicked(");
			html.append(i);
			html.append("); ");
			
//			 html.append("buildHoleHintModal("); 
//			 html.append(i); 
//			 html.append("); ");
			 
			html.append("buildHoleHintModal('");
			html.append("Hinthererererere");
			html.append("'); ");
			
			html.append("\">");
			
			// holeScoreModals
			html.append("<i class=\"fas fa-question-circle\"></i></button><button type=\"button\"");
			html.append(" class=\"btn btn-primary btn-sm\" onclick=\"buildHoleScoreModal(");
			html.append(i);
			html.append("); fillScores(");
			html.append(i);
			html.append(");\" data-toggle=\"modal\" data-target=\"#holeScoreModal\" style=\"max-width:100%\">");
			html.append("<i class=\"fas fa-edit\"></i></button></td></tr>");
		}
		return html.toString();
	}

	

	@SuppressWarnings("unchecked")
	private List<Accounts> getAccountInfo() {
		return (List<Accounts>)session.getAttribute("players");
	}

	private String putSpace(int num) {
		if (num < 10) {
			return "&nbsp;&nbsp;";
		} else {
			return "";
		}
	}

	private void init(HttpServletRequest request) {
		accountsService = new AccountsService();
		holesService = new HolesService();
		coursesService = new CoursesService();
		gamesService = new GamesService();
		gameScoresService = new GameScoresService();
		session = request.getSession(true);
		guests = Integer.parseInt((String) session.getAttribute("guests"));
	}
	
	private void closeup() {
		accountsService.close();
		holesService.close();
		coursesService.close();
		gamesService.close();
		gameScoresService.close();
	}
}
