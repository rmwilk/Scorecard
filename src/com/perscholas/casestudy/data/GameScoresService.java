/**
 * 
 */
package com.perscholas.casestudy.data;

import java.util.List;

import javax.persistence.Query;

import com.perscholas.casestudy.entities.GameScores;

/**
 * @author rwilk
 *
 */
public class GameScoresService extends AbstractService {

	/**
	 * 
	 */
	public GameScoresService() {
		super();
	}

	/**
	 * @param hole
	 */
	public void addGameScores(GameScores hole) {
		em.getTransaction().begin();
		em.persist(hole);
		em.getTransaction().commit();
	}
	
	/**
	 * @param hole
	 */
	public void deleteGameScores(GameScores hole) {
		em.getTransaction().begin();
		em.remove(hole);
		em.getTransaction().commit();
	}
	
	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GameScores> getAllGameScores() {
		
		Query query = em.createNamedQuery("GetAllGameScores");
		List<GameScores> gameScores = query.getResultList();
		
		return gameScores;
	}
	
	/**
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GameScores> getGameScoreByID(Integer id) {
		List <GameScores> gameScores;
		Query query = em.createNamedQuery("GetGameScoreByID");
		query.setParameter("gameScoreId", id);
		gameScores = query.getResultList();
		
		return gameScores;
	}
	
	/**
	 * 
	 */
	public void close() {
		cleanup();
	}
}
