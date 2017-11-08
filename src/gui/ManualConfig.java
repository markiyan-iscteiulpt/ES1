package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ManualConfig extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel fn;
	private JLabel fp;
	private JLabel filter;
	private JButton manual;
	private JButton run;
	
	public ManualConfig() {
		setLayout(null);
		setBounds(16, 415, 501, 155);
		this.setOpaque(true);
		this.setBackground(new Color(255,255,255,000));
		
		manual = new JButton("Manual Config");
		manual.setBounds(18, 37, 162, 21);
		manual.setOpaque(false);
		manual.setBorderPainted(false);
		
		run = new JButton("Run Config");
		run.setBounds(18, 65, 162, 21);
		run.setOpaque(false);
		run.setBorderPainted(false);
		
		fn = new JLabel();
		fn.setBounds(345, 41, 30, 20);
		
		fp = new JLabel();
		fp.setBounds(345, 61, 30, 20); 
		
		filter = new JLabel();
		filter.setBounds(395, 87, 30, 20);
		
		add(manual);
		add(run);
		add(fn);
		add(fp);
		add(filter);
		
		manual.addActionListener(listener());
		run.addActionListener(listener());
	}
	
	private ActionListener listener(){
		ActionListener al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == manual){
					System.out.println("manual");
				}else if(e.getSource() == run){
					System.out.println("run");
				}
			}
		};
		return al;
}
}
