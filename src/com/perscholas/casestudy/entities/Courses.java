package com.perscholas.casestudy.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Courses
 *
 */
@NamedQueries({
	@NamedQuery(query = "SELECT c FROM Courses c", name= "GetAllCourses"),
	@NamedQuery(query = "SELECT c FROM Courses c WHERE c.id = :courseId", name = "GetCoursesByID")
})
@Entity
public class Courses implements Serializable {

	   
	@Id
	private int id;
	
	private String name;
	private static final long serialVersionUID = 1L;

	public Courses() {
		super();
	}   
	
	
	/**
	 * @param id
	 * @param name
	 */
	public Courses(int id, String name) {
		this.setId(id);
		this.setName(name);
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
