package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mechanisms.Evaluation;
import mechanisms.FileReader;

public class ManualConfig extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel fn;
	private JLabel fp;
	private JLabel filter;
	private JButton manual;
	private JButton run;
	private JButton save;
	
	private Gui gui;
	
	public ManualConfig(Gui gui) {
		this.gui = gui;
		setLayout(null);
		setBounds(16, 415, 501, 155);
		this.setOpaque(true);
		this.setBackground(new Color(255,255,255,000));
		
		manual = new JButton("Manual Config");
		manual.setBounds(18, 37, 162, 21);
		manual.setEnabled(false);
		
		run = new JButton("Evaluate Config");
		run.setBounds(18, 65, 162, 21);
		run.setEnabled(false);
		
		save = new JButton("Save Config");
		save.setBounds(18, 95, 162, 21);
		save.setEnabled(false);
		
		fn = new JLabel("0");
		fn.setBounds(295, 41, 30, 20);
		
		fp = new JLabel("0");
		fp.setBounds(295, 61, 30, 20); 
		
		filter = new JLabel("0");
		filter.setBounds(310, 86, 30, 20);
		
		add(manual);
		add(run);
		add(save);
		add(fn);
		add(fp);
		add(filter);
		
		manual.addActionListener(listener());
		run.addActionListener(listener());
		save.addActionListener(listener());
	}
	
	private ActionListener listener(){
		ActionListener al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == manual){
					if(gui.getRightSide().getTabbedPane().getTabCount() <= 1){
					gui.getRightSide().addManTab();
					run.setEnabled(true);
					save.setEnabled(true);
				}else{
					gui.getRightSide().getTabbedPane().remove(gui.getRightSide().getTabbedPane().getTabCount()-1);
					gui.getRightSide().addManTab();
					run.setEnabled(true);
					save.setEnabled(true);
				}
				}else if(e.getSource() == run){
					double[] a = new double[gui.getRightSide().getCurrent_man().length];
					for(int i = 0; i < gui.getRightSide().getCurrent_man().length; i++){
						if(gui.getRightSide().getCurrent_man()[i][1] instanceof String){
							a[i] = Double.valueOf((String)gui.getRightSide().getCurrent_man()[i][1]);
						}else{
						a[i] = (double)gui.getRightSide().getCurrent_man()[i][1];}
					}
					if(FileReader.isValidated()){int [] qwe = new int[3]; qwe = Evaluation.evaluate(a); updateStat(qwe);}
				}else if(e.getSource() == save){
					FileReader.saveConfig(gui.getRightSide().getCurrent_man());
				}
			}
		};
		return al;
	}
	
	
	private void updateStat(int [] arra){
		String f = "";
		f+=arra[1];
		String ff = "";
		ff+= arra[0];
		
		int rate = arra[0] + arra[1];
		String tt = "";
		tt+=rate;
		
		filter.setText(tt);
		fn.setText(ff);
		fp.setText(f);
		
		repaint();
		gui.repaint();
	}
	
	public void enabled(){
		manual.setEnabled(true);
	}
	
	public void disabled(){
		manual.setEnabled(false);
	}
}
