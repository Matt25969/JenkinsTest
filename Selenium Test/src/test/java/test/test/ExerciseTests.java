package test.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExerciseTests {

	@BeforeClass

	public static void beforeClassTest() {

		System.out.println("Before Class");

	}

	@Before

	public void beforeTest() {

		System.out.println("Before");

	}

	@Test
	public void myTestMethod() {
		System.out.println("Hello World");
	}

	@After

	public void afterTest() {

		System.out.println("After");

	}

	@AfterClass

	public static void afterClassTest() {

		System.out.println("After Class");

	}

}
