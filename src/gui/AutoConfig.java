package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AutoConfig extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton auto;
	private JButton run;
	private JLabel fn;
	private JLabel fp;
	private JLabel filter;
	
	public AutoConfig() {
		setLayout(null);
		setBounds(16, 227, 501, 154);
		this.setOpaque(true);
		this.setBackground(new Color(255,255,255,0));
		
		auto = new JButton("Automatic Config");
		auto.setBounds(18, 37, 162, 21);
		auto.setOpaque(false);
		auto.setBorderPainted(false);
		
		run = new JButton("Run Config");
		run.setBounds(18, 67, 162, 21);
		run.setOpaque(false);
		run.setBorderPainted(false);
		
		fn = new JLabel();
		fn.setBounds(345, 44, 30, 20);
		
		fp = new JLabel();
		fp.setBounds(345, 64, 30, 20); 
		
		filter = new JLabel();
		filter.setBounds(395, 90, 30, 20);
		
		add(auto);
		add(run);
		add(fn);
		add(fp);
		add(filter);
		
		
		auto.addActionListener(listener());
		run.addActionListener(listener());
		
	}
		
		private ActionListener listener(){
			ActionListener al = new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == auto){
						System.out.println("auto");
					}else if(e.getSource() == run){
						System.out.println("run");
					}
				}
			};
			return al;
	}
}
