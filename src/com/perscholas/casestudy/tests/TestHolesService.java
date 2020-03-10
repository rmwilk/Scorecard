package com.perscholas.casestudy.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.perscholas.casestudy.data.HolesService;
import com.perscholas.casestudy.entities.Holes;

import junit.framework.Assert;

class TestHolesService {
	HolesService hs;
	Holes expected;
	
	@BeforeEach
	void setUp() throws Exception {
		hs = new HolesService();
	}

	@AfterEach
	void tearDown() throws Exception {
		hs.close();
	}

	@SuppressWarnings("deprecation")
	@Test
	void test() {
		int id = 4;
		Assert.assertNotNull(hs.getHoleByID(id));
	}

}
