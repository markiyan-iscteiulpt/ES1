/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import mechanisms.Evaluation;
import mechanisms.FileReader;

/**
 * @author Marcio
 *
 */
public class EvaluationTest {

	public static double[] getTestedValues() {
		double[] testedValues = new double[10];
		for (int i = 0; i < testedValues.length; i++) {
			if (i == 0) {
				testedValues[i] = -7.5;
			} else {
				testedValues[i] = testedValues[i - 1] + 1.75;
			}
		}
		return testedValues;
	}

	public static int[] getOutput() {
		int[] output = new int[3];
		int FP = 63;
		int FN = 231;
		int anlysedData = 934;
		for (int i = 0; i < output.length; i++) {
			if (i == 0) {
				output[0] = FP;
			}
			if (i == 1) {
				output[1] = FN;
			} else {
				output[2] = anlysedData;
			}
		}
		return output;
	}

	/**
	 * Test method for {@link mechanisms.Evaluation#evaluate(double[])}.
	 * 
	 * @throws IOException
	 */
	@Test
	/*
	 * Quanto maior forem os valores do vetor de teste, maior o nº de FP, quanto
	 * menor forem os valores de teste maior o nº de FN, no entanto o valor de
	 * dados analisados nunca se altera
	 */
	public final void testEvaluate() throws IOException {
		FileReader.loadAndValidate();
		FileReader.loadRules();
		FileReader.loadHam();
		FileReader.loadSpam();
		assertNotNull(Evaluation.evaluate(getTestedValues()));
	}

	/**
	 * Test method for {@link mechanisms.Evaluation#getFP()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testGetFP() throws Exception {
		int FP = 10;
		Evaluation.setFP(FP);
		assertEquals(FP, Evaluation.getFP());
	}

	/**
	 * Test method for {@link mechanisms.Evaluation#setFP(int)}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testSetFP() throws IOException {
		int FP = 10;
		Evaluation.setFP(FP);
		assertEquals(FP, Evaluation.getFP());
	}

	/**
	 * Test method for {@link mechanisms.Evaluation#getFN()}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testGetFN() throws IOException {
		int FN = 5;
		Evaluation.setFN(FN);
		assertEquals(FN, Evaluation.getFN());
	}

	/**
	 * Test method for {@link mechanisms.Evaluation#setFN(int)}.
	 */
	@Test
	public final void testSetFN() {
		int FN = 5;
		Evaluation.setFN(FN);
		assertEquals(FN, Evaluation.getFN());
	}
	
	public static void main(String[] args) throws IOException {
		FileReader.loadAndValidate();
		FileReader.loadRules();
		FileReader.loadHam();
		FileReader.loadSpam();
		int[] evaluate = Evaluation.evaluate(getTestedValues());
		for(int i=0;i<evaluate.length;i++)	{
			System.out.println(evaluate[i]);
		}
		for(int i=0;i<getOutput().length;i++)	{
			System.out.println(getOutput()[i]);
		}
	}
}
