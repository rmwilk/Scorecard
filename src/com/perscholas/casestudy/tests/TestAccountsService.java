package com.perscholas.casestudy.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.perscholas.casestudy.data.AccountsService;
import com.perscholas.casestudy.entities.Accounts;

import junit.framework.Assert;

/**
 * @author rwilk
 *
 */
class TestAccountsService {
	Accounts expected;
	AccountsService as;
	
	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		as = new AccountsService();
	}

	/**
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		as.close();
	}

	/**
	 * 
	 */
	@SuppressWarnings("deprecation") // deprecation on assertEquals(int, int)
	@Test
	void test() {
		expected = new Accounts(1, "rwilk@umich.edu", "admin", "Ry");
		String email = "rwilk@umich.edu";
		Accounts actual = as.getAccountByEmail(email).get(0);
		Assert.assertEquals(expected.getId(), actual.getId());
	}

}
