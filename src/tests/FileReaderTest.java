/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JTextField;

import org.junit.Test;

import mechanisms.FileReader;
import mechanisms.Ham;
import mechanisms.Rule;
import mechanisms.Spam;

/**
 * @author Marcio
 *
 */
public class FileReaderTest {

	/**
	 * Test method for {@link mechanisms.FileReader#loadAndValidate()}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testLoadAndValidate() throws IOException {
		FileReader.loadAndValidate();
		boolean output = FileReader.isValidated();
		assertEquals(output, FileReader.loadAndValidate());
	}

	/**
	 * Test method for {@link mechanisms.FileReader#loadHam()}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testLoadHam() throws IOException {
		FileReader.loadHam();
		ArrayList<Ham> output = FileReader.getHam_list();
		assertNotNull(output);
	}

	/**
	 * Test method for {@link mechanisms.FileReader#loadSpam()}.
	 */
	@Test
	public final void testLoadSpam() {
		FileReader.loadSpam();
		ArrayList<Spam> output = FileReader.getSpam_list();
		assertNotNull(output);
	}

	/**
	 * Test method for {@link mechanisms.FileReader#loadRules()}.
	 */
	@Test
	public final void testLoadRules() {
		FileReader.loadRules();
		ArrayList<Rule> output = FileReader.getRules_list();
		assertNotNull(output);
	}

	/**
	 * Test method for
	 * {@link mechanisms.FileReader#loadPath(javax.swing.JTextField, javax.swing.JTextField, javax.swing.JTextField)}
	 * .
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	@Test
	public final void testLoadPathJTextFieldJTextFieldJTextField() throws IOException, URISyntaxException {
		JTextField rulesField = new JTextField();
		JTextField spamField = new JTextField();
		;
		JTextField hamField = new JTextField();
		;
		File[] output = FileReader.loadPath(rulesField, spamField, hamField);
		assertNotNull(output);

	}

	/**
	 * Test method for {@link mechanisms.FileReader#savePath(java.io.File[])}.
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	@Test
	public final void testSavePath() throws IOException, URISyntaxException {
		JTextField rulesField = new JTextField();
		JTextField spamField = new JTextField();
		;
		JTextField hamField = new JTextField();
		;
		File[] output = FileReader.loadPath(rulesField, spamField, hamField);
		FileReader.savePath(output);
	}

	/**
	 * Test method for
	 * {@link mechanisms.FileReader#saveConfig(java.lang.Object[][])}.
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	@Test
	public final void testSaveConfig() throws IOException, URISyntaxException {
	}

	/**
	 * Test method for {@link mechanisms.FileReader#readNSGAII()}.
	 */
	@Test
	public final void testReadNSGAII() {
		Object[][] ouput = FileReader.readNSGAII();
		assertNotNull(ouput);
	}

	/**
	 * Test method for {@link mechanisms.FileReader#configureAmb()}.
	 */
	@Test
	public final void testConfigureAmb() {
		boolean output = true;
		assertEquals(output, FileReader.configureAmb());
	}

	/**
	 * Test method for {@link mechanisms.FileReader#isValidated()}.
	 */
	@Test
	public final void testIsValidated() {
		boolean output = true;
		FileReader.setValidated(output);
		assertEquals(output, FileReader.isValidated());
	}

	/**
	 * Test method for {@link mechanisms.FileReader#setValidated(boolean)}.
	 */
	@Test
	public final void testSetValidated() {
		boolean output = true;
		FileReader.setValidated(output);
		assertEquals(output, FileReader.isValidated());
	}

	/**
	 * Test method for {@link mechanisms.FileReader#getRules_path()}.
	 */
	@Test
	public final void testGetRules_path() {
		File output = new File("");
		FileReader.setRules_path(output);
		assertEquals(output, FileReader.getRules_path());
	}

