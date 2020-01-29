package com.perscholas.casestudy.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Games
 *
 */
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



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}   
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}   
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
   
}
