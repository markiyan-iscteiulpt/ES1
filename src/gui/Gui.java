package gui;

import java.awt.Dimension;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Gui extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private FileConfig file;
	private AutoConfig auto;
	private ManualConfig manual;
	private RightSide rightSide;
	private ImageIcon ico = new ImageIcon(Gui.class.getResource("/main_design.png"));
	private JLabel background;
	private JPanel main_panel;

	public Gui() throws IOException, URISyntaxException{
		setSize(new Dimension(1000, 615));
		setTitle("AntiSpam Filter [Leisure Mailbox]");
		
		main_panel = new JPanel();
		main_panel.setLayout(null);
		
		this.file = new FileConfig(this);
		this.auto = new AutoConfig(this);
		this.manual = new ManualConfig(this);
		this.rightSide = new RightSide(this);
		
		background = new JLabel(ico);
		background.setBounds(0, 0, 1000, 600);
		
		main_panel.add(file);
		main_panel.add(rightSide);
		main_panel.add(auto);
		main_panel.add(manual);
		main_panel.add(background);
	
		add(main_panel);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public RightSide getRightSide() {
		return rightSide;
	}
	
	public ManualConfig getManualConfig(){
		return manual;
	}
	
	public AutoConfig getAutoConfig(){
		return auto;
	}
}