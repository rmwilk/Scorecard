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
	public void addGames(Games hole) {
		em.getTransaction().begin();
		em.persist(hole);
		em.getTransaction().commit();
	}
	
	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Games> getAllGamess() {
		
		Query query = em.createNamedQuery("GetAllGamess");
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
		Query query = em.createNamedQuery("GetGamesByID");
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
