/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import mechanisms.Solution;

/**
 * @author Marcio
 *
 */
public class SolutionTest {

	/**
	 * Test method for {@link mechanisms.Solution#Solution(int, double, double)}
	 * .
	 */
	@Test
	public final void testSolution() {
		int lines = 2;
		double fp = 1;
		double fn = 1;
		Solution output = new Solution(lines, fp, fn);
		assertNotNull(output);

	}

	/**
	 * Test method for {@link mechanisms.Solution#getLine_number()}.
	 */
	@Test
	public final void testGetLine_number() {
		int lines = 2;
		double fp = 1;
		double fn = 1;
		Solution output = new Solution(lines, fp, fn);
		assertEquals(2, output.getLine_number());
	}

	/**
	 * Test method for {@link mechanisms.Solution#setLine_number(int)}.
	 */
	@Test
	public final void testSetLine_number() {
		int lines = 0;
		double fp = 1;
		double fn = 1;
		Solution output = new Solution(lines, fp, fn);
		output.setLine_number(2);
		assertEquals(2, output.getLine_number());
	}

	/**
	 * Test method for {@link mechanisms.Solution#getFp()}.
	 */
	@Test
	public final void testGetFp() {
		int lines = 2;
		double fp = 1.0;
		double fn = 1;
		Solution output = new Solution(lines, fp, fn);
		assertNotNull(output.getFp());
	}

	/**
	 * Test method for {@link mechanisms.Solution#setFp(double)}.
	 */
	@Test
	public final void testSetFp() {
		int lines = 2;
		double fp = 0;
		double fn = 1;
		Solution output = new Solution(lines, fp, fn);
		output.setFp(1);
		assertNotNull(output.getFp());
	}

	/**
	 * Test method for {@link mechanisms.Solution#getFn()}.
	 */
	@Test
	public final void testGetFn() {
		int lines = 2;
		double fp = 1.0;
		double fn = 1;
		Solution output = new Solution(lines, fp, fn);
		assertNotNull(output.getFn());
	}

	/**
	 * Test method for {@link mechanisms.Solution#setFn(double)}.
	 */
	@Test
	public final void testSetFn() {
		int lines = 2;
		double fp = 0;
		double fn = 1;
		Solution output = new Solution(lines, fp, fn);
		output.setFp(1);
		assertNotNull(output.getFn());
	}

}
