package com.perscholas.casestudy.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: GameScores
 *
 */
@Table(name = "game_scores")
@NamedQueries({ @NamedQuery(query = "SELECT gs FROM GameScores gs", name = "GetAllGameScores"),
		@NamedQuery(query = "SELECT gs FROM GameScores gs WHERE gs.id = :gameScoreId", name = "GetGameScoreByID") })
//@IdClass(GameScoresPK.class) // for the composite key
@Entity
public class GameScores implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "game_id")
	private int gameId;
	@Column(name = "account_id")
	private int accountId;
	@Column(name = "hole_id")
	private int holeId;
	private int score;
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GameScores() {
		super();
	}

	/**
	 * @param gameId
	 * @param accountId
	 * @param holeId
	 * @param score
	 */
	public GameScores(int gameId, int accountId, int holeId, int score) {
		this.setGameId(gameId);
		this.setAccountId(accountId);
		this.setHoleId(holeId);
		this.setScore(score);
	}

	/**
	 * @return the gameId
	 */
	public int getGameId() {
		return gameId;
	}

	/**
	 * @param gameId the gameId to set
	 */
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	/**
	 * @return the holeId
	 */
	public int getHoleId() {
		return holeId;
	}

	/**
	 * @param holeId the holeId to set
	 */
	public void setHoleId(int holeId) {
		this.holeId = holeId;
	}

	/**
	 * @return
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public int getAccountId() {
		return this.accountId;
	}

	/**
	 * @param accountId
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + gameId;
		result = prime * result + holeId;
		result = prime * result + id;
		result = prime * result + score;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameScores other = (GameScores) obj;
		if (accountId != other.accountId)
			return false;
		if (gameId != other.gameId)
			return false;
		if (holeId != other.holeId)
			return false;
		if (id != other.id)
			return false;
		if (score != other.score)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GameScores [id=" + id + ", gameId=" + gameId + ", accountId=" + accountId + ", holeId=" + holeId
				+ ", score=" + score + "]";
	}

	
}
