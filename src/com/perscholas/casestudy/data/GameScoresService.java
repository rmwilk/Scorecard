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
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GameScores> getAllGameScoress() {
		
		Query query = em.createNamedQuery("GetAllGameScores");
		List<GameScores> gameScores = query.getResultList();
		
		return gameScores;
	}
	
	/**
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GameScores> getGameScoresByID(Integer id) {
		List <GameScores> gameScores;
		Query query = em.createNamedQuery("GetGameScoresByID");
		query.setParameter("holeID", id);
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
