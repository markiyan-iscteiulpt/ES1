package gui;

import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import mechanisms.Rule;

public class RightSide extends JPanel{

	private static final long serialVersionUID = 4361279460245695200L;
	private JTabbedPane tab = new JTabbedPane();
	
	private String[] columnNames = {"Rule", "Weight"};
	private Object[][] data = {{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},
								{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},
								{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""},{"", ""}};
			
	
	public RightSide() throws IOException {
		setLayout(null);
		setBounds(560, 21, 420, 553);
		this.setOpaque(true);
		this.setBackground(new Color(255,255,255,0));
		
			tab.add("Automatico", autoConfig());
//			tab.add("Manual", manualConfig());
		
		tab.setBounds(5, 9, 409, 538);
		tab.setOpaque(true);
		tab.setBackground(new Color(0,0,0,0));
		
		add(tab);
	}
	
	
	private JPanel manualConfig(){
		JPanel pan = new JPanel();
		pan.setLayout(null);
		JTable table = new JTable(data, columnNames);
	
		for(int x=0;x<table.getColumnCount();x++){
	         table.getColumnModel().getColumn(x).setCellRenderer(new CustomRenderer());
	         
	    }
		
		JTableHeader th = table.getTableHeader();
		th.setBackground(Color.darkGray);
		th.setForeground(Color.white);
		
		
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 0, 405, 511);
		pan.add(sp);
		return pan;
	}
	
	
	private JPanel autoConfig() throws IOException{
		JPanel pan = new JPanel();
		pan.setLayout(null);
		Object[][] data = loadDataFromFile(new File("Documents/rules.cf"));
		JTable table = new JTable(data, columnNames);
		table.setEnabled(false);
	
		for(int x=0;x<table.getColumnCount();x++){
	         table.getColumnModel().getColumn(x).setCellRenderer(new CustomRenderer());
	         
	    }
		
		JTableHeader th = table.getTableHeader();
		th.setBackground(Color.darkGray);
		th.setForeground(Color.white);
		
		
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 0, 405, 511);
		pan.add(sp);
		return pan;
	}
	
	private Object[][] loadDataFromFile(File file) throws IOException {
		@SuppressWarnings("resource")
		BufferedReader in = new BufferedReader(new InputStreamReader( new FileInputStream(file), "UTF8"));
		ArrayList<Rule> rules = new ArrayList<>();
		String line;
		int line_count = 0;
			while((line = in.readLine())!= null){
				line_count++;
				if(line.split(":").length < 2){
				rules.add(new Rule(line.split(":")[0], 0));
				}else{ rules.add(new Rule(line.split(":")[0], Double.parseDouble(line.split(":")[1])));}
			}
			
			Object[][] ret = new Object[line_count][2];
			for(Rule r : rules){
				ret[rules.indexOf(r)][0] = r.getRule();
				ret[rules.indexOf(r)][1] = r.getWeight();
			}
		return ret;
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
}
