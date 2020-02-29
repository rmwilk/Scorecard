package com.perscholas.casestudy.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.casestudy.entities.Holes;

/**
 * Servlet implementation class HintModalBuilder
 */
@WebServlet("/HintModalBuilder")
public class HintModalBuilder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HintModalBuilder() {
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
		session = request.getSession(true);

		//System.out.println("hole: " + request.getParameter("hole"));

//		String hintModalHtml = buildHintModal((int) request.getAttribute("holeHintClicked"));
//		session.setAttribute("thisHint", hintModalHtml);
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
	private String buildHintModal(int hole) {
		StringBuilder build = new StringBuilder("");
		build.append("<div class=\"modal fade\" id=\"hintModal\" tabindex=\"-1\"");
		build.append("role=\"dialog\" aria-labelledby=\"#hintModalTitle\"");
		build.append("aria-hidden=\"true\">");
		build.append("div class=\"modal-dialog modal-dialog-centered\" role=\"document\">");
		build.append("<div class=\"modal-content\">");
		build.append("<div class=\"modal-header\"><h2 class=\"modal-title\" id=\"hintModalTitle\">");
		build.append("Hole ");
		build.append(hole);
		build.append(" Hint</h2>");
		build.append("<button type=\"button\" class=\"close\" data-dismiss=\"modal\"");
		build.append("aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>");
		build.append("</div><div class=\"modal-body\"><div class=\"container\"");
		build.append(" style=\"text-align: center\">");

		List<Holes> thisHole = (List<Holes>) session.getAttribute("courseInfo");
		build.append(thisHole.get(hole - 1).getHint());

		build.append("</div></div><div class=\"modal-footer\">");
		build.append("<button type=\"button\" class=\"btn btn-secondary\" ");
		build.append("data-dismiss=\"modal\">Close</button></div></div></div></div>");

		return build.toString();
	}
}
