package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import mechanisms.FileReader;
import mechanisms.Rule;
import mechanisms.TableCellListener;

/**
 * @author Markiyan Pyekh
 *
 */
public class RightSide extends JPanel{

	private static final long serialVersionUID = 4361279460245695200L;
	private JTabbedPane tab = new JTabbedPane();
	private String[] columnNames = {"Rule", "Weight"};
	private Object[][] data = {{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},
								{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},
								{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""}};		
	private JTable auto_table;
	private JTable man_table;
	private Object[][] current_auto;
	private Object[][] current_man;
	
	/**
	 * Construtor do lado direito da Gui(tabela)
	 * @param gui
	 * @throws IOException
	 */
	public RightSide(Gui gui) throws IOException {
		setLayout(null);
		setBounds(560, 21, 420, 553);
		this.setOpaque(true);
		this.setBackground(new Color(255,255,255,0));
		
		tab.add("Automatico", autoConfig());
		
		tab.setBounds(5, 9, 409, 538);
		tab.setOpaque(true);
		tab.setBackground(new Color(0,0,0,0));
		add(tab);
	}
	
	/**
	 * Método para adicionar o tab manual por cima da tabela
	 */
	public void addManTab(){
		tab.add("Manual", manualConfig());
	}
	
	/**
	 * Função para construção da tabela manual
	 * @return pan
	 */
	private JPanel manualConfig(){
		JPanel pan = new JPanel();
		pan.setLayout(null);
		
		current_man = new Object[current_auto.length][2];
		for(int i = 0; i< current_auto.length; i++){
			current_man[i][1] = current_auto[i][1];
			current_man[i][0] = current_auto[i][0];
		}
		man_table = new JTable(current_man, columnNames);
		
		for(int x=0;x<man_table.getColumnCount();x++){
			man_table.getColumnModel().getColumn(x).setCellRenderer(new CustomRenderer());
	    }
		
		JTableHeader th = man_table.getTableHeader();
		th.setBackground(Color.darkGray);
		th.setForeground(Color.white);
		
		AbstractAction action = new AbstractAction(){
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e){
		        TableCellListener tcl = (TableCellListener)e.getSource();
		        current_man[tcl.getRow()][ tcl.getColumn()] = tcl.getNewValue();
		    }
		};
		
		new TableCellListener(man_table, action);
		
		JScrollPane sp = new JScrollPane(man_table);
		sp.setBounds(0, 0, 405, 511);
		pan.add(sp);
		return pan;
	}
	
	/**
	 * Função para construção da tabela automática
	 * @return pan
	 * @throws IOException
	 */
	private JPanel autoConfig() throws IOException{
		JPanel pan = new JPanel();
		pan.setLayout(null);
		this.auto_table = new JTable(data, columnNames);
		this.auto_table.setEnabled(false);
	
		for(int x=0;x<this.auto_table.getColumnCount();x++){
			this.auto_table.getColumnModel().getColumn(x).setCellRenderer(new CustomRenderer());
	         
	    }
		
		JTableHeader th = this.auto_table.getTableHeader();
		th.setBackground(Color.darkGray);
		th.setForeground(Color.white);
		
		
		JScrollPane sp = new JScrollPane(this.auto_table);
		sp.setBounds(0, 0, 405, 511);
		pan.add(sp);
		return pan;
	}
	
	/**
	 * Método que carrega os dados para a tabela automática
	 */
	public void loadAutoConf(){
		if(FileReader.isValidated()){
		ArrayList<Rule> rule = FileReader.getRules_list();
		current_auto = new Object[rule.size()][2];
			for(Rule r : rule){
				current_auto[rule.indexOf(r)][0] = r.getRule();
				current_auto[rule.indexOf(r)][1] = r.getWeight();
			}
		}
			TableModel model = new DefaultTableModel(current_auto, columnNames);
			this.auto_table.setModel(model);
			for(int x=0;x<this.auto_table.getColumnCount();x++){
				this.auto_table.getColumnModel().getColumn(x).setCellRenderer(new CustomRenderer());
		         
		    }
			this.auto_table.repaint();
	}

	class CustomRenderer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 6703872492730589499L;
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
	        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        if(column == 1){setHorizontalAlignment( JLabel.CENTER );}
	        if(row % 2 == 0){
	            cellComponent.setBackground(Color.lightGray);
	        }else{
	        	cellComponent.setBackground(Color.white);
	        }
	        return cellComponent;
	    }
	}
	
	public Object[][] getCurrent_auto() {
		return current_auto;
	}

	public Object[][] getCurrent_man() {
		return current_man;
	}
	
	public JTabbedPane getTabbedPane(){
		return this.tab;
	}

	/**
	 * Método que actualiza a tabela automática
	 * @param a
	 */
	public void updateAuto(Object[][] a) {
		current_auto = a;
		TableModel model = new DefaultTableModel(a, columnNames);
		this.auto_table.setModel(model);
		for(int x=0;x<this.auto_table.getColumnCount();x++){
			this.auto_table.getColumnModel().getColumn(x).setCellRenderer(new CustomRenderer());
	         
	    }
		this.auto_table.repaint();
		
	}

}
