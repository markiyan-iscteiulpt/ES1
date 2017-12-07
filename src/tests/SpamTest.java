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

import mechanisms.Spam;

/**
 * @author Francisco Araújo
 *
 */
public class SpamTest {
	Spam file;

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
		final String filename = "xval_initial/9/_spam_/00319.a99dff9c010e00ec182ed5701556d330";
		final ArrayList<String> rules = new ArrayList<String>();
		rules.add("BAYES_99");

		this.file = new Spam(filename, rules);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link mechanisms.Spam#Spam(java.lang.String, java.util.ArrayList)}.
	 */
	@Test
	public final void testSpam() {
		final String filename = "xval_initial/9/_spam_/00319.a99dff9c010e00ec182ed5701556d330";
		final ArrayList<String> rules = new ArrayList<String>();
		rules.add("BAYES_99");

		assertEquals(filename, file.getFilename());
		assertEquals(rules, file.getRules());
	}

	/**
	 * Test method for {@link mechanisms.Spam#getFilename()}.
	 */
	@Test
	public final void testGetFilename() {
		final String filename = "xval_initial/9/_spam_/00319.a99dff9c010e00ec182ed5701556d330";

		assertEquals(filename, file.getFilename());
	}

	/**
	 * Test method for {@link mechanisms.Spam#setFilename(java.lang.String)}.
	 */
	@Test
	public final void testSetFilename() {
		final String filename = "xval_initial/9/_spam_/00319.a99dff9c010e00ec182ed5701556d330";
		file.setFilename(filename);

		assertEquals(filename, file.getFilename());
	}

	/**
	 * Test method for {@link mechanisms.Spam#getRules()}.
	 */
	@Test
	public final void testGetRules() {
		final ArrayList<String> rules = new ArrayList<String>();
		rules.add("BAYES_99");

		assertEquals(rules, file.getRules());
	}

	/**
	 * Test method for {@link mechanisms.Spam#setRules(java.util.ArrayList)}.
	 */
	@Test
	public final void testSetRules() {
		final ArrayList<String> rules = new ArrayList<String>();
		rules.add("BAYES_99");
		file.setRules(rules);

		assertEquals(rules, file.getRules());
	}

}
