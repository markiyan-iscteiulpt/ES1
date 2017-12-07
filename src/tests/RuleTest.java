/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mechanisms.Rule;

/**
 * @author Francisco Araújo
 *
 */
public class RuleTest {
	Rule file;

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
		final String rule = "BAYES_00";
		final double weight = -3.6867823702284186;

		this.file = new Rule(rule, weight);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link mechanisms.Rule#Rule(java.lang.String, double)}.
	 */
	@Test
	public final void testRule() {
		final String rule = "BAYES_00";
		final double weight = -3.6867823702284186;

		assertEquals(rule, file.getRule());
		assertEquals(weight, file.getWeight(), 0.0000001);
	}

	/**
	 * Test method for {@link mechanisms.Rule#getRule()}.
	 */
	@Test
	public final void testGetRule() {
		final String rule = "BAYES_00";

		assertEquals(rule, file.getRule());
	}

	/**
	 * Test method for {@link mechanisms.Rule#setRule(java.lang.String)}.
	 */
	@Test
	public final void testSetRule() {
		final String rule = "BAYES_00";
		file.setRule(rule);

		assertEquals(rule, file.getRule());
	}

	/**
	 * Test method for {@link mechanisms.Rule#getWeight()}.
	 */
	@Test
	public final void testGetWeight() {
		final double weight = -3.6867823702284186;

		assertEquals(weight, file.getWeight(), 0.0000001);
	}

	/**
	 * Test method for {@link mechanisms.Rule#setWeight(double)}.
	 */
	@Test
	public final void testSetWeight() {
		final double weight = -3.6867823702284186;
		file.setWeight(weight);

		assertEquals(weight, file.getWeight(), 0.0000001);
	}

}
