/**
 * 
 */
package com.perscholas.casestudy.drivers;

import java.util.List;

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
 * @author rwilk
 *
 */
public class ScorecardDriver {
	private AccountsService accountsService;
	private HolesService holesService;
	private CoursesService coursesService;
	private GamesService gamesService;
	private GameScoresService gameScoresService;

	private ScorecardDriver() {
		accountsService = new AccountsService();
		holesService = new HolesService();
		coursesService = new CoursesService();
		gamesService = new GamesService();
		gameScoresService = new GameScoresService();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScorecardDriver sd = new ScorecardDriver();
		sd.run();
		sd.closeup();
	}

	private void run() {
		List<Holes> holesResults;
		/*
		int id = 1;
		holesResults = holesService.getHoleByID(id);
		System.out.println(holesResults);
		holesResults = holesService.getAllHoles();
		for (Holes hole : holesResults) {
			System.out.println(hole.getHint());
		}
		*/
		
		// prints a hint
		int course = 1;
		int number = 5;
		holesResults = holesService.getHoleByCourseAndNumber(course, number);

		System.out.println("Course " + getCourseName(holesResults.get(0).getCourseId()) +
			" Hole " + holesResults.get(0).getNumber() + " Hint: " + holesResults.get(0).getHint());
	}
	
	private String getCourseName(int courseNumber) {
		if(courseNumber == 1) {
			return "A";
		}
		// else
		return "B";
	}
	
	private void closeup() {
		accountsService.close();
		holesService.close();
		coursesService.close();
		gamesService.close();
		gameScoresService.close();
	}
}
