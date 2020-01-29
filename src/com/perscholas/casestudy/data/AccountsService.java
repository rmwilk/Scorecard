/**
 * 
 */
package com.perscholas.casestudy.data;

import java.util.List;

import javax.persistence.Query;

import com.perscholas.casestudy.entities.Accounts;

/**
 * @author rwilk
 *
 */
public class AccountsService extends AbstractService {

	/**
	 * 
	 */
	public AccountsService() {
		super();
	}
	
	/**
	 * @param account
	 */
	public void addAccount(Accounts account) {
		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
	}
	
	/**
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Accounts> getAllAccounts(int id) {
		List <Accounts> accounts;
		Query query = em.createNamedQuery("GetAllAccounts");
		query.setParameter("accountId", id);
		accounts = query.getResultList();
		
		return accounts;
	}

	/**
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Accounts> getAccountById(int id) {
		List <Accounts> accounts;
		Query query = em.createNamedQuery("GetAccountByID");
		query.setParameter("accountId", id);
		accounts = query.getResultList();
		
		return accounts;
	}
	/**
	 * 
	 */
	public void close() {
		cleanup();
	}
}
