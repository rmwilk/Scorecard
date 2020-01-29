package com.perscholas.casestudy.entities;

import java.io.Serializable;

/**
 * ID class for entity: GameScores
 *
 */ 
public class GameScoresPK  implements Serializable {   
   
	         
	private int id;         
	private int accountId;         
	private int courseId;
	private static final long serialVersionUID = 1L;

	public GameScoresPK() {}

	

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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof GameScoresPK)) {
			return false;
		}
		GameScoresPK other = (GameScoresPK) o;
		return true
			&& getId() == other.getId()
			&& getAccountId() == other.getAccountId()
			&& getCourseId() == other.getCourseId();
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getId();
		result = prime * result + getAccountId();
		result = prime * result + getCourseId();
		return result;
	}
   
   
}