	/**
	 * Test method for {@link mechanisms.FileReader#setRules_path(java.io.File)}
	 * .
	 */
	@Test
	public final void testSetRules_path() {
		File output = new File("");
		FileReader.setRules_path(output);
		assertEquals(output, FileReader.getRules_path());
	}

	/**
	 * Test method for {@link mechanisms.FileReader#getHam_path()}.
	 */
	@Test
	public final void testGetHam_path() {
		File output = new File("");
		FileReader.setHam_path(output);
		assertEquals(output, FileReader.getHam_path());
	}

	/**
	 * Test method for {@link mechanisms.FileReader#setHam_path(java.io.File)}.
	 */
	@Test
	public final void testSetHam_path() {
		File output = new File("");
		FileReader.setHam_path(output);
		assertEquals(output, FileReader.getHam_path());
	}

	/**
	 * Test method for {@link mechanisms.FileReader#getSpam_path()}.
	 */
	@Test
	public final void testGetSpam_path() {
		File output = new File("");
		FileReader.setSpam_path(output);
		assertEquals(output, FileReader.getSpam_path());
	}

	/**
	 * Test method for {@link mechanisms.FileReader#setSpam_path(java.io.File)}.
	 */
	@Test
	public final void testSetSpam_path() {
		File output = new File("");
		FileReader.setSpam_path(output);
		assertEquals(output, FileReader.getSpam_path());
	}

	/**
	 * Test method for {@link mechanisms.FileReader#getRules_list()}.
	 */
	@Test
	public final void testGetRules_list() {
		Rule r = new Rule("", 0.0);
		ArrayList<Rule> output = new ArrayList<Rule>();
		output.add(r);
		FileReader.setRules_list(output);
		assertEquals(output, FileReader.getRules_list());
	}

	/**
	 * Test method for
	 * {@link mechanisms.FileReader#setRules_list(java.util.ArrayList)}.
	 */
	@Test
	public final void testSetRules_list() {
		Rule r = new Rule("", 0.0);
		ArrayList<Rule> output = new ArrayList<Rule>();
		output.add(r);
		FileReader.setRules_list(output);
		assertEquals(output, FileReader.getRules_list());
	}

	/**
	 * Test method for {@link mechanisms.FileReader#getHam_list()}.
	 */
	@Test
	public final void testGetHam_list() {
		Ham h = new Ham("", null);
		ArrayList<Ham> output = new ArrayList<Ham>();
		output.add(h);
		FileReader.setHam_list(output);
		assertEquals(output, FileReader.getHam_list());
	}

	/**
	 * Test method for
	 * {@link mechanisms.FileReader#setHam_list(java.util.ArrayList)}.
	 */
	@Test
	public final void testSetHam_list() {
		Ham h = new Ham("", null);
		ArrayList<Ham> output = new ArrayList<Ham>();
		output.add(h);
		FileReader.setHam_list(output);
		assertEquals(output, FileReader.getHam_list());
	}

	/**
	 * Test method for {@link mechanisms.FileReader#getSpam_list()}.
	 */
	@Test
	public final void testGetSpam_list() {
		Spam s = new Spam("", null);
		ArrayList<Spam> output = new ArrayList<Spam>();
		output.add(s);
		FileReader.setSpam_list(output);
		assertEquals(output, FileReader.getSpam_list());
	}

	/**
	 * Test method for
	 * {@link mechanisms.FileReader#setSpam_list(java.util.ArrayList)}.
	 */
	@Test
	public final void testSetSpam_list() {
		Spam s = new Spam("", null);
		ArrayList<Spam> output = new ArrayList<Spam>();
		output.add(s);
		FileReader.setSpam_list(output);
		assertEquals(output, FileReader.getSpam_list());
	}

	/**
	 * Test method for {@link mechanisms.FileReader#getAppdataDir()}.
	 */
	@Test
	public final void testGetAppdataDir() {
		String output = FileReader.getAppdataDir();
		assertNotNull(output);
	}
}
