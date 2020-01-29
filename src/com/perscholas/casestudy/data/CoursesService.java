/**
 * 
 */
package com.perscholas.casestudy.data;

import java.util.List;

import javax.persistence.Query;

import com.perscholas.casestudy.entities.Courses;

/**
 * @author rwilk
 *
 */
public class CoursesService extends AbstractService {

	/**
	 * 
	 */
	public CoursesService() {
		super();
	}
	
	/**
	 * @param course
	 */
	public void addcourse(Courses course) {
		em.getTransaction().begin();
		em.persist(course);
		em.getTransaction().commit();
	}
	
	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Courses> getAllcourses() {
		
		Query query = em.createNamedQuery("GetAllcourses");
		List<Courses> courses = query.getResultList();
		
		return courses;
	}
	
	/**
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Courses> getcourseByID(Integer id) {
		List <Courses> courses;
		Query query = em.createNamedQuery("GetcourseByID");
		query.setParameter("courseId", id);
		courses = query.getResultList();
		
		return courses;
	}
	
	/**
	 * 
	 */
	public void close() {
		cleanup();
	}
}
