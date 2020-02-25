package com.perscholas.casestudy.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Holes
 *
 */
@NamedQueries({ @NamedQuery(query = "SELECT h FROM Holes h", name = "GetAllHoles"),
		@NamedQuery(query = "SELECT h FROM Holes h WHERE h.id = :holeId", name = "GetHoleByID"),
		@NamedQuery(query = "SELECT h FROM Holes h WHERE h.courseId = :courseId AND h.number = :holeNum", name = "GetHoleByCourseAndNumber"),
		@NamedQuery(query = "SELECT h FROM Holes h WHERE h.name = :name", name = "GetAllHolesByCourseName") })
@Entity
public class Holes implements Serializable {

	@Id
	private int id;
	private String name;
	@Column(name = "course_id")
	private int courseId;
	private int number;
	private int par;
	private String hint;
	private static final long serialVersionUID = 1L;

	public Holes() {
		super();
	}

	/**
	 * @param id
	 * @param course_id
	 * @param number
	 * @param par
	 * @param hint
	 */
	public Holes(int id, String name, int courseId, int number, int par, String hint) {
		this.setId(id);
		this.setName(name);
		this.setCourseId(courseId);
		this.setNumber(number);
		this.setPar(par);
		this.setHint(hint);
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

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPar() {
		return this.par;
	}

	public void setPar(int par) {
		this.par = par;
	}

	public String getHint() {
		return this.hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result + ((hint == null) ? 0 : hint.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + par;
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
		Holes other = (Holes) obj;
		if (courseId != other.courseId)
			return false;
		if (hint == null) {
			if (other.hint != null)
				return false;
		} else if (!hint.equals(other.hint))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (par != other.par)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Holes [id=" + id + ", name=" + name + ", courseId=" + courseId + ", number=" + number + ", par=" + par
				+ ", hint=" + hint + "]";
	}

}
