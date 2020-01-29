package com.perscholas.casestudy.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Games
 *
 */@NamedQueries({
		@NamedQuery(query = "SELECT g FROM Games g", name= "GetAllGames"),
		@NamedQuery(query = "SELECT g FROM Games g WHERE g.id = :gamesId", name = "GetTeacherByID")
})

@Entity
public class Games implements Serializable {

	   
	@Id
	private int id;
	private int courseId;
	
	private Date startDate;
	private Date endDate;
	private static final long serialVersionUID = 1L;

	public Games() {
		super();
	}   
	
	/**
	 * @param id
	 * @param courseId
	 * @param startDate
	 * @param endDate
	 */
	public Games(int id, int courseId, Date startDate, Date endDate) {
		this.setId(id);
		this.setCourseId(courseId);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
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
	public Date getStartDate() {
		return this.startDate;
	}

	/**
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}   
	/**
	 * @return
	 */
	public Date getEndDate() {
		return this.endDate;
	}

	/**
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
   
}
