/**
 * 
 */
package com.perscholas.casestudy.drivers;

import com.perscholas.casestudy.data.AccountsService;
import com.perscholas.casestudy.data.CoursesService;
import com.perscholas.casestudy.data.GameScoresService;
import com.perscholas.casestudy.data.GamesService;
import com.perscholas.casestudy.data.HolesService;

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
		// TODO do things
	}
	
	private void closeup() {
		accountsService.close();
		holesService.close();
		coursesService.close();
		gamesService.close();
		gameScoresService.close();
	}
}
