package tests;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/**
 * @author Marcio
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ EvaluationTest.class, FileReaderTest.class, HamTest.class, RuleTest.class, SpamTest.class,
		TableCellListenerTest.class,SolutionTest.class })
public class TestSuite {
}