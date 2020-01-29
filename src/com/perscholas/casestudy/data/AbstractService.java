/**
 * 
 */
package com.perscholas.casestudy.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author rwilk
 *
 */
public abstract class AbstractService {
	protected EntityManagerFactory emf;
	protected EntityManager em;
	
	public AbstractService() {
		emf = Persistence.createEntityManagerFactory("Scorecard");
		em = emf.createEntityManager();
	}
	public AbstractService(String PU) {
		emf = Persistence.createEntityManagerFactory(PU);
		em = emf.createEntityManager();
	}
	protected void cleanup() {
		em.close();
		emf.close();
	}
}
