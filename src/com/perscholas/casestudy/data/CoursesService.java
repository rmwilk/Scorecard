/**
 * 
 */
package com.perscholas.casestudy.data;

import java.util.List;

import javax.persistence.NamedQuery;
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
	//@NamedQuery(query = "SELECT c FROM Courses c WHERE c.name = :courseName", name = "GetCourseByName")
	/**
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Courses> getCourseByNumber(int number) {
		List <Courses> courses;
		Query query = em.createNamedQuery("GetCourseByNumber");
		query.setParameter("courseName", number);
		courses = query.getResultList();
		
		return courses;
	}
	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Courses> getAllcourses() {
		
		Query query = em.createNamedQuery("GetAllCourses");
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
		Query query = em.createNamedQuery("GetCourseByID");
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
