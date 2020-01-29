package com.perscholas.casestudy.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: GameScores
 *
 */
@Entity

@IdClass(GameScoresPK.class)
public class GameScores implements Serializable {

	   
	@Id
	private int id;   
	@Id
	private int accountId;   
	@Id
	private int courseId;
	private int score;
	private static final long serialVersionUID = 1L;

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



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}   
	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}   
	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}
   
}
