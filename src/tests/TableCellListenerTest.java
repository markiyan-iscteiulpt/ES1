/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.beans.PropertyChangeEvent;

import javax.swing.JTable;

import org.junit.Test;

import mechanisms.TableCellListener;

/**
 * @author Marcio
 *
 */
public class TableCellListenerTest {

	/**
	 * Test method for
	 * {@link mechanisms.TableCellListener#TableCellListener(javax.swing.JTable, javax.swing.Action)}
	 * .
	 */
	@Test
	public final void testTableCellListener() {
		JTable table = new JTable();
		TableCellListener output = new TableCellListener(table, null);
		assertNotNull(output);
	}

	/**
	 * Test method for {@link mechanisms.TableCellListener#getColumn()}.
	 */
	@Test
	public final void testGetColumn() {
		JTable table = new JTable();
		int output = new TableCellListener(table, null).getColumn();
		int column = 0;
		assertEquals(column, output);

	}

	/**
	 * Test method for {@link mechanisms.TableCellListener#getNewValue()}.
	 */
	@Test
	public final void testGetNewValue() {
		JTable table = new JTable();
		Object output = new TableCellListener(table, null).getNewValue();
		assertNull(output);
	}

	/**
	 * Test method for {@link mechanisms.TableCellListener#getOldValue()}.
	 */
	@Test
	public final void testGetOldValue() {
		JTable table = new JTable();
		Object output = new TableCellListener(table, null).getOldValue();
		assertNull(output);
	}

	/**
	 * Test method for {@link mechanisms.TableCellListener#getRow()}.
	 */
	@Test
	public final void testGetRow() {
		JTable table = new JTable();
		int output = new TableCellListener(table, null).getRow();
		int row = 0;
		assertEquals(row, output);
	}

	/**
	 * Test method for {@link mechanisms.TableCellListener#getTable()}.
	 */
	@Test
	public final void testGetTable() {
		JTable table = new JTable();
		TableCellListener tableListener = new TableCellListener(table, null);
		assertEquals(table, tableListener.getTable());

	}

	/**
	 * Test method for
	 * {@link mechanisms.TableCellListener#propertyChange(java.beans.PropertyChangeEvent)}
	 * .
	 */
	@Test
	public final void testPropertyChange() {
		JTable table = new JTable();
		TableCellListener tableListener = new TableCellListener(table, null);
		TableCellListener output = new TableCellListener(table, tableListener.getRow(), tableListener.getColumn(),
				tableListener.getOldValue(), tableListener.getNewValue());
		PropertyChangeEvent e = new PropertyChangeEvent(output, "", output.getOldValue(), output.getNewValue());
		output.propertyChange(e);
	}

	/**
	 * Test method for {@link mechanisms.TableCellListener#run()}.
	 */
	@Test
	public final void testRun() {

	}

}
