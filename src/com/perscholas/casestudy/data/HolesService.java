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
	public List<Holes> getAllHoless() {
		
		Query query = em.createNamedQuery("GetAllHoless");
		List<Holes> holes = query.getResultList();
		
		return holes;
	}
	
	/**
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Holes> getHolesByID(Integer id) {
		List <Holes> holes;
		Query query = em.createNamedQuery("GetHolesByID");
		query.setParameter("holeID", id);
		holes = query.getResultList();
		
		return holes;
	}
	
	/**
	 * 
	 */
	public void close() {
		cleanup();
	}
}
