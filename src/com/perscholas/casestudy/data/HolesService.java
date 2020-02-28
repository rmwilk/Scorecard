/**
 * 
 */
package com.perscholas.casestudy.data;

import java.util.List;

import javax.persistence.Query;

import com.perscholas.casestudy.entities.Holes;

/**
 * @author rwilk
 *
 */
public class HolesService extends AbstractService {

	/**
	 * 
	 */
	public HolesService() {
		super();
	}

	/**
	 * @param hole
	 */
	public void addHoles(Holes hole) {
		em.getTransaction().begin();
		em.persist(hole);
		em.getTransaction().commit();
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Holes> getAllHoles() {

		Query query = em.createNamedQuery("GetAllHoles");
		List<Holes> holes = query.getResultList();

		return holes;
	}
	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Holes> getAllHolesByCourseNumber(int number){
		List<Holes> holes;
		Query query = em.createNamedQuery("GetAllHolesByCourseNumber");
		query.setParameter("number", number);
		holes = query.getResultList();
		
		return holes;
	}
	/*
	 * @NamedQuery(query = "SELECT c FROM Holes c WHERE c.courseId = :courseId",
	 name = "JoinHolesAndCoursesByCourseId"),
	 */
	@SuppressWarnings("unchecked")
	public List<Holes> joinHolesAndCoursesByCourseId(int courseId){
		List<Holes> holes;
		Query query = em.createNamedQuery("JoinHolesAndCoursesByCourseId");
		query.setParameter("courseId", courseId);
		holes = query.getResultList();
		
		return holes;
	}
	
	
	
	/**
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Holes> getHoleByID(Integer id) {
		List<Holes> holes;
		Query query = em.createNamedQuery("GetHoleByID");
		query.setParameter("holeId", id);
		holes = query.getResultList();

		return holes;
	}

	/**
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Holes> getHoleByCourseAndNumber(int course, int number) {
		List<Holes> holes;
		Query query = em.createNamedQuery("GetHoleByCourseAndNumber");
		query.setParameter("courseId", course);
		query.setParameter("holeNum", number);
		holes = query.getResultList();

		return holes;
	}
	
	// given `results` is a List of size 1
	public String showHint(List<Holes> results) {
		return results.get(0).getHint();
	}
	
	/**
	 * 
	 */
	public void close() {
		cleanup();
	}
}
