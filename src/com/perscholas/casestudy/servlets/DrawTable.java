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

/**
 * Servlet implementation class RedrawTable
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/draw" })
public class DrawTable extends HttpServlet {
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
	public DrawTable() {
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
		guests = Integer.parseInt((String) session.getAttribute("guests"));

		
		String table = drawTable();
		session.setAttribute("table", table);
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
	private String drawTable() {
		/* StringBuilder holds html for output */
		StringBuilder html = new StringBuilder("");
		boolean loggedIn = (boolean) session.getAttribute("loggedIn");
		if (loggedIn) {
			accountInfo = getAccountInfo();
		} else {
			accountInfo = (List<Accounts>) session.getAttribute("players");
		}
		// Table Head
		html.append("<tr><th id=\"hole#\">#</th><th id=\"par\">Par</th>");
		html.append("<th id=\"p1name\" name=\"p1name\">");
		
		html.append(accountInfo.get(0).getNickname());
		
		html.append("</th>");
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
		List<Holes> thisHole = (List<Holes>) session.getAttribute("courseInfo");
		allScores = (List<HashMap<Integer, String>>) session.getAttribute("allScores");

		for (int i = 1; i <= 18; i++) {
			html.append("<tr><td style=\"padding-left:2px; padding-right: 2px;\">");

			html.append(thisHole.get(i - 1).getName());

			html.append("</td><td id=\"hole");
			html.append(i);
			html.append("par\" name=\"hole");
			html.append(i);
			html.append("par\" class=\"bold\">");

			html.append(thisHole.get(i - 1).getPar());

			// html.append("par");
			html.append("</td><td id=\"p1hole");
			html.append(i);
			html.append("\" name=\"p1hole");
			html.append(i);
			html.append("\" class=\"stronger\">");

			// put player score here
			html.append(allScores.get(0).get(i));

			html.append("</td>");

			// element("game-table").innerHTML += printPlayersToTBody;
			if (guests > 1) {
				html.append("<td id=\"p2hole");
				html.append(i);
				html.append("\" name=\"p2hole");
				html.append(i);
				html.append("\" class=\"stronger\">");

				// put player score here
				html.append(allScores.get(1).get(i));

				html.append("</td>");
			}
			if (guests > 2) {
				html.append("<td id=\"p3hole");
				html.append(i);
				html.append("\" name=\"p3hole");
				html.append(i);
				html.append("\" class=\"stronger\">");

				// put player score here
				html.append(allScores.get(2).get(i));

				html.append("</td>");
			}
			if (guests > 3) {
				html.append("<td id=\"p4hole");
				html.append(i);
				html.append("\" name=\"p4hole");
				html.append(i);
				html.append("\" class=\"stronger\">");

				// put player score here
				html.append(allScores.get(3).get(i));

				html.append("</td>");
			}

			// holeHintModals button
			html.append("<td><button type=\"button\" class=\"btn btn-secondary btn-sm\"	data-toggle=\"modal\"");
			html.append("data-target=\"#hintModal");
			html.append(i);
			html.append("\"");
			html.append("onclick=\"");

			html.append("ajaxHint(");
			html.append(i);
			html.append("); ");

			html.append("servletPostHint(");
			html.append(i);
			html.append(")\"");

//			html.append("buildHoleHintModal(");
//			html.append(i);
//			html.append("); ");

			html.append(">");

			// holeScoreModals
			html.append("<i class=\"fas fa-question-circle\"></i></button><button type=\"button\"");
			html.append(" class=\"btn btn-primary btn-sm\"");
			html.append("onclick=\"");

			html.append("buildHoleScoreModal(");
			html.append(i);
			html.append("); fillScores(");
			html.append(i);
			html.append("); forceSubmit()");
//			html.append()
			html.append("\" ");

			html.append("data-toggle=\"modal\" data-target=\"#holeScoreModal\" style=\"max-width:100%\">");
			html.append("<i class=\"fas fa-edit\"></i></button></td></tr>");
		}
		return html.toString();
	}

	@SuppressWarnings("unchecked")
	private List<Accounts> getAccountInfo() {
		return (List<Accounts>) session.getAttribute("players");
	}

	private String putSpace(int num) {
		if (num < 10) {
			return "&nbsp;&nbsp;";
		} else {
			return "";
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
