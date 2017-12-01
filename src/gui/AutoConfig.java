package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import antiSpamFilter.AntiSpamFilterAutomaticConfiguration;
import mechanisms.Evaluation;
import mechanisms.FileReader;

/**
 * @author Tiago Almeida, Markiyan Pyekh
 *
 */
public class AutoConfig extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton auto;
	private JButton run;
	private JLabel fn;
	private JLabel fp;
	private JButton save;
	private JLabel filter;
	private Gui gui;
	
	/**
	 * Construtor da parte Automática da Gui
	 * @param gui
	 */
	public AutoConfig(Gui gui) {
		this.gui = gui;
		setLayout(null);
		setBounds(16, 227, 501, 154);
		this.setOpaque(true);
		this.setBackground(new Color(255,255,255,0));
		
		auto = new JButton("Automatic Config");
		auto.setBounds(18, 37, 162, 21);
		auto.setEnabled(false);
		
		run = new JButton("Run Config");
		run.setBounds(18, 67, 162, 21);
		run.setEnabled(false);
		
		save = new JButton("Save Config");
		save.setBounds(18, 97, 162, 21);
		save.setEnabled(false);
		
		fn = new JLabel("0");
		fn.setBounds(295, 44, 30, 20);
		
		fp = new JLabel("0");
		fp.setBounds(295, 64, 30, 20); 
		
		filter = new JLabel("0");
		filter.setBounds(310, 86, 60, 20);
		
		add(auto);
		add(run);
		add(fn);
		add(save);
		add(fp);
		add(filter);
		
		
		auto.addActionListener(listener());
		run.addActionListener(listener());
		save.addActionListener(listener());
		
	}
		
	/**
	 * Listener que especifica o que cada botão executa
	 * @return al
	 */
	private ActionListener listener(){
		ActionListener al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == auto){
					run.setEnabled(true);
				}else if(e.getSource() == run){
					try {
						AntiSpamFilterAutomaticConfiguration.AutomaticMode();
						Object[][] a = FileReader.readNSGAII();
						gui.getRightSide().updateAuto(a);
						save.setEnabled(true);
						updateStat();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else if(e.getSource() == save){
					FileReader.saveConfig(gui.getRightSide().getCurrent_auto());
				}
			}
		};
		return al;
	}

	/**
	 * Método que mantem o botão automático ativo
	 */
	public void enabled() {
		auto.setEnabled(true);
	}
		
	/**
	 * Método que actualiza os FN, FP e Erros
	 */
	private void updateStat(){
		String f = "";
		double[] a = new double[gui.getRightSide().getCurrent_auto().length];
		Object[][] b = gui.getRightSide().getCurrent_auto();
		for(int i = 0; i < a.length; i++){
			a[i] = (double) b[i][1];}
		f+=Evaluation.evaluate(a)[0];
		String ff = "";
		ff+= Evaluation.evaluate(a)[1];
		fn.setText(f);
		fp.setText(ff);
			
		int rate = (Evaluation.evaluate(a)[0]+ Evaluation.evaluate(a)[1]);
		String tt = "";
		tt+=rate;
		filter.setText(tt);
			
		repaint();
		gui.repaint();
	}
}