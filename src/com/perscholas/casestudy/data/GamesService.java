/**
 * 
 */
package com.perscholas.casestudy.data;

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
		query.setParameter("holeID", id);
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
