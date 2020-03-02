package com.perscholas.casestudy.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Games
 *
 */@NamedQueries({
		@NamedQuery(query = "SELECT g FROM Games g", name= "GetAllGames"),
		@NamedQuery(query = "SELECT g FROM Games g WHERE g.id = :gameId", name = "GetGameByID")
})

@Entity
public class Games implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column (name = "course_id")
	private int courseId;
	@Column (name = "start_date")
	private Timestamp startDate;
	@Column (name = "end_date")
	private Timestamp endDate;
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
	public Games(int courseId, Timestamp startDate) {
		this.setCourseId(courseId);
		this.setStartDate(startDate);
		this.setEndDate(null);
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
	public Timestamp getStartDate() {
		return this.startDate;
	}

	/**
	 * @param startDate2
	 */
	public void setStartDate(Timestamp startDate2) {
		this.startDate = startDate2;
	}   
	/**
	 * @return
	 */
	public Timestamp getEndDate() {
		return this.endDate;
	}

	/**
	 * @param endDate
	 */
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		Games other = (Games) obj;
		if (courseId != other.courseId)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Games [id=" + id + ", courseId=" + courseId + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
   
}
