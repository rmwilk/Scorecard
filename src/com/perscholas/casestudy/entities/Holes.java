package com.perscholas.casestudy.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Holes
 *
 */
@Entity

public class Holes implements Serializable {

	   
	@Id
	private int id;
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
	public Holes(int id, int courseId, int number, int par, String hint) {
		this.setId(id);
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
   
}
