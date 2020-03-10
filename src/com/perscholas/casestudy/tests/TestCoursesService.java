package com.perscholas.casestudy.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.perscholas.casestudy.data.CoursesService;
import com.perscholas.casestudy.entities.Courses;

import junit.framework.Assert;

class TestCoursesService {
	CoursesService cs;
	Courses expected;
	@BeforeEach
	void setUp() throws Exception {
		cs = new CoursesService();
	}

	@AfterEach
	void tearDown() throws Exception {
		cs.close();
	}

	@SuppressWarnings("deprecation") //assertEquals(String, String)
	@Test
	void test() {
		expected = new Courses(2, "B");
		int id = 2;
		Courses actual = cs.getcourseByID(id).get(0);
		Assert.assertEquals(expected.getName(), actual.getName());
	}

}
