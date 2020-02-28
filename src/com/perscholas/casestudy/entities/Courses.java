package com.perscholas.casestudy.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Courses
 *
 */
@NamedQueries({
	@NamedQuery(query = "SELECT c FROM Courses c", name= "GetAllCourses"),
	@NamedQuery(query = "SELECT c FROM Courses c WHERE c.id = :courseId", name = "GetCourseByID"),
	@NamedQuery(query = "SELECT c FROM Courses c WHERE c.name = :courseName", name = "GetCourseByName")
})
@Entity
public class Courses implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private static final long serialVersionUID = 1L;
	
	@OneToMany
	private Collection<Holes> holes;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Courses other = (Courses) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + "]";
	}
   
}
