package com.perscholas.casestudy.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: GameScores
 *
 */
@NamedQueries({ @NamedQuery(query = "SELECT gs FROM GameScores gs", name = "GetAllGameScores"),
		@NamedQuery(query = "SELECT gs FROM GameScores gs WHERE gs.id = :gameScoreId", name = "GetGameScoreByID") })
//@IdClass(GameScoresPK.class) // for the composite key
@Entity
public class GameScores implements Serializable {

	@Id
	private int id;
	@Column(name = "game_id")
	private int gameId;
	@Column(name = "account_id")
	private int accountId;
	@Column(name = "course_id")
	private int courseId;

	private int score;
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GameScores() {
		super();
	}

	/**
	 * @param id
	 * @param accountId
	 * @param courseId
	 * @param score
	 */
	public GameScores(int id, int accountId, int courseId, int score) {
		this.setId(id);
		this.setAccountId(accountId);
		this.setCourseId(courseId);
		this.setScore(score);
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
	public int getCourseId() {
		return this.courseId;
	}

	/**
	 * @param courseId
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
		result = prime * result + courseId;
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
		if (courseId != other.courseId)
			return false;
		if (id != other.id)
			return false;
		if (score != other.score)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GameScores [id=" + id + ", accountId=" + accountId + ", courseId=" + courseId + ", score=" + score
				+ "]";
	}

}
