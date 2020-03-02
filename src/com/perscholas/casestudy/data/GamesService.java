/**
 * 
 */
package com.perscholas.casestudy.data;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Query;

import com.perscholas.casestudy.entities.Games;

/**
 * @author rwilk
 *
 */
public class GamesService extends AbstractService {

	/**
	 * 
	 */
	public GamesService() {
		super();
	}

	/**
	 * @param hole
	 */
	public int addGames(Games game) {
		em.getTransaction().begin();
		em.persist(game);
		em.getTransaction().commit();
		return game.getId();
	}
	
	public void addEndDate(Games game, Timestamp endDate) {
		em.getTransaction().begin();
		game.setEndDate(endDate);
		em.getTransaction().commit();
	}
	
	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Games> getAllGames() {
		
		Query query = em.createNamedQuery("GetAllGames");
		List<Games> games = query.getResultList();
		
		return games;
	}
	
	/**
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Games> getGamesByID(Integer id) {
		List <Games> games;
		Query query = em.createNamedQuery("GetGameByID");
		query.setParameter("gameId", id);
		games = query.getResultList();
		
		return games;
	}
	
	/**
	 * 
	 */
	public void close() {
		cleanup();
	}
}
