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
	protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("Scorecard");
	protected EntityManager em = emf.createEntityManager();
	
	protected void closeup() {
		emf.close();
		em.close();
	}
}
