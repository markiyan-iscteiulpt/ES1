/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mechanisms.Ham;

/**
 * @author Francisco Araújo
 *
 */
public class HamTest {
	Ham file;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		final String filename = "xval_initial/9/_ham_/0016.d82758030e304d41fb3f4ebbb7d9dd91";
		final ArrayList<String> ham = new ArrayList<String>();
		ham.add("BAYES_00");

		this.file = new Ham(filename, ham);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link mechanisms.Ham#Ham(java.lang.String, java.util.ArrayList)}.
	 */
	@Test
	public final void testHam() {
		final String filename = "xval_initial/9/_ham_/0016.d82758030e304d41fb3f4ebbb7d9dd91";
		final ArrayList<String> ham = new ArrayList<String>();
		ham.add("BAYES_00");

		assertEquals(filename, file.getFilename());
		assertEquals(ham, file.getRules());
	}

	/**
	 * Test method for {@link mechanisms.Ham#getFilename()}.
	 */
	@Test
	public final void testGetFilename() {
		final String filename = "xval_initial/9/_ham_/0016.d82758030e304d41fb3f4ebbb7d9dd91";

		assertEquals(filename, file.getFilename());
	}

	/**
	 * Test method for {@link mechanisms.Ham#setFilename(java.lang.String)}.
	 */
	@Test
	public final void testSetFilename() {
		final String filename = "xval_initial/9/_ham_/0016.d82758030e304d41fb3f4ebbb7d9dd91";
		file.setFilename(filename);

		assertEquals(filename, file.getFilename());
	}

	/**
	 * Test method for {@link mechanisms.Ham#getRules()}.
	 */
	@Test
	public final void testGetRules() {
		final ArrayList<String> ham = new ArrayList<String>();
		ham.add("BAYES_00");

		assertEquals(ham, file.getRules());
	}

	/**
	 * Test method for {@link mechanisms.Ham#setRules(java.util.ArrayList)}.
	 */
	@Test
	public final void testSetRules() {
		final ArrayList<String> ham = new ArrayList<String>();
		ham.add("BAYES_00");
		file.setRules(ham);

		assertEquals(ham, file.getRules());
	}

}
